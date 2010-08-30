package de.karfau.flex_analyzer.model;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPathEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.osgi.framework.BundleContext;


public class Activator extends Plugin {

	public static final String PLUGIN_ID = "de.karfau.flex_analyzer.model";

	private static Activator sharedInstance;

	public static Activator getSharedInstance() {
		return sharedInstance;
	}

	private ModelProvider modelProvider;

	public void setModelProvider(ModelProvider modelProvider) {
		this.modelProvider = modelProvider;
	}

	public ModelProvider getModelProvider() {
		return modelProvider;
	}

	private IWorkbenchPartSite site;

	public void setSite(IWorkbenchPartSite site) {
		this.site = site;
	}

	public IWorkbenchPartSite getSite() {
		return site;
	}

	public IPath getCurrentEditorInputPath() {
		if (site != null) {
			IWorkbenchPage page = site.getPage();
			if (page != null) {
				IEditorPart activeEditor = page.getActiveEditor();
				if (activeEditor != null) {
					IEditorInput editorInput = activeEditor.getEditorInput();
					if (editorInput instanceof IPathEditorInput) {
						return ((IPathEditorInput) editorInput).getPath();
					}
				}
			}
		}
		return null;
	}

	private IAdapterFactory adapterFactory;

	public void setAdapterFactory(IAdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}

	public IAdapterFactory getAdapterFactory() {
		return adapterFactory;
	}


	public void start(BundleContext context) throws Exception {
		super.start(context);
		sharedInstance = this;
	}

	public void stop(BundleContext context) throws Exception {
		sharedInstance = null;
		super.stop(context);
	}

}
