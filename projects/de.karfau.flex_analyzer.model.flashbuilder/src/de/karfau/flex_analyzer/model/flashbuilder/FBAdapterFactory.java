package de.karfau.flex_analyzer.model.flashbuilder;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.views.properties.IPropertySource;

import com.adobe.flexbuilder.codemodel.definitions.IDefinition;
import com.adobe.flexbuilder.codemodel.definitions.IDefinitionLink;
import com.adobe.flexbuilder.codemodel.definitions.IFunction;
import com.adobe.flexbuilder.editors.derived.ui.navigator.IFlexPackageExplorerASOutlineContent;
import com.adobe.flexide.as.core.ui.outliner.LinkableActionScriptTreeElement;

import de.karfau.flex_analyzer.model.AccessModifiers;
import de.karfau.flex_analyzer.model.FunctionPropertySource;
import de.karfau.flex_analyzer.model.IAsFunction;

public class FBAdapterFactory implements IAdapterFactory {

	private final Class<?>[] ADAPTER_TYPES = { IPropertySource.class };

	public static FBAsFunction function;

	public FBAdapterFactory() {

		function = new FBAsFunction(new FBASClass("DisplayObject", "flash.display"), AccessModifiers.PUBLIC, "addElement");
		System.out.println("FBAdapterFactory created");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		System.out.println(this.getClass().getSimpleName() + ".getAdapter(" + adaptableObject.getClass().getName() + ", " + adapterType.getSimpleName() + ")");

		LinkableActionScriptTreeElement late = null;
		if(adaptableObject instanceof LinkableActionScriptTreeElement)
			late = (LinkableActionScriptTreeElement) adaptableObject;
		else if (adaptableObject instanceof IFlexPackageExplorerASOutlineContent) {
			if (((IFlexPackageExplorerASOutlineContent) adaptableObject).getTreeElement() instanceof LinkableActionScriptTreeElement) {
				late = (LinkableActionScriptTreeElement) ((IFlexPackageExplorerASOutlineContent) adaptableObject).getTreeElement();
			}
		}else if(adaptableObject instanceof ITextSelection){

		}

		FBAsFunction result = null;
		if(late != null){
			IDefinition definition = ((IDefinitionLink) late.link).resolveLink();
			if (definition instanceof IFunction)
				result = new FBAsFunction((IFunction) definition);
		}

		if (result != null) {
			if (adapterType == IAsFunction.class) {
				return result;
			} else if (adapterType == IPropertySource.class) {
				return new FunctionPropertySource(result);
			}
		}
		return null;
	}

	@Override
	/*
	 * OUTPUT-Types
	 */
	public Class<?>[] getAdapterList() {
		return ADAPTER_TYPES;
	}


	//TODO: how to get the current editor from here so we can transfer TextSelection to IAsNode
	//public static

}
