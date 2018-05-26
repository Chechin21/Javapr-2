package classesImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import classes.CareerDAO;
import create_session.HibernateUtil;
import tables.Career;
import java.util.Date;


public class CareerDAOImpl implements CareerDAO {
	
	public void addCareer(Career career) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(career);
	      session.getTransaction().commit();
	    }finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}
	
	public void updateCareer(Long Career_id, Career career) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(career);
	      session.getTransaction().commit();
	    }finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	public Career getCareerById(Long career_id) throws SQLException {
		Session session = null;
	    Career career = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      career = (Career) session.get(Career.class, career_id);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return career;
	  }

	public Collection<Career> getAllCareers() throws SQLException {
		 Session session = null;
		 List<Career> careers = new ArrayList<Career>();
		 try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      careers = session.createCriteria(Career.class).list();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return careers;
	}

	public void deleteCareer(Career career) throws SQLException {
		  Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(career);
		      session.getTransaction().commit();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		
	}
	
	public Collection<Career> getCareerByFeature(Career career) throws SQLException {
		 Session session = null;
		    List<Career> careers = new ArrayList<Career>();
		    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
		    	Criteria crit=session.createCriteria(Career.class);
			      Long id=career.getCareer_id();
			      if(id!=null)
			    	  crit.add( Restrictions.eq("career_id", id) );
			      Long position=career.getPosition_id();
			      if(position!=null)
			    	  crit.createAlias("position","position").add( Restrictions.eq("position.id", position) );
			      Long person=career.getPerson_id();
			      if(person!=null)
			    	  crit.createAlias("person","person").add( Restrictions.eq("person.id", person) );
			      Calendar start_date=career.getStart_date();
			      if(start_date!=null)
			    	  crit.add( Restrictions.eq("start_date", start_date) );
			      Calendar stop_date=career.getStop_date();
			      if(stop_date!=null)
			    	  crit.add( Restrictions.eq("stop_date", stop_date) );
			      careers = crit.list();
		      session.getTransaction().commit();

		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return careers;
	}
}