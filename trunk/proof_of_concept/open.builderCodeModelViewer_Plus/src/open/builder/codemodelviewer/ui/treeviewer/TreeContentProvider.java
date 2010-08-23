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

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.adobe.flexbuilder.codemodel.asdoc.ICommentTag;
import com.adobe.flexbuilder.codemodel.asdoc.IDefinitionComment;
import com.adobe.flexbuilder.codemodel.asdoc.IDocumentableDefinition;
import com.adobe.flexbuilder.codemodel.definitions.RecursionGuard;
import com.adobe.flexbuilder.codemodel.tree.IASNode;
import com.adobe.flexbuilder.codemodel.tree.IIdentifierNode;

/**
 * Content provider gets children and parents from standard IASNode
 * 
 * @author David Zuckerman
 * 
 */
public class TreeContentProvider implements ITreeContentProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.
	 * Object)
	 */
	public Object[] getChildren(Object arg0) {

		return getChildrenByType(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object
	 * )
	 */
	public Object getParent(Object arg0) {
		return ((IASNode) arg0).getParent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.
	 * Object)
	 */
	public boolean hasChildren(Object arg0) {
		return getChildrenByType(arg0).length > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java
	 * .lang.Object)
	 */
	public Object[] getElements(Object arg0) {
		return getChildrenByType(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface
	 * .viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
	}

	private Object[] getChildrenByType(Object elem) {
		if (elem instanceof IDefinitionComment)
			return getCommentChildren((IDefinitionComment) elem);
		else if (elem instanceof ICommentTag)
			return ((ICommentTag) elem).getValues();
		else if (elem instanceof IIdentifierNode) {
			switch (((IIdentifierNode) elem).getIdentifierType()) {
			case NAME:
				return new Object[] { ((IIdentifierNode) elem).getDefinition() };
				//default:
				//	return new Object[0];
			}
		}
		if (elem instanceof IASNode)
			return getCommentAndChildren((IASNode) elem);
		else
			return new Object[0];
	}

	private Object[] getCommentAndChildren(IASNode node) {
		Object[] result;
		Object[] children = node.getChildren();
		if (node instanceof IDocumentableDefinition) {
			result = new Object[children.length + 1];
			int i = 0;
			result[i++] = ((IDocumentableDefinition) node).getComment();
			for (Object child : children) {
				result[i++] = child;
			}
		} else {
			result = children;
		}

		return result;
	}

	private Object[] getCommentChildren(IDefinitionComment comment) {
		Object[] result;
		Object[] tags = comment.getAllCommentTags();

		result = new Object[tags.length + 1];
		int i = 0;
		result[i++] = comment.getDescription(new RecursionGuard());
		for (Object tag : tags) {
			result[i++] = tag;
		}

		return result;
	}

}
