package de.karfau.flex_analyzer.model.dummy;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

import de.karfau.flex_analyzer.model.IAsClass;
import de.karfau.flex_analyzer.model.IAsFunction;

@SuppressWarnings("unchecked")
public class DummyAdapterFactory implements IAdapterFactory {

	private final Class[] TYPES = { Object.class };

	public static DummyAsFunction function;

	public DummyAdapterFactory() {
		function = new DummyAsFunction();
		function.setAccessType("public");
		function.setName("addElement");
		function.setSourceAvailable(false);
		function.setClazz(new DummyASClass("DisplayObject", "flash.display"));
		function.setReturnType(IAsClass.VOID);
	}

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		System.out.println("Adapter");
		if (adapterType == IAsFunction.class) {
			return function;
		}else if(adapterType == IPropertySource.class){
			return new IAsFunctionPropertySource(function);
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return TYPES;
	}

}
