package classes;

import java.sql.SQLException;
import java.util.Collection;
import tables.Experience;



public interface ExperienceDAO{
	public void addExperience(Experience Experience) throws SQLException;
	public void updateExperience(Long Experience_id, Experience Experience) throws SQLException;
	public Experience getExperienceById(Long Experience_id) throws SQLException;
	public Collection<Experience> getAllExperiences() throws SQLException;
	public void deleteExperience(Experience Experience) throws SQLException;
	public Collection<Experience> getExperienceByFeature(Experience Experience) throws SQLException;

}
