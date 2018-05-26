package tables;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PERSON")
public class Person {
	
	@Id
	@Column(name="person_id")
	private Long id;
	
	@Column(name="first_name",length=256)
	private String first_name;
	
	@Column(name="last_name",length=256)
	private String last_name;
	
	@Column(name="address",length=256)
	private String address;
	
	@Column(name="birth_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Calendar date_of_birth;
	
	@Column(name="education",length=256)
	private String education;
	
	@ManyToOne
	@JoinColumn(name="experience")
	private Experience exp;
	
	public Person(){	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Calendar getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Calendar date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Long getExperience() {
		if(exp==null)
			return null;
		return exp.getExp();
	}

	public void setExperience(Long experience_id) {
		if(exp==null)
			exp=new Experience();
		exp.setExp(experience_id);
	}
}
	
	