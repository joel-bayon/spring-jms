package fr.cogitec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SimpleJMSClientConsumer {
	@Autowired
	JmsTemplate jmsTemplate;
	@Value("${jms.queue.destination}")
	String destinationQueue;
	
	  public void run()  {
	    System.out.println(" *** begin Consumer ***"); 
	      while(true) {
		     String msg = (String)jmsTemplate.receiveAndConvert(destinationQueue); // Wait for a message
		     System.out.println(" Received: " + msg);
		     if ("0".equals(msg))
		      	break; 	
	      }
	      System.out.println(" *** end Consumer ***");
	  }
	  
	  public static void main(String[] args) {
		  ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.jms.xml");
		  context.getBean(SimpleJMSClientConsumer.class).run();
		  context.close();
	}
}

