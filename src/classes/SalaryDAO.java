package classes;

import java.sql.SQLException;
import java.util.Collection;

import tables.Career;
import tables.Salary;



public interface SalaryDAO{
	public void addSalary(Salary Salary) throws SQLException;
	public void updateSalary(Long Salary_id, Salary Salary) throws SQLException;
	public Salary getSalaryById(Long Salary_id) throws SQLException;
	public Collection<Salary> getAllSalarys() throws SQLException;
	public void deleteSalary(Salary Salary) throws SQLException;
	public Collection<Salary> getSalaryByFeature(Salary Salary) throws SQLException;
}