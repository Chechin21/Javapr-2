package tests;
import tables.Experience;
import tables.Person;

import factory.Factory;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Persontest {
	@Test
	public void getPersonById() throws SQLException{
		Person a = new Person();
		a.setId((long)1);
		a.setFirst_name("sada");
		a.setLast_name("wwwa");
	    a.setAddress("address1a");
		a.setDate_of_birth(new Calendar.Builder().setDate(2014,3,20).setTimeOfDay(14,40,0).build());
		a.setEducation("adssdv");
		a.setExperience((long)1);
		Person b=new Person();
		b=Factory.getInstance().getPersonDAO().getPersonById((long) 1);
		Assert.assertEquals(b.getId(),a.getId());
		Assert.assertEquals(b.getAddress(), a.getAddress());
		Assert.assertEquals(b.getEducation(), a.getEducation());
		Assert.assertEquals(b.getFirst_name(), a.getFirst_name());
	    //Assert.assertEquals(b.getDate_of_birth().getTimeInMillis(), a.getDate_of_birth().getTimeInMillis());
		Assert.assertEquals(b.getExperience(), a.getExperience());
		Assert.assertEquals(b.getLast_name(), a.getLast_name());
	}
	@Test(dependsOnMethods = { "getPersonById" })
	public void addPerson() throws SQLException {
		Person a=new Person();
		a.setId((long)13);
		a.setFirst_name("sad");
		a.setLast_name("www");
	    a.setAddress("address1");
		a.setDate_of_birth(new Calendar.Builder().setDate(2015,3,20).setTimeOfDay(14,40,0).build());
		a.setEducation("adssd");
		a.setExperience((long)1);
		Factory.getInstance().getPersonDAO().addPerson(a);
		 
		Person b=new Person();
		b=Factory.getInstance().getPersonDAO().getPersonById((long) 13);
		Assert.assertEquals(b.getId(),a.getId());
		Assert.assertEquals(b.getAddress(), a.getAddress());
		Assert.assertEquals(b.getEducation(), a.getEducation());
		Assert.assertEquals(b.getFirst_name(), a.getFirst_name());
		Assert.assertEquals(b.getDate_of_birth().getTimeInMillis(), a.getDate_of_birth().getTimeInMillis());
		Assert.assertEquals(b.getExperience(), a.getExperience());
		Assert.assertEquals(b.getLast_name(), a.getLast_name());
	}
	@Test(dependsOnMethods = { "getPersonById","addPerson" })
	public void updatePerson() throws SQLException {
		Person a=new Person();
		a.setId((long)1);
		a.setFirst_name("sada");
		a.setLast_name("wwwa");
	    a.setAddress("address1a");
		a.setDate_of_birth(new Calendar.Builder().setDate(2014,3,20).setTimeOfDay(14,40,0).build());
		a.setEducation("adssdv");
		a.setExperience((long)1);
		Factory.getInstance().getPersonDAO().updatePerson(null, a);
		Person b=new Person();
		b=Factory.getInstance().getPersonDAO().getPersonById((long) 1);
		Assert.assertEquals(b.getId(),a.getId());
		Assert.assertEquals(b.getAddress(), a.getAddress());
		Assert.assertEquals(b.getEducation(), a.getEducation());
		Assert.assertEquals(b.getFirst_name(), a.getFirst_name());
		Assert.assertEquals(b.getDate_of_birth().getTimeInMillis(), a.getDate_of_birth().getTimeInMillis());
		Assert.assertEquals(b.getExperience(), a.getExperience());
		Assert.assertEquals(b.getLast_name(), a.getLast_name());
		
	}
	@Test(dependsOnMethods = { "getPersonById","addPerson","updatePerson" })
	public void deletePerson() throws SQLException {
		Person a=new Person();
		Person b=new Person();
		a.setId((long) 13);
		Factory.getInstance().getPersonDAO().deletePerson(a);
		b=Factory.getInstance().getPersonDAO().getPersonById((long) 13);
		Assert.assertNull(b);
	}
	@Test(dependsOnMethods = {"getPersonById","addPerson","updatePerson","deletePerson"})
	public void getAllPersons() throws SQLException {
		Person a=new Person();
		Person b=new Person();
		Collection<Person> Persons=Factory.getInstance().getPersonDAO().getAllPersons();
		Iterator<Person> iterator = Persons.iterator();
		long i=1;
		while (iterator.hasNext()) {
			a=Factory.getInstance().getPersonDAO().getPersonById(i);
			b=(Person) iterator.next();
			Assert.assertEquals(b.getId(),a.getId());
			Assert.assertEquals(b.getAddress(), a.getAddress());
			Assert.assertEquals(b.getEducation(), a.getEducation());
			Assert.assertEquals(b.getFirst_name(), a.getFirst_name());
			Assert.assertEquals(b.getDate_of_birth().getTimeInMillis(), a.getDate_of_birth().getTimeInMillis());
			Assert.assertEquals(b.getExperience(), a.getExperience());
			Assert.assertEquals(b.getLast_name(), a.getLast_name());
			i++;
		}
	}
	@Test(dependsOnMethods = { "getPersonById","addPerson","updatePerson","deletePerson" })
	public void getPersonsByFeatureFull() throws SQLException {
		Person a=new Person();
		Person b=new Person();
		b.setId((long)1);
		b.setFirst_name("sada");
		b.setLast_name("wwwa");
	    b.setAddress("address1a");
		b.setDate_of_birth(new Calendar.Builder().setDate(2014,3,20).setTimeOfDay(14,40,0).build());
		b.setEducation("adssdv");
		b.setExperience((long)1);
		Person c=new Person();
		Collection<Person> Persons=Factory.getInstance().getPersonDAO().getPersonByFeature(b);
		Iterator<Person> iterator = Persons.iterator();
		long i=1;
		Assert.assertEquals(Persons.size(),1);
		while (iterator.hasNext()) {
			a=Factory.getInstance().getPersonDAO().getPersonById(i);
			c=(Person) iterator.next();
			Assert.assertEquals(c.getId(),a.getId());
			Assert.assertEquals(c.getAddress(), a.getAddress());
			Assert.assertEquals(c.getEducation(), a.getEducation());
			Assert.assertEquals(c.getFirst_name(), a.getFirst_name());
			Assert.assertEquals(c.getDate_of_birth().getTimeInMillis(), a.getDate_of_birth().getTimeInMillis());
			Assert.assertEquals(c.getExperience(), a.getExperience());
			Assert.assertEquals(c.getLast_name(), a.getLast_name());
			i++;
		}
	}
	@Test(dependsOnMethods = { "getPersonById","addPerson","updatePerson","deletePerson" })
	  public void getPersonsByFeatureEmpty() throws SQLException {
		  Person a=new Person();
		  Person b=new Person();
			Person c=new Person();
			b.setExperience((long) 2);
			Collection<Person> Persons=Factory.getInstance().getPersonDAO().getPersonByFeature(b);
			Iterator<Person> iterator = Persons.iterator();
			long i=1;
			Assert.assertEquals(Persons.size(),3);
		    while (iterator.hasNext()) {
		        a=Factory.getInstance().getPersonDAO().getPersonById(i);
		        c = (Person) iterator.next();
		      	Assert.assertEquals(c.getId(),a.getId());
				Assert.assertEquals(c.getAddress(), a.getAddress());
				Assert.assertEquals(c.getEducation(), a.getEducation());
				Assert.assertEquals(c.getFirst_name(), a.getFirst_name());
				Assert.assertEquals(c.getDate_of_birth().getTimeInMillis(), a.getDate_of_birth().getTimeInMillis());
				Assert.assertEquals(c.getExperience(), a.getExperience());
				Assert.assertEquals(c.getLast_name(), a.getLast_name());
				i++;
		    }
	  }
		  	
		 
}