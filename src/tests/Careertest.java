package tests;
import tables.Experience;
import tables.Career;

import factory.Factory;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Careertest {
	@Test
	public void getCareerById() throws SQLException{
		Career a=new Career();
		a.setCareer_id(1);
		a.setPerson_id(1);
		a.setPosition_id(4);
		a.setStart_date(new Calendar.Builder().setDate(2016,1,1).setTimeOfDay(00,00,0).build());
		a.setStop_datenew Calendar.Builder().setDate(2016,5,5).setTimeOfDay(00,00,0).build());
	}
	
}