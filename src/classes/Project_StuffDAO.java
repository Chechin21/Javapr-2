package classes;
import java.sql.SQLException;
import java.util.Collection;

import tables.Project_Stuff;



public interface Project_StuffDAO{
	public void addProject_Stuff(Project_Stuff Project_Stuff) throws SQLException;
	public void updateProject_Stuff(Long Project_Stuff_id, Project_Stuff Project_Stuff) throws SQLException;
	public Project_Stuff getProject_StuffById(Long Project_Stuff_id) throws SQLException;
	public Collection<Project_Stuff> getAllProject_Stuffs() throws SQLException;
	public void deleteProject_Stuff(Project_Stuff Project_Stuff) throws SQLException;
	public Collection<Project_Stuff> getProject_StuffByFeature(Project_Stuff Project_Stuff) throws SQLException;
}
