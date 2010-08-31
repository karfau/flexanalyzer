package de.karfau.flex_analyzer.model.flashbuilder.providers;

import org.eclipse.jface.viewers.LabelProvider;

import de.karfau.flex_analyzer.model.IAsFunction;
import de.karfau.flex_analyzer.model.flashbuilder.providers.CodeModelTreeContentProvider.RootInputItem;;

public class CodeModelTreeLabelProvider extends LabelProvider {

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
