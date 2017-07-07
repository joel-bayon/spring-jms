package fr.cogitec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component	 
public class HelloWorldProducer implements Runnable {
	
 	@Autowired
  	private JmsTemplate jmsTemplate;
	public void run () {
	  jmsTemplate.convertAndSend(
			"Hello world! From: " + Thread.currentThread().getName()); }
}
