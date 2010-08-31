package de.karfau.flex_analyzer.ui.views;

import org.eclipse.jface.viewers.LabelProvider;

public class SVLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		String test = "test";
		return super.getText(element) + test;
	}
}
