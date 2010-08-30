package de.karfau.flex_analyzer.model.flashbuilder;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	public static final String PLUGIN_ID = "de.karfau.flex_analyzer.model.flashbuilder";

//	private static Activator sharedInstance;
//
//	public static Activator getSharedInstance() {
//		return sharedInstance;
//	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		//sharedInstance = this;
	}

	public void stop(BundleContext context) throws Exception {
		//sharedInstance = null;
		super.stop(context);
	}


}
