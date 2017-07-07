package fr.cogitec;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MailExchangeApp { 
	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context =
			     new ClassPathXmlApplicationContext("mail.jms.xml");
		MailProducer mp =  context.getBean(MailProducer.class);
		MailConsumer mc =  context.getBean(MailConsumer.class);
		mp.sendMessage(new Mail(34, "Test Message"));
		System.out.println(mc.receiveMessage());
	   	context.close();
	   } 
	

}
