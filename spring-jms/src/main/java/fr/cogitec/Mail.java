package fr.cogitec;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mail implements Serializable {

		  private int mailId;
		  private String message;
		     
		 public Mail(){}; 
		 public Mail(int mailId, String message) {
		  super();
		  this.mailId = mailId;
		  this.message = message;
		 }
		 public int getMailId() {
		  return mailId;
		 }
		 public void setMailId(int mailId) {
		  this.mailId = mailId;
		 }
		 public String getMessage() {
		  return message;
		 }
		 public void setMessage(String message) {
		  this.message = message;
		 }
		@Override
		public String toString() {
			return "Mail [mailId=" + mailId + ", message=" + message + "]";
		}
		 
		}

