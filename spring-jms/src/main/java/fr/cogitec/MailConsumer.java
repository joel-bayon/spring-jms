package fr.cogitec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {
	@Autowired
	JmsTemplate jmsTemplate;
	 public Mail receiveMessage() { 
	  return (Mail) jmsTemplate.receiveAndConvert("myQueue");
	 }
	}
