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

import classes.SalaryDAO;
import create_session.HibernateUtil;
import tables.Salary;



public class SalaryDAOImpl implements SalaryDAO {
	
	public void addSalary(Salary salary) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(salary);
	      session.getTransaction().commit();
	    }finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}
	
	public void updateSalary(Long Salary_id, Salary salary) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(salary);
	      session.getTransaction().commit();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	public Salary getSalaryById(Long salary_id) throws SQLException {
		Session session = null;
	    Salary salary = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      salary = (Salary) session.get(Salary.class, salary_id);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return salary;
	  }

	public Collection<Salary> getAllSalarys() throws SQLException {
		 Session session = null;
		 List<Salary> salarys = new ArrayList<Salary>();
		 try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      salarys = session.createCriteria(Salary.class).list();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return salarys;
	}

	public void deleteSalary(Salary salary) throws SQLException {
		  Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(salary);
		      session.getTransaction().commit();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		
	}
	
	public Collection<Salary> getSalaryByFeature(Salary salary) throws SQLException {
		 Session session = null;
		    List<Salary> salarys = new ArrayList<Salary>();
		    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
		    	Criteria crit=session.createCriteria(Salary.class);
			      Long id=salary.getSalary_id();
			      if(id!=null)
			    	  crit.add( Restrictions.eq("salary_id", id) );
			      Long position=salary.getPosition_id();
			      if(position!=null)
			    	  crit.add( Restrictions.eq("position", position) );
			      Long salaryy=salary.getSalary();
			      if(salaryy!=null)
			    	  crit.add( Restrictions.eq("salary", salaryy) );
			      Calendar start_date=salary.getStart_date();
			      if(start_date!=null)
			    	  crit.add( Restrictions.eq("start_date", start_date) );
			      Calendar stop_date=salary.getEnd_date();
			      if(stop_date!=null)
			    	  crit.add( Restrictions.eq("end_date", stop_date) );
			      salarys=crit.list();
		      session.getTransaction().commit();

		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return salarys;
	}
}