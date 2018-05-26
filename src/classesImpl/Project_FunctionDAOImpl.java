package classesImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import classes.Project_FunctionDAO;
import create_session.HibernateUtil;
import tables.Project_Function;

public class Project_FunctionDAOImpl implements Project_FunctionDAO {
	
	public void addProject_Function(Project_Function project_function) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(project_function);
	      session.getTransaction().commit();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}
	
	public void updateProject_Function(Long Project_Function_id, Project_Function project_function) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(project_function);
	      session.getTransaction().commit();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	public Project_Function getProject_FunctionById(Long project_function_id) throws SQLException {
		Session session = null;
	    Project_Function project_function = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      project_function = (Project_Function) session.get(Project_Function.class, project_function_id);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return project_function;
	  }

	public Collection<Project_Function> getAllProject_Functions() throws SQLException {
		 Session session = null;
		 List<Project_Function> project_functions = new ArrayList<Project_Function>();
		 try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      project_functions = session.createCriteria(Project_Function.class).list();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return project_functions;
	}

	public void deleteProject_Function(Project_Function project_function) throws SQLException {
		  Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(project_function);
		      session.getTransaction().commit();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		
	}
	
	public Collection<Project_Function> getProject_FunctionByFeature(Project_Function project_function) throws SQLException {
		 Session session = null;
		    List<Project_Function> project_functions = new ArrayList<Project_Function>();
		    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
		    	Criteria crit=session.createCriteria(Project_Function.class);
			      Long id=project_function.getId();
			      if(id!=null)
			    	  crit.add( Restrictions.eq("id", id) );
			      String name=project_function.getName();
			      if(name!=null)
			    	  crit.add( Restrictions.eq("name", name) );
			      project_functions = crit.list();
			      session.getTransaction().commit();

		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return project_functions;
	}
}