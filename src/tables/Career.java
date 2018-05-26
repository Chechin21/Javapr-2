package tables;

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
@Table(name="CAREER")
public class Career{
	
	@Id
	@Column(name="career_id")
	private Long career_id;
	
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "position")
	private Position position;
	
	@Column(name="start_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Calendar start_date;
	
	@Column(name="stop_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Calendar stop_date;

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

	public Long getPosition_id() {
		if(position==null)
			return null;
		return position.getId();
	}

	public void setPosition_id(Long position_id) {
		if(position==null)
			position=new Position();
		position.setId(position_id);
	}

	public Calendar getStart_date() {
		return start_date;
	}

	public void setStart_date(Calendar start_date) {
		this.start_date = start_date;
	}

	public Calendar getStop_date() {
		return stop_date;
	}

	public void setStop_date(Calendar stop_date) {
		this.stop_date = stop_date;
	}

	public Career(){
	}

	public Long getCareer_id() {
		return career_id;
	}

	public void setCareer_id(Long career_id) {
		this.career_id = career_id;
	}
	
}