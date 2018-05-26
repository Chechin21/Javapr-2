package tables;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PROJECT")
public class Project {
	
	@Id
	@Column(name="project_id")
	private Long id;
	
	@Column(name="name",length=256)
	private String name;
	
	@Column(name="start_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Calendar start_date;
	
	@Column(name="stop_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Calendar stop_date;
	
	public Project(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}