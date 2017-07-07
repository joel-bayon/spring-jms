package fr.cogitec;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MailExchangeListenerApp { 
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context =
				//new ClassPathXmlApplicationContext("mail.jms.xml");
				//new ClassPathXmlApplicationContext("mail.jms.local.tx.xml");
				new ClassPathXmlApplicationContext("mail.jms.xa.xml");
		MailProducer mp =  context.getBean(MailProducer.class);
		mp.sendMessage(new Mail(34, "Test Message"));
	    // not need explicit consumer anymore with listener ...
		Thread.sleep(10000);
		context.close();
	  } 
}
