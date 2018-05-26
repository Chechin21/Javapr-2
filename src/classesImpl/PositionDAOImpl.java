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

import classes.PositionDAO;
import create_session.HibernateUtil;
import tables.Position;


public class PositionDAOImpl implements PositionDAO {
	
	public void addPosition(Position position) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(position);
	      session.getTransaction().commit();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}
	
	public void updatePosition(Long Position_id, Position position) throws SQLException {
		Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.update(position);
	      session.getTransaction().commit();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	public Position getPositionById(Long position_id) throws SQLException {
		Session session = null;
	    Position position = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      position = (Position) session.get(Position.class, position_id);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return position;
	  }

	public Collection<Position> getAllPositions() throws SQLException {
		 Session session = null;
		 List<Position> positions = new ArrayList<Position>();
		 try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      positions = session.createCriteria(Position.class).list();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return positions;
	}

	public void deletePosition(Position position) throws SQLException {
		  Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(position);
		      session.getTransaction().commit();
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		
	}
	
	public Collection<Position> getPositionByFeature(Position position) throws SQLException {
		 Session session = null;
		    List<Position> positions = new ArrayList<Position>();
		    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
		    	Criteria crit=session.createCriteria(Position.class);
			      Long id=position.getId();
			      if(id!=null)
			    	  crit.add( Restrictions.eq("id", id) );
			      String name=position.getName();
			      if(name!=null)
			    	  crit.add( Restrictions.eq("name", name) );
			      positions = crit.list();
			      session.getTransaction().commit();
			  
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return positions;
	}
}