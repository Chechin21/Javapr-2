package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EXPERIENCE")
public class Experience {
	
	@Id
	@Column(name="experience")
	private Long exp;
	
	@Column(name="bonus")
	private Long bonus;
	
	public Experience(){
		
	}

	public Long getExp() {
		return exp;
	}

	public void setExp(Long exp) {
		this.exp = exp;
	}

	public Long getBonus() {
		return bonus;
	}

	public void setBonus(Long bonus) {
		this.bonus = bonus;
	}
	
}