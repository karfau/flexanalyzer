package de.karfau.flex_analyzer.model.dummy;

import java.util.ArrayList;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import de.karfau.flex_analyzer.model.FunctionProperties;
import de.karfau.flex_analyzer.model.IAsFunction;

public class IAsFunctionPropertySource implements IPropertySource {

	IAsFunction value;

	public IAsFunctionPropertySource(IAsFunction value) {
		this.value = value;
	}

	@Override
	public Object getEditableValue() {
		return this;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		ArrayList<PropertyDescriptor> descriptors = new ArrayList<PropertyDescriptor>();
		for (FunctionProperties propertyName : FunctionProperties.values()) {
			PropertyDescriptor descriptor = new PropertyDescriptor(propertyName.toString(), propertyName.toString());
			descriptor.setAlwaysIncompatible(true);
			descriptors.add(descriptor);
		}
		return descriptors.toArray(new IPropertyDescriptor[0]);
	}

	@Override
	public Object getPropertyValue(Object id) {
		switch ((FunctionProperties)id) {
		case NAME:
			return value.getName();
		case ACCESS_TYPE:
			return value.getAccessType();
		case CLAZZ:
			return value.getClazz().getQualifiedName();
		case RETURN_TYPE:
			return value.getReturnType().getQualifiedName();
		case SOURCE_AVAILABLE:
			return value.isSourceAvailable()+"";
		default:
			return "unmaapped property";
		}
	}

	@Override
	public boolean isPropertySet(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		// TODO Auto-generated method stub

	}

}
