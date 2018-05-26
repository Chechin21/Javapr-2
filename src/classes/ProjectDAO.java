package classes;

import java.sql.SQLException;
import java.util.Collection;

import tables.Position;
import tables.Project;

public interface ProjectDAO{
	public void addProject(Project Project) throws SQLException;
	public void updateProject(Long Project_id, Project Project) throws SQLException;
	public Project getProjectById(Long Project_id) throws SQLException;
	public Collection<Project> getAllProjects() throws SQLException;
	public void deleteProject(Project Project) throws SQLException;
	public Collection<Project> getProjectByFeature(Project project) throws SQLException;
}