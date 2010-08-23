package de.karfau.flex_analyzer.model;

public interface IAsParameter extends IAsVariable {
	public String getDefaultValue();
	public Boolean isOptional();
}
