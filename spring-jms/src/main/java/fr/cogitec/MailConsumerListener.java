package fr.cogitec;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MailConsumerListener implements MessageListener {
	@Autowired
	MailConverter mailConverter;
	@Autowired
	JmsTemplate jmsTemplate;

	@Override
	public void onMessage(Message msg) {
		Mail mail = (Mail) mailConverter.fromMessage(msg);
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
