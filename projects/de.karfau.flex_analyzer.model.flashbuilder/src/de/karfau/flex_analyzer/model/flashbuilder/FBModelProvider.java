package de.karfau.flex_analyzer.model.flashbuilder;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.LabelProvider;

import de.karfau.flex_analyzer.model.ModelProvider;
import de.karfau.flex_analyzer.model.flashbuilder.providers.CodeModelTreeContentProvider;
import de.karfau.flex_analyzer.model.flashbuilder.providers.CodeModelTreeLabelProvider;

public class FBModelProvider implements ModelProvider {

	@Override
	public IContentProvider getTreeContentProvider() {
		return new CodeModelTreeContentProvider();
	}

	@Override
	public LabelProvider getTreeLabelProvider() {
		return new CodeModelTreeLabelProvider();
	}
}
