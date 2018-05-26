package factory;

import classes.CareerDAO;
import classes.ExperienceDAO;
import classes.PaymentDAO;
import classes.PersonDAO;
import classes.PositionDAO;
import classes.ProjectDAO;
import classes.Project_FunctionDAO;
import classes.Project_StuffDAO;
import classes.SalaryDAO;
import classesImpl.CareerDAOImpl;
import classesImpl.ExperienceDAOImpl;
import classesImpl.PaymentDAOImpl;
import classesImpl.PersonDAOImpl;
import classesImpl.PositionDAOImpl;
import classesImpl.ProjectDAOImpl;
import classesImpl.Project_FunctionDAOImpl;
import classesImpl.Project_StuffDAOImpl;
import classesImpl.SalaryDAOImpl;

public class Factory {
	  private static CareerDAO careerDAO = null;
	  private static ExperienceDAO experienceDAO = null;
	  private static PaymentDAO paymentDAO = null;
	  private static PersonDAO personDAO = null;
	  private static ProjectDAO projectDAO = null;
	  private static Project_StuffDAO project_stuffDAO = null;
	  private static Project_FunctionDAO project_functionDAO = null;
	  private static SalaryDAO salaryDAO = null;
	  private static PositionDAO positionDAO = null;
	  private static Factory instance = null;
	  
	  public static synchronized Factory getInstance(){
		  if (instance == null){
			  instance = new Factory();
		  }
		  return instance;
	  }

	  public CareerDAO getCareerDAO(){
		  if (careerDAO == null){
		      careerDAO = new CareerDAOImpl();
		  }
		  return careerDAO;
	  }

	  public static ExperienceDAO getExperienceDAO() {
	  	  if (experienceDAO == null){
		      experienceDAO = new ExperienceDAOImpl();
		  }
		  return experienceDAO;
	  }

	public static PaymentDAO getPaymentDAO() {
		if (paymentDAO == null){
		    paymentDAO = new PaymentDAOImpl();
		}
		return paymentDAO;
	}

	public static PersonDAO getPersonDAO() {
		if (personDAO == null){
	        personDAO = new PersonDAOImpl();
		}
		return personDAO;
	}

	public static ProjectDAO getProjectDAO() {
		if (projectDAO == null){
		    projectDAO = new ProjectDAOImpl();
		}
		return projectDAO;
	}

	public static Project_StuffDAO getProject_stuffDAO() {
		if (project_stuffDAO == null){
		    project_stuffDAO = new Project_StuffDAOImpl();
		}

		return project_stuffDAO;
	}

	public static Project_FunctionDAO getProject_functionDAO() {
		if (project_functionDAO == null){
		    project_functionDAO = new Project_FunctionDAOImpl();
		}
		return project_functionDAO;
	}

	public static SalaryDAO getSalaryDAO() {
		if (salaryDAO == null){
		    salaryDAO = new SalaryDAOImpl();
		}
		return salaryDAO;
	}

	public static PositionDAO getPositionDAO() {
		if (positionDAO == null){
		    positionDAO = new PositionDAOImpl();
		}
		return positionDAO;
	}



}