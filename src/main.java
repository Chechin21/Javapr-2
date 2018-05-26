import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import factory.Factory;
import tables.Person;
import tables.Project;
import tables.*;


public class main {
	 public static void main(String[] args) throws SQLException {
		Payment a = new Payment();
		a.setPayment_id((long) 14);
		a.setPerson_id((long) 12);
		a.setPay_date(null);
		a.setSum((long) 32);
		Factory.getInstance().getPaymentDAO().addPayment(a);
		 /*  	Experience b=new Experience();
		  	b.setExp((long)20);
		  	b.setBonus((long)2300);
		  	Factory.getInstance().getExperienceDAO().updateExperience((long)1,b);
		  	/*Position a=new Position();
		  	a.setId((long)20);
		  	a.setName("sadasd");
		  	Position b=Factory.getInstance().getPositionDAO().getPositionById((long) 1);
		  	*/
		    
		 
	//	 	Position a=Factory.getInstance().getPositionDAO().getPositionById((long)1);
	//	  	System.out.println("person : " + a.getName());
		  	
		  	//Factory.getInstance().getPositionDAO().updatePosition((long)1,a);
		 	/*Person a=new Person();
		  	a.setId((long)7);
		  	a.setFirst_name("sd");
		  	a.setLast_name("ssd");
		  	a.setAddress("address");
		  	a.setDate_of_birth(new Calendar.Builder().setDate(2015,3,20).setTimeOfDay(14,30,0).build());
		  	a.setEducation("asd");
		  	a.setExperience((long)2);*/

		  	/*a.setExperience((long)12);
		  	Factory.getInstance().getPersonDAO().addPerson(a);*/
		   /* Person a = new Person();
		    a.setExperience((long) 1);
		    System.out.println("persontest ");
		  	Collection<Person> b=Factory.getInstance().getPersonDAO().getPersonByFeature(a);
		  /*	while (iterator.hasNext()) {
		  		Person c=(Person) iterator.next();
		  		System.out.println("person : " + c.getFirst_name());
		  	}*/
		 // 	System.out.println("personew : " + b.size()); 
	 }
}

/*package create_session;



import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
    static {
      try {
        sessionFactory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
      }
    }

    public static SessionFactory getSessionFactory() {
      return sessionFactory;
    }
}*/