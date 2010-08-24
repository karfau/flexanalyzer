package de.karfau.flex_analyzer.flashbuilder;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.karfau.flex_analyzer.model.flashbuilder.FBModelProvider;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "de.karfau.flex_analyzer.flashbuilder";

	private static Activator sharedInstance;

	public static Activator getSharedInstance() {
		return sharedInstance;
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		System.out.println(this.getClass().getCanonicalName()+" starts");
		sharedInstance = this;
		de.karfau.flex_analyzer.model.Activator.getSharedInstance().setModelProvider(new FBModelProvider());
	}

	public void stop(BundleContext context) throws Exception {
		sharedInstance = null;
		System.out.println(this.getClass().getCanonicalName()+" stops");
		super.stop(context);
	}


}
