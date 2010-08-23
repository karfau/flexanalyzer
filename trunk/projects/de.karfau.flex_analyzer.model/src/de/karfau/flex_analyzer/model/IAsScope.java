package de.karfau.flex_analyzer.model;

public interface IAsScope {

	IAsScope getParent();
	String getName();
	String getQualifiedName();
	boolean equals( IAsResource other);

}
