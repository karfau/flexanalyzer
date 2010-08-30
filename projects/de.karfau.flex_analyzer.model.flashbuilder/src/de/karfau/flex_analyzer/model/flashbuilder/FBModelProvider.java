package de.karfau.flex_analyzer.model.flashbuilder;

import org.eclipse.jface.viewers.IContentProvider;

import de.karfau.flex_analyzer.model.ModelProvider;
import de.karfau.flex_analyzer.model.flashbuilder.providers.CodeModelTreeContentProvider;

public class FBModelProvider implements ModelProvider {

	@Override
	public IContentProvider getTreeContentProvider() {
		return new CodeModelTreeContentProvider();
	}

}
