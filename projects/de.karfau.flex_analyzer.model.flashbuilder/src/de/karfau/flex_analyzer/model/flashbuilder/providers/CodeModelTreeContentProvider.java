package de.karfau.flex_analyzer.model.flashbuilder.providers;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.karfau.flex_analyzer.model.IAsFunction;

public class CodeModelTreeContentProvider implements ITreeContentProvider {

	RootInputItem<IAsFunction> rootInput;

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		Object[] elems = new Object[0];
		if (parentElement instanceof RootInputItem<?>) {
			IAsFunction node = (IAsFunction) rootInput.getInput();
			elems = new Object[] { node.getName(), node.getQualifiedName() };
		}
		return elems;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		return element instanceof IAsFunction || element instanceof RootInputItem<?>;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub

		Object[] elems = new Object[0];
		if (rootInput.getInput().equals(inputElement)) {
			elems = new Object[] { rootInput };
		}
		return elems;
		//		return null;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//if (!(viewer instanceof TreeViewer)) {
		if (newInput instanceof IAsFunction) {
			if (rootInput == null || !rootInput.getInput().equals(newInput))
				rootInput = new RootInputItem<IAsFunction>((IAsFunction) newInput);
		} else {
			rootInput = null;
		}
		//}
	}

	public class RootInputItem<T> {
		private T input;

		public RootInputItem(T input) {
			this.input = input;
		}

		public T getInput() {
			return input;
		}

	}
}
