package fr.cogitec;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class MailConsumerListenerBean {
	@Autowired
	MailConverter mailConverter;
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Transactional
	@JmsListener(destination="myQueue", containerFactory="mailContainer")
	public void onMail(Mail mail) {
		System.out.println(" mail received : " + mail);
		jmsTemplate.send("queue.delegate", new MessageCreator() {
			@Override
			public Message createMessage(Session s) throws JMSException {
				System.out.println(" send to queue.delegate : " + mail);
				return s.createObjectMessage(mail);
			}
		});
		// assumption for an error 
		throw new RuntimeException();
	}
	
	}
