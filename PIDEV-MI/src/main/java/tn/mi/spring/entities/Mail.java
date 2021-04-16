package tn.mi.spring.entities;

import org.hibernate.engine.spi.SessionDelegatorBaseImpl;

public class Mail {
	private String sendTo;
	private String subject;
	private String message;
	private String from;
	/**
	 * @return the sendTo
	 */
	public String getSendTo() {
		return sendTo;
	}
	/**
	 * @param sendTo the sendTo to set
	 */
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	public Mail() {
		
	}
	
	
	

}
