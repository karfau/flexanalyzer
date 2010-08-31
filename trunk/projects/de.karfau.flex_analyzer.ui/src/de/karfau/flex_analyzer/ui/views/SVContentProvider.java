package de.karfau.flex_analyzer.ui.views;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class SVContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		return new Object[1];
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return element;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

}
