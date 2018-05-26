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

import classes.PersonDAO;
import create_session.HibernateUtil;
import tables.Person;
import tables.Person;


public class PersonDAOImpl implements PersonDAO {
	
	public void addPerson(Person person) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(person);
	      session.getTransaction().commit();
	    }  finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}
	
	public void updatePerson(Long Person_id, Person person) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(person);
	      session.getTransaction().commit();
	    }  finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	public Person getPersonById(Long person_id) throws SQLException {
		Session session = null;
	    Person person = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      person = (Person) session.get(Person.class, person_id);
	    }  finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return person;
	  }

	public Collection<Person> getAllPersons() throws SQLException {
		 Session session = null;
		 List<Person> persons = new ArrayList<Person>();
		 try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      persons = session.createCriteria(Person.class).list();
		    }  finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return persons;
	}

	public void deletePerson(Person person) throws SQLException {
		  Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(person);
		      session.getTransaction().commit();
		    }  finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		
	}
	
	public Collection<Person> getPersonByFeature(Person person) throws SQLException {
		 Session session = null;
		    List<Person> persons = new ArrayList<Person>();
		    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
		    	Criteria crit=session.createCriteria(Person.class);
			      Long id=person.getId();
			      if(id!=null)
			    	  crit.add( Restrictions.eq("id", id) );
			      String name=person.getFirst_name();
			      if(name!=null)
			    	  crit.add( Restrictions.eq("first_name", name) );
			      String surename=person.getLast_name();
			      if(surename!=null)
			    	  crit.add( Restrictions.eq("last_name", surename) );
			      String address=person.getAddress();
			      if(address!=null)
			    	  crit.add( Restrictions.eq("address", address) );
			      Calendar stop_date=person.getDate_of_birth();
			      if(stop_date!=null)
			    	  crit.add( Restrictions.eq("date_of_birth", stop_date) );
			      String ed=person.getEducation();
			      if(ed!=null)
			    	  crit.add( Restrictions.eq("education", ed) );
			      Long ex=person.getExperience();
			      if(ex!=null)
			    	  crit.createAlias("exp","exp").add( Restrictions.eq("exp.id", ex) );
			      
			      persons = crit.list();
			      
		      session.getTransaction().commit();

		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return persons;
	}
}