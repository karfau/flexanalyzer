package de.karfau.flex_analyzer.ui.test;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import de.karfau.flex_analyzer.ui.views.SequenceView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {

		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		layout.addStandaloneView(SequenceView.ID, true, IPageLayout.LEFT, 1f, editorArea);
		layout.addView("org.eclipse.ui.views.PropertySheet",IPageLayout.LEFT,1f,SequenceView.ID);

	}

}
