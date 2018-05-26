package tables;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SALARY")
public class Salary {
	@Id
	@Column(name="salary_id")
	private Long salary_id;
	
	@ManyToOne
	@JoinColumn(name="position")
	private Position position;
	
	@Column(name="salary")
	private Long salary;
	
	@Column(name="start_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Calendar start_date;
	
	@Column(name="end_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Calendar end_date;
	
	public Salary(){
		
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

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Calendar getStart_date() {
		return start_date;
	}

	public void setStart_date(Calendar start_date) {
		this.start_date = start_date;
	}

	public Calendar getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Calendar end_date) {
		this.end_date = end_date;
	}

	public Long getSalary_id() {
		return salary_id;
	}

	public void setSalary_id(Long saalry_id) {
		this.salary_id = saalry_id;
	}
	
	
}