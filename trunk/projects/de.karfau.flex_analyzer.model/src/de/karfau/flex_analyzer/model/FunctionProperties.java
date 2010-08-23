package de.karfau.flex_analyzer.model;

public enum FunctionProperties {
	//IAsResource
	NAME, QUALIFIED_NAME, SOURCE_AVAILABLE,
	//IAsClass
	ACCESS_TYPE, CLAZZ, RETURN_TYPE;

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
