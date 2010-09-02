package test.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import test.View;
import test.dialogs.AddPersonDialog;
import test.model.ModelProvider;

public class AddPerson extends AbstractHandler 
{
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException 
	{
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		ModelProvider persons = ModelProvider.getInstance();
		AddPersonDialog dialog = new AddPersonDialog(window.getShell());
		dialog.open();
		
		if (dialog.getPerson() != null)
		{
			persons.getPersons().add(dialog.getPerson());
			IWorkbenchPage page = window.getActivePage();
			View view = (View) page.findView(View.ID);
			view.getViewer().refresh();
		}
		return null;
	}
}
