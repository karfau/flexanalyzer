package de.karfau.flex_analyzer.model.dummy;

import de.karfau.flex_analyzer.model.IAsClass;

public class DummyASClass implements IAsClass {

	private String name;

	public DummyASClass(String name, String asPackage) {
		this.name = name;
		this.asPackage = asPackage;
	}

	private String asPackage;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getAsPackage() {
		return asPackage;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param _package the _package to set
	 */
	public void setAsPackage(String value) {
		this.asPackage = value;
	}

	@Override
	public String getQualifiedName() {

		return asPackage+"."+name;
	}

}
