package de.karfau.flex_analyzer.model.flashbuilder;

import de.karfau.flex_analyzer.model.AbstractResource;
import de.karfau.flex_analyzer.model.IAsVariable;

public class FBAsVariable extends AbstractResource implements IAsVariable {

	private Object value;

	@Override
	public boolean asBoolean() {
		return false;
	}

	@Override
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String getQualifiedName() {
		return joinQualifiedNameParts(getScope().getQualifiedName(),getName());
	}

}
