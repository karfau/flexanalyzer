package de.karfau.flex_analyzer.model;

public interface IAsFunction extends IAsResource {


	IAsClass getClazz();

	IAsClass getReturnType();

	String getAccessType();

	public Object[] getExpressions();

}
