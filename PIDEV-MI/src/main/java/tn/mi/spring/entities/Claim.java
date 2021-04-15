package tn.mi.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_CLAIM")
public class Claim implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLAIM_ID")
	private Long id;

	@Column(name = "CLAIM_SUBJECT", nullable = false)
	private String subject;

	@Column(name = "CLAIM_BODY", nullable = false)
	private String body;
    @Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date claim_date;

	@Column(name = "CLAIM_ANSWER")
	private String answer="";
	
	@ManyToOne(cascade = CascadeType.ALL)
	Customer customer;
	
	

	public Claim() {
	}

	/**
	 * @param id
	 * @param subject
	 * @param body
	 * @param claim_date
	 * @param answer
	 * @param solve
	 */
	public Claim(Long id, String subject, String body, Date claim_date, String answer, boolean solve) {
		super();
		this.id = id;
		this.subject = subject;
		this.body = body;
		this.claim_date = claim_date;
		this.answer = answer;
	}

	/**
	 * @param subject
	 * @param body
	 * @param claim_date
	 * @param answer
	 * @param solve
	 */
	public Claim(String subject, String body, Date claim_date, String answer) {
		super();
		this.subject = subject;
		this.body = body;
		this.claim_date = claim_date;
		this.answer = answer;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the claim_date
	 */
	public Date getClaim_date() {
		return claim_date;
	}

	/**
	 * @param claim_date the claim_date to set
	 */
	public void setClaim_date(Date claim_date) {
		this.claim_date = claim_date;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
