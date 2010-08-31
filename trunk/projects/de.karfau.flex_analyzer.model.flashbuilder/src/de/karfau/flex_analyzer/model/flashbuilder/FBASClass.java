package de.karfau.flex_analyzer.model.flashbuilder;

import com.adobe.flexbuilder.codemodel.definitions.IClass;

import de.karfau.flex_analyzer.model.AbstractClass;
import de.karfau.flex_analyzer.model.IAsClass;

public class FBASClass extends AbstractClass implements IAsClass {

	public FBASClass(String name, String packageName) {
		setName(name);
		this.packageName = packageName;
	}

	public FBASClass(String name) {
		this(name, "");
	}

	public FBASClass(IClass definition) {
		this(definition != null ? definition.getName() : "nullClassDefinition", definition != null ? definition.getPackageName() : "");
		this.definition = definition;
	}

	private IClass definition = null;

	private String packageName;

	@Override
	public String getPackageName() {
		return this.packageName;
	}

	@Override
	public String getQualifiedName() {
		return joinQualifiedNameParts(packageName, getName());
	}

	@Override
	public boolean isSourceAvailable() {
		return definition != null;//TODO: BlockNode(IScopedNode) as child?
	}

	@Override
	public Object clone() {
		return new FBASClass(definition);
	}

}
