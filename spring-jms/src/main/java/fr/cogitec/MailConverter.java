package fr.cogitec;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class MailConverter implements MessageConverter{
	
		 @Override 
		 public Object fromMessage(Message message) {
			 Mail mail = null;
			 try {
			    MapMessage mapMessage = (MapMessage) message;
			  	mail = new Mail();
				mail.setMailId(mapMessage.getInt("mailId"));
				mail.setMessage(mapMessage.getString("message"));
			 } catch (JMSException e) {
			 throw new MessageConversionException("MailConverter error",e) ;
			 }
			 return mail;
		}
		  
		 
		 @Override 
		 public Message toMessage(Object object, Session session) {
			 MapMessage message = null;
			 try {
				 	Mail mail = (Mail) object;
				 	message = session.createMapMessage();
				 	message.setInt("mailId", mail.getMailId());
				 	message.setString("message", mail.getMessage());
			 }
			 catch (JMSException e) {
				 throw new MessageConversionException("MailConverter error",e) ;
			}
			 return message;
		}
}
