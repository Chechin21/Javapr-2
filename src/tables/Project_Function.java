package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT_FUNCTION")
public class Project_Function {
	
	@Id
	@Column(name="function_id")
	private Long id;
	
	@Column(name="name",length=256)
	private String name;
	
	public Project_Function(){
		
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
	
}