package classes;

import java.sql.SQLException;
import java.util.Collection;

import tables.Project_Function;



public interface Project_FunctionDAO{
	public void addProject_Function(Project_Function Project_Function) throws SQLException;
	public void updateProject_Function(Long Project_Function_id, Project_Function Project_Function) throws SQLException;
	public Project_Function getProject_FunctionById(Long Project_Function_id) throws SQLException;
	public Collection<Project_Function> getAllProject_Functions() throws SQLException;
	public void deleteProject_Function(Project_Function Project_Function) throws SQLException;
	public Collection<Project_Function> getProject_FunctionByFeature(Project_Function Project_Function) throws SQLException;
}
