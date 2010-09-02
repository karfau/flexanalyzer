package test.model;

import java.util.ArrayList;
import java.util.List;

public class ModelProvider 
{
	private static ModelProvider content;
	private List<Person> persons;
	
	private ModelProvider()
	{
		persons = new ArrayList<Person>();
		Person person;
		person = new Person("Rainer", "Zufall", "male", true);
		persons.add(person);
		person = new Person("Rainer", "Babbel", "male", true);
		persons.add(person);
		person = new Person("Marie", "Darms", "female", false);
		persons.add(person);
		person = new Person("Holger", "Adams", "male", true);
		persons.add(person);
	}
	
	public static synchronized ModelProvider getInstance()
	{
		if (content != null)
		{
			return content;
		}
		content = new ModelProvider();
		return content;
	}
	
	public List<Person> getPersons()
	{
		return persons;
	}
}
