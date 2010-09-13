package de.karfau.flex_analyzer.model.flashbuilder;

import com.adobe.flexbuilder.codemodel.definitions.IClass;
import com.adobe.flexbuilder.codemodel.definitions.IFunction;
import com.adobe.flexbuilder.codemodel.definitions.IPackage;
import com.adobe.flexbuilder.codemodel.tree.IASNode;
import com.adobe.flexbuilder.codemodel.tree.IExpressionNode;
import com.adobe.flexbuilder.codemodel.tree.IScopedNode;

import de.karfau.flex_analyzer.model.AbstractResource;
import de.karfau.flex_analyzer.model.AccessModifiers;
import de.karfau.flex_analyzer.model.IAsClass;
import de.karfau.flex_analyzer.model.IAsFunction;

public class FBAsFunction extends AbstractResource implements IAsFunction {

	public static FBAsFunction createConstructor(IAsClass clazz/*, IAsVariable[] parameters*/) {
		return new FBAsFunction(clazz, AccessModifiers.PUBLIC, clazz.getName(), clazz);
	}

	private static IAsClass returnTypeForFunctionDefinition(IFunction definition) {

		if (definition != null) {
			if (definition.isConstructor())
				return classForFunctionDefinition(definition);
			else if (definition.getReturnType().equals(IAsClass.VOID.getName()))
				return IAsClass.VOID;
			else {
				IExpressionNode expr = definition.getReturnTypeExpression();
				if (expr.getDefinition() instanceof IClass)
					return new FBASClass((IClass) expr.getDefinition());
			}

		}
		return null;

	}

	private static IAsClass classForFunctionDefinition(IFunction definition) {
		IASNode node = definition.getParent();
		do {
			if (node instanceof IClass)
				return new FBASClass((IClass) node);
			node = node.getParent();
		} while (!(node instanceof IPackage));
		return null;
		//		if(node instanceof IClass)
		//			return (IClass) node;
		//		if(node instanceof IExpressionNode)
		//			if(((IExpressionNode)node).getDefinition() instanceof IClass)
		//				return (IClass) ((IExpressionNode)node).getDefinition();
		//		return null;
	}

	private IFunction definition = null;

	private IAsClass clazz = null;//TODO: Refactor to IAsScope
	private IAsClass returnType;
	private String accessModifier;

	private IScopedNode sourceBlock;

	public FBAsFunction(IAsClass clazz, AccessModifiers accessModifier, String name/*, IAsVariable[] parameters*/, IAsClass returnType) {
		this(clazz, accessModifier.toString(), name, returnType);
	}

	public FBAsFunction(IAsClass clazz, AccessModifiers accessModifier, String name/*, IAsVariable[] parameters*/) {
		this(clazz, accessModifier.toString(), name);
	}

	public FBAsFunction(IAsClass clazz, String namespace, String name/*, IAsVariable[] parameters*/, IAsClass returnType) {
		this.clazz = clazz;
		this.accessModifier = namespace;
		setName(name);
		this.returnType = returnType;
	}

	public FBAsFunction(IAsClass clazz, String namespace, String name/*, IAsVariable[] parameters*/) {
		this(clazz, namespace, name, IAsClass.VOID);
	}

	public FBAsFunction(IFunction definition) {
		this(classForFunctionDefinition(definition), definition.getNamespace(), definition.getName(), returnTypeForFunctionDefinition(definition));
		this.definition = definition;

		for(int i=definition.getChildCount();--i > 0;){
			if(definition.getChild(i) instanceof IScopedNode){
				this.sourceBlock = (IScopedNode)definition.getChild(i);
			}
		}
	}

	public FBAsFunction() {
		this(null, AccessModifiers.DYNAMIC.toString(), null);
	}

	@Override
	public String getAccessType() {
		return accessModifier;
	}

	@Override
	public String getName() {
		String prefix = "";
		if (definition != null) {
			if (definition.isGetter())
				prefix = "get ";
			else if (definition.isSetter())
				prefix = "set ";
		}
		return prefix + super.getName();
	}

	@Override
	public IAsClass getClazz() {
		return clazz;
	}

	@Override
	public IAsClass getReturnType() {
		return returnType;
	}

	/**
	 * For dynamic functions (clazz==null this returns null)
	 */
	@Override
	public String getQualifiedName() {
		return joinQualifiedNameParts(clazz == null ? null : clazz.getQualifiedName(), getName());
	}

	@Override
	public Object clone() {
		return new FBAsFunction(definition);
	}

	@Override
	public boolean isSourceAvailable() {
		return sourceBlock != null;
	}

	public Object[] getExpressions(){
		Object[] result = null;
		if(isSourceAvailable()){
			result = new Object[sourceBlock.getChildCount()];
			for(int i = 0;i<sourceBlock.getChildren().length;i++){
				result[i] = new FBAsExpression(sourceBlock.getChild(i));
			}
		}
		return result;
	}



}
