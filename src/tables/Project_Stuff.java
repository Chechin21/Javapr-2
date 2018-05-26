package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT_STUFF")
public class Project_Stuff {
	@Id
	@Column(name="project_stuff_id")
	private Long project_stuff_id;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name="function_id")
	private Project_Function function;
	
	@Column(name="salary")
	private Long salary;
	
	public Project_Stuff(){
		
	}

	public Long getProject_id() {
		if(project==null)
			return null;
		return project.getId();
	}

	public void setProject_id(Long project_id) {
		if(project==null)
			project=new Project();
		project.setId(project_id);
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

	public Long getFunction_id() {
		if(function==null)
			return null;
		return function.getId();
	}

	public void setFunction_id(Long function_id) {
		if(function==null)
			function=new Project_Function();
		function.setId(function_id);
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Long getProject_stuff_id() {
		return project_stuff_id;
	}

	public void setProject_stuff_id(Long project_stuff_id) {
		this.project_stuff_id = project_stuff_id;
	}
	
}