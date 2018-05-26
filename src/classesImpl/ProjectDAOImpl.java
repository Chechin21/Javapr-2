package classesImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import classes.ProjectDAO;
import create_session.HibernateUtil;
import tables.Project;


public class ProjectDAOImpl implements ProjectDAO {
	
	public void addProject(Project project) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(project);
	      session.getTransaction().commit();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}
	
	public void updateProject(Long Project_id, Project project) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(project);
	      session.getTransaction().commit();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	public Project getProjectById(Long project_id) throws SQLException {
		Session session = null;
	    Project project = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      project = (Project) session.get(Project.class, project_id);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return project;
	  }

	public Collection<Project> getAllProjects() throws SQLException {
		 Session session = null;
		 List<Project> projects = new ArrayList<Project>();
		 try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      projects = session.createCriteria(Project.class).list();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return projects;
	}

	public void deleteProject(Project project) throws SQLException {
		  Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(project);
		      session.getTransaction().commit();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		
	}
	
	public Collection<Project> getProjectByFeature(Project project) throws SQLException {
		 Session session = null;
		    List<Project> projects = new ArrayList<Project>();
		    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
		    	Criteria crit=session.createCriteria(Project.class);
			      Long id=project.getId();
			      if(id!=null)
			    	  crit.add( Restrictions.eq("id", id) );
			      String name=project.getName();
			      if(name!=null)
			    	  crit.add( Restrictions.eq("name", name) );
			      Calendar start_date=project.getStart_date();
			      if(start_date!=null)
			    	  crit.add( Restrictions.eq("start_date", start_date) );
			      Calendar stop_date=project.getStop_date();
			      if(stop_date!=null)
			    	  crit.add( Restrictions.eq("stop_date", stop_date) );
			      projects=crit.list();
			      session.getTransaction().commit();

		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return projects;
	}
}