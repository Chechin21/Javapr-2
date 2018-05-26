package tables;

import java.util.Calendar;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="PAYMENT")
public class Payment {
	
	@Id
	@Column(name="payment_id")
	private Long payment_id;
	
	@Column(name="pay_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Calendar pay_date;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;
	
	@Column(name="summary")
	private Long sum;
	
	public Payment(){
	}
	
	public Long getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}

	public Calendar getPay_date() {
		return pay_date;
	}

	public void setPay_date(Calendar pay_date) {
		this.pay_date = pay_date;
	}


	public Long getSum() {
		return sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}

	public Long getPerson_id() {
		if(person==null)
			return null;
		return person.getId();
	}

	public void setPerson_id(Long person_id) {
		if(person==null)
			person=new Person();
		person.setId(person_id);
	}

}
