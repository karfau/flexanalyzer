package de.karfau.flex_analyzer.model.flashbuilder.providers;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.karfau.flex_analyzer.model.IAsExpression;
import de.karfau.flex_analyzer.model.IAsFunction;

public class CodeModelTreeContentProvider implements ITreeContentProvider {

	RootInputItem<IAsFunction> rootInput;

	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] elems = new Object[0];
		IAsFunction function = null;
		if (parentElement instanceof RootInputItem<?>) {
			function = (IAsFunction) rootInput.getInput();
		}else if(parentElement instanceof IAsFunction){
			function = (IAsFunction)parentElement;
		}
		if(function != null){
			elems = function.getExpressions();
		}else if(parentElement instanceof IAsExpression){
			IAsExpression expression = (IAsExpression)parentElement;
			elems = expression.getChildren();
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
		boolean result = getChildren(element).length>0;//element instanceof RootInputItem<?>;
//		if(!result)
//			result = element instanceof IAsFunction && ((IAsFunction)element).isSourceAvailable();
		return result;
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
