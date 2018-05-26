package classesImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import classes.ExperienceDAO;
import create_session.HibernateUtil;
import tables.Experience;


public class ExperienceDAOImpl implements ExperienceDAO {
	
	public void addExperience(Experience experience) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(experience);
	      session.getTransaction().commit();
	    }  finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}
	
	public void updateExperience(Long Experience_id, Experience experience) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(experience);
	      session.getTransaction().commit();
	    }  finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	public Experience getExperienceById(Long experience_id) throws SQLException {
		Session session = null;
	    Experience experience = null;
	    
	      session = HibernateUtil.getSessionFactory().openSession();
	      experience = (Experience) session.get(Experience.class, experience_id);
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    
	    return experience;
	  }

	public Collection<Experience> getAllExperiences() throws SQLException {
		 Session session = null;
		 List<Experience> experiences = new ArrayList<Experience>();
		 try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      experiences = session.createCriteria(Experience.class).list();
		    }  finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return experiences;
	}

	public void deleteExperience(Experience experience) throws SQLException {
		  Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(experience);
		      session.getTransaction().commit();
		    }  finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		
	}
	
	public Collection<Experience> getExperienceByFeature(Experience experience) throws SQLException {
		 Session session = null;
		    List<Experience> experiences = new ArrayList<Experience>();
		    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
		    	Criteria crit=session.createCriteria(Experience.class);
			      Long id=experience.getExp();
			      if(id!=null)
			    	  crit.add( Restrictions.eq("exp", id) );
			      Long name=experience.getBonus();
			      if(name!=null)
			    	  crit.add( Restrictions.eq("bonus", name) );
			      experiences = crit.list();
			      session.getTransaction().commit();

		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return experiences;
	}
}