package de.karfau.flex_analyzer.model.flashbuilder.providers;

import org.eclipse.jface.viewers.LabelProvider;

import de.karfau.flex_analyzer.model.IAsExpression;
import de.karfau.flex_analyzer.model.IAsFunction;
import de.karfau.flex_analyzer.model.flashbuilder.providers.CodeModelTreeContentProvider.RootInputItem;

public class CodeModelTreeLabelProvider extends LabelProvider {

	@SuppressWarnings( { "unchecked", "restriction" })
	@Override
	public String getText(Object element) {

		IAsFunction function = null;
		if (element instanceof RootInputItem<?>) {
			function = ((RootInputItem<IAsFunction>) element).getInput();
		} else if (element instanceof IAsFunction) {
			function = (IAsFunction) element;
		}

		if (function != null) {
			return function.getQualifiedName();
		} else if (element instanceof IAsExpression) {
			return element.toString();
		} else {
			return super.getText(element);
		}
	}
}
