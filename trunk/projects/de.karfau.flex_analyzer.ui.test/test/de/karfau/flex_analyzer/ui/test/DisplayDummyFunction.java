package de.karfau.flex_analyzer.ui.test;


import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.views.properties.PropertySheet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.karfau.flex_analyzer.model.dummy.DummyAdapterFactory;
import de.karfau.flex_analyzer.model.dummy.DummyAsFunction;
import de.karfau.flex_analyzer.ui.views.SequenceView;

public class DisplayDummyFunction {

	SWTWorkbenchBot bot = new SWTWorkbenchBot();

	DummyAsFunction function;
	SWTBotTree botable;
	SWTBotView botview;
	//STWB
	SequenceView sequenceView;
	PropertySheet propertyView;

	@Before
	public void setUp() throws Exception {
		function = DummyAdapterFactory.function;

//		= new DummyAsFunction();
//		function.setName("myFunction");
//		function.setAccessType("private");
		//sequenceView = Activator.getDefault().sequenceView;
		botable = bot.tree();
		botview = bot.viewById(SequenceView.ID);
		sequenceView = (SequenceView)botview.getViewReference().getPart(false);
		botview = bot.viewById("org.eclipse.ui.views.PropertySheet");//SequenceView.ID);
		propertyView = (PropertySheet)botview.getViewReference().getPart(false);
		botable.display.syncExec(new Runnable(){

			@Override
			public void run() {
				System.out.println("selection changed was called");
				sequenceView.selectionChanged(sequenceView, new StructuredSelection());
				propertyView.selectionChanged(sequenceView, new StructuredSelection());
			}

		});
		//sequenceView. getSite().getWorkbenchWindow().getSelectionService(). selectionChanged(sequenceView, new StructuredSelection());
	}

	@Test
	public void givenAFunctionShouldDisplayProperties(){

		@SuppressWarnings("unused")
		SWTBotTreeItem[] items = botable.getAllItems();


		System.out.println("Hallo");
//		Composite sequenceView = botable.widget.getParent();
//		while(sequenceView != null){//!(sequenceView instanceof SequenceView) &&
//			sequenceView = sequenceView.getParent();
//		}
//		assertThat(sequenceView, allOf(notNullValue(),instanceOf(SequenceView.class)));
//		SWTBotTreeItem item = botable.getTreeItem("Info");
//		assertThat(item.getNode(FunctionProperties.NAME.toString()), notNullValue());
	}

	@After
	public void tearDown() throws Exception {
	}

}
