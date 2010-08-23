package de.karfau.flex_analyzer.model;

import org.eclipse.core.runtime.Plugin;
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

	public void start(BundleContext context) throws Exception {
		super.start(context);
		sharedInstance = this;
	}

	public void stop(BundleContext context) throws Exception {
		sharedInstance = null;
		super.stop(context);
	}

}
