package de.karfau.flex_analyzer.model.flashbuilder;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.views.properties.IPropertySource;

import com.adobe.flexbuilder.codemodel.common.CMFactory;
import com.adobe.flexbuilder.codemodel.definitions.IDefinition;
import com.adobe.flexbuilder.codemodel.definitions.IDefinitionLink;
import com.adobe.flexbuilder.codemodel.definitions.IFunction;
import com.adobe.flexbuilder.codemodel.project.IProject;
import com.adobe.flexbuilder.codemodel.tree.ASOffsetInformation;
import com.adobe.flexbuilder.codemodel.tree.IASNode;
import com.adobe.flexbuilder.codemodel.tree.IFileNode;
import com.adobe.flexbuilder.codemodel.tree.IIdentifierNode;
import com.adobe.flexbuilder.editors.derived.ui.navigator.IFlexPackageExplorerASOutlineContent;
import com.adobe.flexide.as.core.ui.outliner.LinkableActionScriptTreeElement;

import de.karfau.flex_analyzer.model.AccessModifiers;
import de.karfau.flex_analyzer.model.Activator;
import de.karfau.flex_analyzer.model.FunctionPropertySource;
import de.karfau.flex_analyzer.model.IAsFunction;

public class FBAdapterFactory implements IAdapterFactory {

	private final Class<?>[] ADAPTER_TYPES = { IAsFunction.class, IPropertySource.class };

	public static FBAsFunction function;

	public FBAdapterFactory() {

		function = new FBAsFunction(new FBASClass("DisplayObject", "flash.display"), AccessModifiers.PUBLIC, "addElement");
		System.out.println("FBAdapterFactory created");
		Activator.getSharedInstance().setAdapterFactory(this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		System.out.println(this.getClass().getSimpleName() + ".getAdapter(" + adaptableObject.getClass().getName() + ", " + adapterType.getSimpleName() + ")");

		/*
		 * resolve a definition from adaptableObject
		 */
		IDefinition definition = null;

		if(adaptableObject instanceof ITreeSelection && !(adaptableObject instanceof LinkableActionScriptTreeElement) && !(adaptableObject instanceof IFlexPackageExplorerASOutlineContent))
			adaptableObject = ((ITreeSelection)adaptableObject).getFirstElement();

		if (adaptableObject instanceof LinkableActionScriptTreeElement){
			definition = getDefinition((LinkableActionScriptTreeElement) adaptableObject);
		}else if (adaptableObject instanceof IFlexPackageExplorerASOutlineContent) {
			if (((IFlexPackageExplorerASOutlineContent) adaptableObject).getTreeElement() instanceof LinkableActionScriptTreeElement) {
				definition = getDefinition((LinkableActionScriptTreeElement) ((IFlexPackageExplorerASOutlineContent) adaptableObject).getTreeElement());
			}
		} else if (adaptableObject instanceof ITextSelection) {
			IASNode node = getASNode((ITextSelection) adaptableObject);
			if (node instanceof IDefinition) {
				definition = (IDefinition) node;
			} else if (node.getParent() instanceof IIdentifierNode) {
				definition = ((IIdentifierNode) node).getDefinition();
			} else if (node.getParent() instanceof IDefinition) {
				definition = (IDefinition) node.getParent();
			} else {
				//TODO: resolve function for selections from insode a function
				System.out.println("found IASNode for TextSelection that isn't an IDefinition: " + node);
			}

		}

		/*
		 * filter for function-definitions only
		 */
		FBAsFunction result = null;
		if (definition instanceof IFunction)
			result = new FBAsFunction((IFunction) definition);

		/*
		 * create requested type
		 */
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

	private IDefinition getDefinition(LinkableActionScriptTreeElement late) {
		if (late != null) {
			return ((IDefinitionLink) late.link).resolveLink();
		}
		return null;
	}

	private IASNode getASNode(ITextSelection textSelection) {
		if (textSelection != null) {
			IPath path = Activator.getSharedInstance().getCurrentEditorInputPath();
			if (path != null) {
				synchronized (CMFactory.getLockObject()) {
					IProject projectForFile = CMFactory.getManager().getProjectForFile(path);
					if (projectForFile != null) {
						IFileNode fileNode = projectForFile.findFileNodeInProject(path);
						if (fileNode != null) {
							ASOffsetInformation info = new ASOffsetInformation(textSelection.getOffset(), fileNode);
							return ((IIdentifierNode) (info.getContainingNode())).getDefinition();
						}
					}
				}
			}
		}

		return null;

	}

}
