package classes;

import java.sql.SQLException;
import java.util.Collection;
import tables.Career;



public interface CareerDAO{
	public void addCareer(Career Career) throws SQLException;
	public void updateCareer(Long Career_id, Career Career) throws SQLException;
	public Career getCareerById(Long Career_id) throws SQLException;
	public Collection<Career> getAllCareers() throws SQLException;
	public void deleteCareer(Career Career) throws SQLException;
	public Collection<Career> getCareerByFeature(Career Career) throws SQLException;
}