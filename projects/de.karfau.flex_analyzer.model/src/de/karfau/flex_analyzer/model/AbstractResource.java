package de.karfau.flex_analyzer.model;

public abstract class AbstractResource implements IAsResource {

	private String name;
	private boolean sourceAvailable = false;
	private IAsScope scope;

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public boolean isSourceAvailable() {
		return sourceAvailable;
	}

	protected void setSourceAvailable(boolean sourceAvailable) {
		this.sourceAvailable = sourceAvailable;
	}

	protected void setScope(IAsScope scope) {
		this.scope = scope;
	}

	public IAsScope getScope() {
		return scope;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof IAsResource ? equals((IAsResource) other) : false;
	}

	@Override
	public boolean equals(IAsResource other) {
		return getQualifiedName().equals(other.getQualifiedName());
	}

	protected String joinQualifiedNameParts(String first, String second) {
		return (first != null && first.length() > 0 ? first + QUALIFIED_NAME_DELIM : "") + second;
	}

	abstract public Object clone();

}
