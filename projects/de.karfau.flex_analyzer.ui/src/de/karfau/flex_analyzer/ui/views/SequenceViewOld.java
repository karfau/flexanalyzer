package de.karfau.flex_analyzer.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class SequenceViewOld extends ViewPart implements ISelectionListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "de.karfau.flex_analyzer.ui.views.SequenceView";

	//private PropertySheetPage propSheetPage = new PropertySheetPage();


	//private TableViewer propertyTable;

	//	private TreeViewer viewer;
	//	private DrillDownAdapter drillDownAdapter;
	//	private Action action1;
	//	private Action action2;
	//	private Action doubleClickAction;

	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content
	 * (like Task List, for example).
	 */

	//	class TreeObject implements IAdaptable {
	//		private String name;
	//		private TreeParent parent;
	//
	//		public TreeObject(String name) {
	//			this.name = name;
	//		}
	//		public String getName() {
	//			return name;
	//		}
	//		public void setParent(TreeParent parent) {
	//			this.parent = parent;
	//		}
	//		public TreeParent getParent() {
	//			return parent;
	//		}
	//		public String toString() {
	//			return getName();
	//		}
	//		public Object getAdapter(Class key) {
	//			return null;
	//		}
	//	}
	//
	//	class TreeParent extends TreeObject {
	//		private ArrayList children;
	//		public TreeParent(String name) {
	//			super(name);
	//			children = new ArrayList();
	//		}
	//		public void addChild(TreeObject child) {
	//			children.add(child);
	//			child.setParent(this);
	//		}
	//		public void removeChild(TreeObject child) {
	//			children.remove(child);
	//			child.setParent(null);
	//		}
	//		public TreeObject [] getChildren() {
	//			return (TreeObject [])children.toArray(new TreeObject[children.size()]);
	//		}
	//		public boolean hasChildren() {
	//			return children.size()>0;
	//		}
	//	}

	//	class ViewContentProvider implements IStructuredContentProvider,
	//										   ITreeContentProvider {
	//		private TreeParent invisibleRoot = null;
	//
	//		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	//		}
	//		public void dispose() {
	//		}
	//		public Object[] getElements(Object parent) {
	//
	//			if (parent.equals(getViewSite())) {
	//				if (invisibleRoot==null) initialize();
	//				return getChildren(invisibleRoot);
	//			}
	//			return getChildren(parent);
	//		}
	//		public Object getParent(Object child) {
	//			if (child instanceof TreeObject) {
	//				return ((TreeObject)child).getParent();
	//			}
	//			return null;
	//		}
	//		public Object [] getChildren(Object parent) {
	//			if (parent instanceof TreeParent) {
	//				return ((TreeParent)parent).getChildren();
	//			}
	//			return new Object[0];
	//		}
	//		public boolean hasChildren(Object parent) {
	//			if (parent instanceof TreeParent)
	//				return ((TreeParent)parent).hasChildren();
	//			return false;
	//		}
	/*
	 * We will set up a dummy model to initialize tree heararchy.
	 * In a real code, you will connect to a real model and
	 * expose its hierarchy.
	 */
	//		private void initialize() {
	//			TreeObject to1 = new TreeObject("Leaf 1");
	//			TreeObject to2 = new TreeObject("Leaf 2");
	//			TreeObject to3 = new TreeObject("Leaf 3");
	//			TreeParent p1 = new TreeParent("Parent 1");
	//			p1.addChild(to1);
	//			p1.addChild(to2);
	//			p1.addChild(to3);
	//
	//			TreeObject to4 = new TreeObject("Leaf 4");
	//			TreeParent p2 = new TreeParent("Parent 2");
	//			p2.addChild(to4);
	//
	//			TreeParent root = new TreeParent("Root");
	//			root.addChild(p1);
	//			root.addChild(p2);
	//
	//			invisibleRoot = new TreeParent("");
	//			invisibleRoot.addChild(root);
	//		}
	//	}
	//	class ViewLabelProvider extends LabelProvider {
	//
	//		public String getText(Object obj) {
	//			return obj.toString();
	//		}
	//		public Image getImage(Object obj) {
	//			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
	//			if (obj instanceof TreeParent)
	//			   imageKey = ISharedImages.IMG_OBJ_FOLDER;
	//			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	//		}
	//	}
	//	class NameSorter extends ViewerSorter {
	//	}

	/**
	 * The constructor.
	 */
	public SequenceViewOld() {
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
//	public void createPartControl(Composite parent) {
//
//		propSheetPage.createControl(parent);
//		//propertyTable = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
//		//drillDownAdapter = new DrillDownAdapter(viewer);
//		//createPropertyColumns(parent, propertyTable);
//		//propertyTable.setContentProvider(new PropertyListContentProvider());
//		//propertyTable.setLabelProvider(new PropertyListLabelProvider());
//		//		viewer.setSorter(new NameSorter());
//		//propertyTable.setInput(null);
//		//		makeActions();
//		//		hookContextMenu();
//		//		hookDoubleClickAction();
//		//		contributeToActionBars();
//	}

//	private void createPropertyColumns(final Composite parent, final TableViewer viewer) {
//		//final Menu headerMenu = new Menu(parent);
//		String[] titles = { "Property", "Value" };
//		int[] bounds = { 100, 100, 100, 100 };
//
//		for (int i = 0; i < titles.length; i++) {
//			//			final int index = 1;
//			final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
//			final TableColumn column = viewerColumn.getColumn();
//
//			column.setText(titles[i]);
//			column.setWidth(bounds[i]);
//			column.setResizable(true);
//			//createMenuItem(headerMenu, column);
//
//			//			column.setMoveable(true);
//
//			//			column.addSelectionListener(new SelectionAdapter() {
//			//				@Override
//			//				public void widgetSelected(SelectionEvent e) {
//			//					//tableSorter.setColumn(index);
//			//					int dir = viewer.getTable().getSortDirection();
//			//
//			//					if (viewer.getTable().getSortColumn() == column) {
//			//						dir = dir == SWT.UP ? SWT.DOWN : SWT.UP;
//			//					} else {
//			//						dir = SWT.DOWN;
//			//					}
//			//					viewer.getTable().setSortDirection(dir);
//			//					viewer.getTable().setSortColumn(column);
//			//					viewer.refresh();
//			//				}
//			//			});
//			//viewerColumn.setEditingSupport(new PersonEditingSupport(viewer, i));
//		}

		//final Table table = viewer.getTable();
		//table.setHeaderVisible(true);
		//table.setLinesVisible(true);

		//		table.addListener(SWT.MenuDetect, new Listener() {
		//			public void handleEvent(Event event) {
		//				table.setMenu(headerMenu);
		//			}
		//		});
//	}
//
//	private IAsFunction function;
//	private ArrayList<FunctionProperty> properties;


	//	private void hookContextMenu() {
	//		MenuManager menuMgr = new MenuManager("#PopupMenu");
	//		menuMgr.setRemoveAllWhenShown(true);
	//		menuMgr.addMenuListener(new IMenuListener() {
	//			public void menuAboutToShow(IMenuManager manager) {
	//				SequenceView.this.fillContextMenu(manager);
	//			}
	//		});
	//		Menu menu = menuMgr.createContextMenu(viewer.getControl());
	//		viewer.getControl().setMenu(menu);
	//		getSite().registerContextMenu(menuMgr, viewer);
	//	}

	//	private void contributeToActionBars() {
	//		IActionBars bars = getViewSite().getActionBars();
	//		fillLocalPullDown(bars.getMenuManager());
	//		fillLocalToolBar(bars.getToolBarManager());
	//	}

	//	private void fillLocalPullDown(IMenuManager manager) {
	//		manager.add(action1);
	//		manager.add(new Separator());
	//		manager.add(action2);
	//	}

	//	private void fillContextMenu(IMenuManager manager) {
	//		manager.add(action1);
	//		manager.add(action2);
	//		manager.add(new Separator());
	//		drillDownAdapter.addNavigationActions(manager);
	//		// Other plug-ins can contribute there actions here
	//		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	//	}

	//	private void fillLocalToolBar(IToolBarManager manager) {
	//		manager.add(action1);
	//		manager.add(action2);
	//		manager.add(new Separator());
	//		drillDownAdapter.addNavigationActions(manager);
	//	}

	//	private void makeActions() {
	//		action1 = new Action() {
	//			public void run() {
	//				showMessage("Action 1 executed");
	//			}
	//		};
	//		action1.setText("Action 1");
	//		action1.setToolTipText("Action 1 tooltip");
	//		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
	//			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	//
	//		action2 = new Action() {
	//			public void run() {
	//				showMessage("Action 2 executed");
	//			}
	//		};
	//		action2.setText("Action 2");
	//		action2.setToolTipText("Action 2 tooltip");
	//		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
	//				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	//		doubleClickAction = new Action() {
	//			public void run() {
	//				ISelection selection = viewer.getSelection();
	//				Object obj = ((IStructuredSelection)selection).getFirstElement();
	//				showMessage("Double-click detected on "+obj.toString());
	//			}
	//		};
	//	}

	//	private void hookDoubleClickAction() {
	//		viewer.addDoubleClickListener(new IDoubleClickListener() {
	//			public void doubleClick(DoubleClickEvent event) {
	//				doubleClickAction.run();
	//			}
	//		});
	//	}
	//	private void showMessage(String message) {
	//		MessageDialog.openInformation(
	//			viewer.getControl().getShell(),
	//			"FlexAnalyzer",
	//			message);
	//	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
//	public void setFocus() {
//		//propertyTable.getControl().setFocus();
//	}
//
//	@Override
//	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
//		propSheetPage.selectionChanged(part, selection);
//	}
}