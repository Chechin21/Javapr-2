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

import classes.PaymentDAO;
import create_session.HibernateUtil;
import tables.Payment;
import tables.Payment;


public class PaymentDAOImpl implements PaymentDAO {
	
	public void addPayment(Payment payment) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(payment);
	      session.getTransaction().commit();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}
	
	public void updatePayment(Long Payment_id, Payment payment) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(payment);
	      session.getTransaction().commit();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	public Payment getPaymentById(Long payment_id) throws SQLException {
		Session session = null;
	    Payment payment = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      payment = (Payment) session.get(Payment.class, payment_id);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return payment;
	  }

	public Collection<Payment> getAllPayments() throws SQLException {
		 Session session = null;
		 List<Payment> payments = new ArrayList<Payment>();
		 try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      payments = session.createCriteria(Payment.class).list();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return payments;
	}

	public void deletePayment(Payment payment) throws SQLException {
		  Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(payment);
		      session.getTransaction().commit();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		
	}
	
	public Collection<Payment> getPaymentByFeature(Payment payment) throws SQLException {
		 Session session = null;
		    List<Payment> payments = new ArrayList<Payment>();
		    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
		    	Criteria crit=session.createCriteria(Payment.class);
			      Long id=payment.getPayment_id();
			      if(id!=null)
			    	  crit.add( Restrictions.eq("payment_id", id) );
			      Long sum=payment.getSum();
			      if(sum!=null)
			    	  crit.add( Restrictions.eq("sum", sum) );
			      Long person=payment.getPerson_id();
			      if(person!=null)
			    	  crit.createAlias("person","person").add( Restrictions.eq("person.id", person));
			      Calendar start_date=payment.getPay_date();
			      if(start_date!=null)
			    	  crit.add( Restrictions.eq("pay_date", start_date) );
			    
			      payments = crit.list();
		      session.getTransaction().commit();

		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return payments;
	}
}