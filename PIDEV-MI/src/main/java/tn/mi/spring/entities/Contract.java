package tn.mi.spring.entities;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "T_CONTRACT")
public class Contract implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTRACT_ID")
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date begin_contract_date;

	@Temporal(TemporalType.DATE)
	private Date end_contract_date;

	@Temporal(TemporalType.DATE)
	private Date subscription_date;

	@Temporal(TemporalType.DATE)
	private Date cancel_date;
	
	@Column(name = "CONTRACT_SUBSCRIPTION_VALIDATE")
	private boolean subscription_validate;

	@Column(name = "CONTRACT_CANCELATION")
	private boolean cancellation;
	
	@ManyToOne
	Customer customer;

	public Contract() {
	}

	/**
	 * @param id
	 * @param begin_contract_date
	 * @param end_contract_date
	 * @param subscription_date
	 * @param cancel_date
	 * @param subscription_validate
	 * @param cancellation
	 */
	public Contract(Long id, Date begin_contract_date, Date end_contract_date, Date subscription_date, Date cancel_date,
			boolean subscription_validate, boolean cancellation) {
		super();
		this.id = id;
		this.begin_contract_date = begin_contract_date;
		this.end_contract_date = end_contract_date;
		this.subscription_date = subscription_date;
		this.cancel_date = cancel_date;
		this.subscription_validate = subscription_validate;
		this.cancellation = cancellation;
	}

	/**
	 * @param begin_contract_date
	 * @param end_contract_date
	 * @param subscription_date
	 * @param cancel_date
	 * @param subscription_validate
	 * @param cancellation
	 */
	public Contract(Date begin_contract_date, Date end_contract_date, Date subscription_date, Date cancel_date,
			boolean subscription_validate, boolean cancellation) {
		super();
		this.begin_contract_date = begin_contract_date;
		this.end_contract_date = end_contract_date;
		this.subscription_date = subscription_date;
		this.cancel_date = cancel_date;
		this.subscription_validate = subscription_validate;
		this.cancellation = cancellation;
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
	 * @return the begin_contract_date
	 */
	public Date getBegin_contract_date() {
		return begin_contract_date;
	}

	/**
	 * @param begin_contract_date the begin_contract_date to set
	 */
	public void setBegin_contract_date(Date begin_contract_date) {
		this.begin_contract_date = begin_contract_date;
	}

	/**
	 * @return the end_contract_date
	 */
	public Date getEnd_contract_date() {
		return end_contract_date;
	}

	/**
	 * @param end_contract_date the end_contract_date to set
	 */
	public void setEnd_contract_date(Date end_contract_date) {
		this.end_contract_date = end_contract_date;
	}

	/**
	 * @return the subscription_date
	 */
	public Date getSubscription_date() {
		return subscription_date;
	}

	/**
	 * @param subscription_date the subscription_date to set
	 */
	public void setSubscription_date(Date subscription_date) {
		this.subscription_date = subscription_date;
	}

	/**
	 * @return the cancel_date
	 */
	public Date getCancel_date() {
		return cancel_date;
	}

	/**
	 * @param cancel_date the cancel_date to set
	 */
	public void setCancel_date(Date cancel_date) {
		this.cancel_date = cancel_date;
	}

	/**
	 * @return the subscription_validate
	 */
	public boolean isSubscription_validate() {
		return subscription_validate;
	}

	/**
	 * @param subscription_validate the subscription_validate to set
	 */
	public void setSubscription_validate(boolean subscription_validate) {
		this.subscription_validate = subscription_validate;
	}

	/**
	 * @return the cancellation
	 */
	public boolean isCancellation() {
		return cancellation;
	}

	/**
	 * @param cancellation the cancellation to set
	 */
	public void setCancellation(boolean cancellation) {
		this.cancellation = cancellation;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
