package tests;
import tables.Experience;
import tables.Payment;
import tables.Person;

import factory.Factory;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Paytest {
	@Test
	public void getPaymentById() throws SQLException{
		Payment a = new Payment();
		a.setPayment_id((long) 1);
		a.setPay_date(new Calendar.Builder().setDate(2015,12,12).setTimeOfDay(00,00,0).build());
		a.setPerson_id((long) 1);
		a.setSum((long) 5100);
		Payment b=Factory.getInstance().getPaymentDAO().getPaymentById((long) 1);
		Assert.assertEquals(a.getPayment_id(), b.getPayment_id());
		
	}	
	@Test(dependsOnMethods = {"getPaymentById"})
	public void addPayment() throws SQLException{
		Payment a = new Payment();
		a.setPayment_id((long) 6);
		a.setPay_date(new Calendar.Builder().setDate(2015,12,12).setTimeOfDay(00,00,0).build());
		a.setPerson_id((long) 2);
		a.setSum((long) 321);
		Factory.getInstance().getPaymentDAO().addPayment(a);
	}
}