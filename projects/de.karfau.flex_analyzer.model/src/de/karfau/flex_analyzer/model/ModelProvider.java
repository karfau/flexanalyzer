package de.karfau.flex_analyzer.model;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.LabelProvider;

public interface ModelProvider {

	IContentProvider getTreeContentProvider();
	LabelProvider getTreeLabelProvider();

}
