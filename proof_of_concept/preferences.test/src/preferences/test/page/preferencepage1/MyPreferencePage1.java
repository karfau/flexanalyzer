package preferences.test.page.preferencepage1;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import preferences.test.Activator;

public class MyPreferencePage1 extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public MyPreferencePage1() {
		super(GRID);
	}
	
	@Override
	protected void createFieldEditors() {
		addField(new DirectoryFieldEditor("PATH", "&Directory preference:", 
						getFieldEditorParent()));
		addField(new BooleanFieldEditor("BOOLEAN_VALUE", 
						"&An example of a boolean preference", getFieldEditorParent()));
		addField(new RadioGroupFieldEditor("CHOICE",
						"An example of a multiple-choice preference", 1,
						new String[][] { { "&Choice 1", "choice1" },
										{ "&Choice 2", "choice2" } }, getFieldEditorParent()));
		addField(new StringFieldEditor("MYSTRING1", "A &text preference:", 
						getFieldEditorParent()));
		addField(new StringFieldEditor("MYSTRING2", "A &text preferences:", 
						getFieldEditorParent()));
	}
	
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("A demonstration of a preference page implementation");
	}
}
