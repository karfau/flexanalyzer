package de.karfau.flex_analyzer.ui.views;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.PropertySheetPage;

import de.karfau.flex_analyzer.model.Activator;
import de.karfau.flex_analyzer.model.IAsFunction;
import de.karfau.flex_analyzer.model.ModelProvider;

public class SequenceView extends ViewPart implements ISelectionListener {

	public static final String ID = "de.karfau.flex_analyzer.ui.views.SequenceView";

	private PropertySheetPage propSheetPage = new PropertySheetPage();
	private TreeViewer treeViewer;

	public SequenceView() {
	}

	public void createPartControl(Composite parent) {
		//Initialize dependencies
		Activator.getSharedInstance().setSite(getSite());
		System.out.println("setting Activator.getSharedInstance().site to " + getSite());

		//treeViewer = new TreeViewer(parent);
		//treeViewer.setContentProvider(getModel().getTreeContentProvider());
		createToolBar();

		treeViewer = new TreeViewer(new Tree(parent, SWT.SINGLE));
		treeViewer.setContentProvider(new SVContentProvider());
		treeViewer.setLabelProvider(new SVLabelProvider());
		
		propSheetPage.createControl(parent);
		//propSheetPage.setPropertySourceProvider(new FunctionPropertySourceProvider());
		ISelectionService selServ = getSite().getWorkbenchWindow().getSelectionService();
		selServ.addSelectionListener(this);
		selServ.addPostSelectionListener(this);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		System.out.println("recieved selection " + selection);
		propSheetPage.selectionChanged(part, selection);
		IAdapterFactory factory = Activator.getSharedInstance().getAdapterFactory();
		if(factory != null){
			IAsFunction input = (IAsFunction) factory.getAdapter(selection, IAsFunction.class);
			System.out.println("transformed selection \n\tselection: "+selection+" to \n\t input: "+input);
			if(treeViewer != null)
				treeViewer.setInput(input);

		}
	}

	private void createToolBar() {
		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
		mgr.add(new Action() {
			public void run() {
				System.out.println("testButton");
			}
		});
	}

	private ModelProvider getModel() {
		Activator activator = Activator.getSharedInstance();
		if (activator.getSite() == null)
			activator.setSite(getSite());

		return activator.getModelProvider();
	}
}