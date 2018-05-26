package create_session;



import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import org.hibernate.*;
import org.hibernate.cfg.*;
public class HibernateUtil {
	 private static final SessionFactory sessionFactory;
	    static {
	      try {
	    	  Configuration configuration = new Configuration();
	    	  configuration.configure("Hibernate.cfg.xml");
	    	  
	    	  sessionFactory = configuration.buildSessionFactory();
	      } catch (Throwable ex) {
	        System.err.println("Initial SessionFactory creation failed." + ex);
	        throw new ExceptionInInitializerError(ex);
	      }
	    }
	    public static SessionFactory getSessionFactory() {
	      return sessionFactory;
	    }
}