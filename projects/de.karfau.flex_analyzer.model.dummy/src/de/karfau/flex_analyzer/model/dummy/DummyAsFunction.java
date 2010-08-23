package de.karfau.flex_analyzer.model.dummy;

import de.karfau.flex_analyzer.model.IAsClass;
import de.karfau.flex_analyzer.model.IAsFunction;

public class DummyAsFunction implements IAsFunction {

	private String name;
	private String accessType;
	private IAsClass clazz;
	private boolean sourceAvailable;
	private IAsClass returnType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public IAsClass getClazz() {
		return clazz;
	}

	public void setClazz(IAsClass clazz) {
		this.clazz = clazz;
	}

	public boolean isSourceAvailable() {
		return sourceAvailable;
	}

	public void setSourceAvailable(boolean sourceAvailable) {
		this.sourceAvailable = sourceAvailable;
	}

	public IAsClass getReturnType() {
		return returnType;
	}

	public void setReturnType(IAsClass returnType) {
		this.returnType = returnType;
	}

}
