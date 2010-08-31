package de.karfau.flex_analyzer.ui.views;

import org.eclipse.jface.viewers.LabelProvider;

import de.karfau.flex_analyzer.model.IAsFunction;
import de.karfau.flex_analyzer.ui.views.SVContentProvider.RootInputItem;

public class SVLabelProvider extends LabelProvider {

	@SuppressWarnings("unchecked")
	@Override
	public String getText(Object element) {
		if (element instanceof RootInputItem<?>) {
			return ((RootInputItem<IAsFunction>) element).getInput().getQualifiedName();
		} else{
			return super.getText(element);
		}
	}
}
