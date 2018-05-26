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

public class Exptest {
	@Test
	public void getExperience() throws SQLException{
		Experience a=new Experience();
		a.setExp((long)1);
		a.setBonus((long)110);
		Experience b=new Experience();
		b=Factory.getInstance().getExperienceDAO().getExperienceById((long) 1);
		Assert.assertEquals(b.getExp(),a.getExp());
		Assert.assertEquals(b.getBonus(), a.getBonus());
	}
	@Test(dependsOnMethods = { "getExperience" })
	public void addExperience() throws SQLException {
		Experience a=new Experience();
		Experience b=new Experience();
		a.setExp((long) 5);
		a.setBonus((long) 100);
		Factory.getInstance().getExperienceDAO().addExperience(a);
		b=Factory.getInstance().getExperienceDAO().getExperienceById((long)5);
		Assert.assertEquals(b.getExp(),a.getExp());
		Assert.assertEquals(b.getBonus(),a.getBonus());
	}
	@Test(dependsOnMethods = { "getExperience","addExperience" })
	public void updateExperience() throws SQLException {
		Experience a=new Experience();
		Experience b=new Experience();
		a.setExp((long) 5);
		a.setBonus((long) 110);
		Factory.getInstance().getExperienceDAO().updateExperience(null,a);
		b=Factory.getInstance().getExperienceDAO().getExperienceById((long)5);
		Assert.assertEquals(b.getExp(),a.getExp());
		Assert.assertEquals(b.getBonus(),a.getBonus());
	}
	@Test(dependsOnMethods = {"getExperience","addExperience","updateExperience"})
	public void deleteExperience() throws SQLException {
		Experience a = new Experience();
		Experience b = new Experience();
		a.setExp((long) 5);
		Factory.getInstance().getExperienceDAO().deleteExperience(a);
		b=Factory.getInstance().getExperienceDAO().getExperienceById((long) 5);
		Assert.assertNull(b);
	}
	@Test(dependsOnMethods = { "getExperience","addExperience","updateExperience","deleteExperience" })
	public void getAllExperiences() throws SQLException {
		Experience a=new Experience();
		Experience b=new Experience();
		Collection<Experience> Experiences=Factory.getInstance().getExperienceDAO().getAllExperiences();
		Iterator<Experience> iterator = Experiences.iterator();
		long i=1;
		while (iterator.hasNext()) {
			a=Factory.getInstance().getExperienceDAO().getExperienceById(i);
			b=(Experience) iterator.next();
			Assert.assertEquals(b.getExp(),a.getExp());
			Assert.assertEquals(b.getBonus(),a.getBonus());
			i++;
		}
	}
	@Test(dependsOnMethods = { "getExperience","addExperience","updateExperience","deleteExperience" })
	public void getExperiencesByFeatureFull() throws SQLException {
		Experience a=new Experience();
		Experience b=new Experience();
		b.setExp((long) 1);
		b.setBonus((long) 110);
		Experience c=new Experience();
		Collection<Experience> Experiences=Factory.getInstance().getExperienceDAO().getExperienceByFeature(b);
		Iterator<Experience> iterator = Experiences.iterator();
		long i=1;
		Assert.assertEquals(Experiences.size(),1);
		while (iterator.hasNext()) {
			a=Factory.getInstance().getExperienceDAO().getExperienceById(i);
			c=(Experience) iterator.next();
			Assert.assertEquals(c.getExp(),a.getExp());
			Assert.assertEquals(c.getBonus(),a.getBonus());
			i++;
		}
	}
	@Test(dependsOnMethods = { "getExperience","addExperience","updateExperience","deleteExperience" })
	public void getExperiencesByFeatureEmpty() throws SQLException {
		Experience a=new Experience();
		Experience b=new Experience();
		Experience c=new Experience();
		Collection<Experience> Experiences=Factory.getInstance().getExperienceDAO().getExperienceByFeature(b);
		Iterator<Experience> iterator = Experiences.iterator();
		long i=1;
		Assert.assertEquals(Experiences.size(),4);
		while (iterator.hasNext()) {
		    a=Factory.getInstance().getExperienceDAO().getExperienceById(i);
		    c = (Experience) iterator.next();
		    Assert.assertEquals(c.getExp(),a.getExp());
			Assert.assertEquals(c.getBonus(),a.getBonus());
			i++;
	    }
	}
	
}