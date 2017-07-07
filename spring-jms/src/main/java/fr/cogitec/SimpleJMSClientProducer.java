package fr.cogitec;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SimpleJMSClientProducer {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue.destination}")
	String destinationQueue;
	
	 public void run() {
		 
  		Scanner clavier = new Scanner(System.in);
  		System.out.println(" *** begin Producer ***");
		while(true) {
			// send a message
			System.out.print("enter a text : ");
			String text = clavier.nextLine();
			jmsTemplate.convertAndSend(destinationQueue, text); 
			System.out.println(" Sent: " + text); 
			if("0".equals(text))
				break;
		}
		System.out.println(" *** end Producer ***"); 
		clavier.close();
		
	}
	 
	 public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.jms.xml");
		context.getBean(SimpleJMSClientProducer.class).run();
		context.close();
	} 
}

