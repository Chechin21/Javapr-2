package classesImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import classes.Project_StuffDAO;
import create_session.HibernateUtil;
import tables.Project_Stuff;


public class Project_StuffDAOImpl implements Project_StuffDAO {
	
	public void addProject_Stuff(Project_Stuff project_stuff) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(project_stuff);
	      session.getTransaction().commit();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}
	
	public void updateProject_Stuff(Long Project_Stuff_id, Project_Stuff project_stuff) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(project_stuff);
	      session.getTransaction().commit();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	public Project_Stuff getProject_StuffById(Long project_stuff_id) throws SQLException {
		Session session = null;
	    Project_Stuff project_stuff = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      project_stuff = (Project_Stuff) session.get(Project_Stuff.class, project_stuff_id);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return project_stuff;
	  }

	public Collection<Project_Stuff> getAllProject_Stuffs() throws SQLException {
		 Session session = null;
		 List<Project_Stuff> project_stuffs = new ArrayList<Project_Stuff>();
		 try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      project_stuffs = session.createCriteria(Project_Stuff.class).list();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return project_stuffs;
	}

	public void deleteProject_Stuff(Project_Stuff project_stuff) throws SQLException {
		  Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(project_stuff);
		      session.getTransaction().commit();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		
	}
	
	public Collection<Project_Stuff> getProject_StuffByFeature(Project_Stuff project_stuff) throws SQLException {
		 Session session = null;
		    List<Project_Stuff> project_stuffs = new ArrayList<Project_Stuff>();
		    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
		    	Criteria crit=session.createCriteria(Project_Stuff.class);
			      Long id=project_stuff.getProject_stuff_id();
			      if(id!=null)
			    	  crit.add( Restrictions.eq("project_stuff_id", id) );
			      Long project=project_stuff.getProject_id();
			      if(project!=null)
			    	  crit.createAlias("project","project").add( Restrictions.eq("project.id", project)); 
			      Long person=project_stuff.getPerson_id();
			      if(person!=null)
			    	  crit.createAlias("person","person").add( Restrictions.eq("person.id", person));
			      Long salary=project_stuff.getSalary();
			      if(salary!=null)
			    	  crit.add( Restrictions.eq("salary", salary) );
			      Long function=project_stuff.getFunction_id();
			      if(function!=null)
			    	  crit.createAlias("function","function").add( Restrictions.eq("function.id", function));
			      project_stuffs=crit.list();
		      session.getTransaction().commit();

		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return project_stuffs;
	}
}