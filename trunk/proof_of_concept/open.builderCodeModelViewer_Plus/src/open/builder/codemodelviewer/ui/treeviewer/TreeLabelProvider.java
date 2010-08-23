/**
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Initial Developer of the Original Code is David Zuckerman
 * Portions created by the Initial Developer are Copyright (C) 2008
 * the Initial Developer. All Rights Reserved.
 *
 **/
package open.builder.codemodelviewer.ui.treeviewer;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.adobe.flexbuilder.codemodel.asdoc.ICommentTag;
import com.adobe.flexbuilder.codemodel.asdoc.IDefinitionComment;
import com.adobe.flexbuilder.codemodel.asdoc.ILabeledTagValue;
import com.adobe.flexbuilder.codemodel.asdoc.ILinkTagValue;
import com.adobe.flexbuilder.codemodel.asdoc.ITagValue;
import com.adobe.flexbuilder.codemodel.common.CMFactory;
import com.adobe.flexbuilder.codemodel.definitions.IClass;
import com.adobe.flexbuilder.codemodel.definitions.IInterface;
import com.adobe.flexbuilder.codemodel.internal.tree.ILiteralNode;
import com.adobe.flexbuilder.codemodel.tree.IIdentifierNode;
import com.adobe.flexbuilder.codemodel.tree.IMemberAccessExpressionNode;
import com.adobe.flexbuilder.codemodel.tree.IScopedNode;

/**
 * Label provider to display specific content based on node type
 * 
 * @author David Zuckerman
 * 
 */
@SuppressWarnings("restriction")
public class TreeLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		synchronized (CMFactory.getLockObject()) {
			String append = "";
			if (element instanceof IClass) {
				return "Class: " + ((IClass) element).getQualifiedName();
			} else if (element instanceof IScopedNode) {
				return "Block Scope";
			} else if (element instanceof IInterface) {
				return "Interface: " + ((IInterface) element).getQualifiedName();
			} else if (element instanceof IIdentifierNode) {
				append = ((IIdentifierNode) element).getName();
			} else if (element instanceof IMemberAccessExpressionNode) {
				append = ((IMemberAccessExpressionNode) element).getExpression();
			} else if (element instanceof IDefinitionComment) {
				return "IDefinitionComment" + (((IDefinitionComment) element).isInherited() ? "" : " not") + " inherited";
			} else if (element instanceof ICommentTag) {
				return "ICommentTag: " + ((ICommentTag) element).getTagName();
			} else if (element instanceof ITagValue) {
				return getCommentTagValue((ITagValue) element);
			} else if (element instanceof ILiteralNode) {
				append = " : " + ((ILiteralNode) element).getValue();
			}
			return super.getText(element) + append;
		}
	}

	@Override
	public Image getImage(Object element) {
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		return sharedImages.getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT).createImage();
	}

	private String getCommentTagValue(ITagValue tag) {
		StringBuilder result = new StringBuilder("ITagValue: ");
		if (tag instanceof ILabeledTagValue) {
			result.append('(');
			result.append(((ILabeledTagValue) tag).hasLabel() ? ((ILabeledTagValue) tag).getLabel() : "no label");
			result.append(')');
		}

		result.append('"');
		result.append(tag.hasValue() ? tag.getValue() : "");
		result.append('"');

		if (tag instanceof ILinkTagValue) {
			result.append('<');
			result.append(((ILinkTagValue) tag).hasLink() ? ((ILinkTagValue) tag).getLink() : "no link");
			result.append('>');
		}

		return result.toString();
	}

}
