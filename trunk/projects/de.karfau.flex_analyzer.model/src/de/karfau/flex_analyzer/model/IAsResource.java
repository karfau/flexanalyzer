package de.karfau.flex_analyzer.model;

public interface IAsResource {

	static final String QUALIFIED_NAME_DELIM = ".";

	String getName();
	boolean isSourceAvailable();
	String getQualifiedName();
	boolean equals( IAsResource other);

}
