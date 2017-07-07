package fr.cogitec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MailProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	@Transactional
	 public void sendMessage(final Mail mail) { 
	  jmsTemplate.convertAndSend("myQueue",mail);
	 }
	}
