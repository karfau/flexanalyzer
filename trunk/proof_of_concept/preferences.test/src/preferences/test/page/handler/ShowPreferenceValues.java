package preferences.test.page.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import preferences.test.Activator;

public class ShowPreferenceValues extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveWorkbenchWindowChecked(event).getShell();
		String myPrefString = Activator.getDefault().getPreferenceStore().getString("MYSTRING1");
		MessageDialog.openInformation(shell, "Info", myPrefString);
		Boolean myPrefBoolean = Activator.getDefault().getPreferenceStore().getBoolean("BOOLEAN_VALUE");
		MessageDialog.openInformation(shell, "Info", myPrefBoolean.toString());
		
		return null;
	}

}
