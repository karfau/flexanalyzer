package test.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import test.model.ModelProvider;
import test.model.Person;

public class Print extends AbstractHandler
{
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException 
	{
		List<Person> personList = ModelProvider.getInstance().getPersons();
		
		for (Person p : personList)
		{
			System.out.println(p);
		}
		
		return null;
	}

}
