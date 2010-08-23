package de.karfau.flex_analyzer.model;

import java.util.ArrayList;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class FunctionPropertySource implements IPropertySource {

	IAsFunction value;

	public FunctionPropertySource(IAsFunction value) {
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
			PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, propertyName.toString());
			descriptor.setDescription("What a great description");
			descriptor.setCategory("Info");
			descriptor.setAlwaysIncompatible(true);
			descriptors.add(descriptor);
		}
		return descriptors.toArray(new IPropertyDescriptor[0]);
	}

	@Override
	public Object getPropertyValue(Object id) {
		//System.out.println("getPropertyValue(" + id + ")");
		if (id instanceof FunctionProperties)
			switch ((FunctionProperties) id) {
			//IAsResource
			case NAME:
				return value.getName();
			case QUALIFIED_NAME:
				return value.getQualifiedName();
			case SOURCE_AVAILABLE:
				return value.isSourceAvailable() + "";
			//IAsClass
			case ACCESS_TYPE:
				return value.getAccessType();
			case CLAZZ:
				return value.getClazz().getQualifiedName();
			case RETURN_TYPE:
				return value.getReturnType().getQualifiedName();
			default:
				return "unmapped property " + id;
			}
		else
			return null;
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
