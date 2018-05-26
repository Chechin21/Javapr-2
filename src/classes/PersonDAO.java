package classes;

import java.sql.SQLException;
import java.util.Collection;

import tables.Person;


public interface PersonDAO{
	public void addPerson(Person person) throws SQLException;
	public void updatePerson(Long Person_id, Person person) throws SQLException;
	public Person getPersonById(Long person_id) throws SQLException;
	public Collection<Person> getAllPersons() throws SQLException;
	public void deletePerson(Person person) throws SQLException;
	public Collection<Person> getPersonByFeature(Person Person) throws SQLException;
}



