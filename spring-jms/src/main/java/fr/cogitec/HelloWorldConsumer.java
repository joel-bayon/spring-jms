package fr.cogitec;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldConsumer implements SessionAwareMessageListener<TextMessage> {
  
  @Override
  public void onMessage(TextMessage message, Session session) throws JMSException {
	  String threadName = Thread.currentThread().getName();
	  System.out.println("thread: " + threadName  
							+ " Received: "+ message.getText() ); }
}