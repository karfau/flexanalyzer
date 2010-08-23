package de.karfau.flex_analyzer.model;

public enum AccessModifiers {
	PUBLIC, PROTECTED, INTERNAL, PRIVATE, DYNAMIC;

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

}
