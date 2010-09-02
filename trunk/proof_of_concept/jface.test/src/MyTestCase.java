import junit.framework.TestCase;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCombo;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;

import test.View;

public class MyTestCase extends TestCase {
	public SWTWorkbenchBot bot = null;

	public MyTestCase() {
		bot = new SWTWorkbenchBot();
	}

	public void testPrint() throws Exception {
		SWTBotMenu file = bot.menu("Testing").menu("Print");
		file.click();
	}

	public void testAddPerson() throws Exception {
		SWTBotMenu file = bot.menu("Testing").menu("Add person");
		file.click();
		SWTBotText txt = bot.textWithLabel("First Name");
		txt.setText("Chris");
		SWTBotText txt2 = bot.textWithLabel("Last Name");
		txt2.setText("Sierigk");
		SWTBotCombo cmb = bot.comboBoxWithLabel("Gender");
		cmb.setSelection("male");
		bot.button("OK").click();
	}

	public void testSearchPerson() throws Exception {
		SWTBotText searchText = bot.textWithId("org.eclipse.swtbot.widget.key", View.ID_SEARCH_TEXT);
		searchText.setText("Zu");
		System.out.println("test");

	}
}
