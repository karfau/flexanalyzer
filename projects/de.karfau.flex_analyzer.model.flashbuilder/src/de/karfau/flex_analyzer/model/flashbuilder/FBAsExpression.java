package de.karfau.flex_analyzer.model.flashbuilder;

import java.util.ArrayList;
import java.util.List;

import com.adobe.flexbuilder.codemodel.definitions.ASDefinitionCache;
import com.adobe.flexbuilder.codemodel.definitions.IFunction;
import com.adobe.flexbuilder.codemodel.internal.tree.ILiteralNode;
import com.adobe.flexbuilder.codemodel.tree.IASNode;
import com.adobe.flexbuilder.codemodel.tree.IExpressionNode;
import com.adobe.flexbuilder.codemodel.tree.IFunctionCallExpressionNode;
import com.adobe.flexbuilder.codemodel.tree.IIdentifierNode;
import com.adobe.flexbuilder.codemodel.tree.IIfExpressionNode;
import com.adobe.flexbuilder.codemodel.tree.IMemberAccessExpressionNode;
import com.adobe.flexbuilder.codemodel.tree.IOperatorExpressionNode;
import com.adobe.flexbuilder.codemodel.tree.IReturnStatementNode;

import de.karfau.flex_analyzer.model.IAsExpression;
import de.karfau.flex_analyzer.model.IAsFunction;

@SuppressWarnings("restriction")
public class FBAsExpression implements IAsExpression {

	private static ASDefinitionCache defCache = new ASDefinitionCache();

	private IASNode definition;
	private FBAsExpression additionalExpression = null;

	protected List<Object> children = new ArrayList<Object>();

	@Override
	public Object[] getChildren() {
		return children.toArray();
	}

	public FBAsExpression(IASNode definition) {
		this.definition = definition;
		if (definition != null) {
			if (definition instanceof IFunctionCallExpressionNode) {
				children.add(getFunctionByFunctionCallExpression((IFunctionCallExpressionNode) definition));
			} else if (definition instanceof IReturnStatementNode) {
				IReturnStatementNode rsn = (IReturnStatementNode) definition;
				additionalExpression = new FBAsExpression(rsn.getReturnExpression());
				addfilteredChildren(additionalExpression.getChildren());
			} else if (definition instanceof IIfExpressionNode) {
				IIfExpressionNode terniar = (IIfExpressionNode) definition;
				//addfilteredChildren(definition.getChildren());
				addTypedChild(terniar.getConditional());
				addTypedChild(terniar.getLeft());
				addTypedChild(terniar.getRight());
			} else if (definition instanceof IOperatorExpressionNode) {
				IOperatorExpressionNode op = (IOperatorExpressionNode) definition;
				addfilteredChildren(op.getChildren());
			} else {
				addfilteredChildren(definition.getChildren());
			}

		}
	}

	private int filterRecursion = 0;
	private final int maxRecursion = 1;

	private void addfilteredChildren(Object[] children) {
		if (children != null) {
			for (Object node : children) {
				addTypedChild(node);
			}
		}
	}

	private void addTypedChild(Object node) {
		if (node instanceof IAsExpression || node instanceof IAsFunction) {
			children.add(node);
		} else if (node instanceof IFunctionCallExpressionNode) {
			children.add(getFunctionByFunctionCallExpression((IFunctionCallExpressionNode) node));
		} else if (node instanceof IMemberAccessExpressionNode) {
			children.add(getFunctionByIMemberAccessExpression((IMemberAccessExpressionNode) node));
		} else if (node instanceof IIfExpressionNode) {
			children.add(new FBAsExpression((IASNode) node));
		} else if (node instanceof IOperatorExpressionNode) {
			addfilteredChildren(((IOperatorExpressionNode) node).getChildren());
		} else if (node instanceof IIdentifierNode) {
			//do nothing: IIdentifierNodes are currently not used, but they can be excluded here
		} else if (node instanceof IExpressionNode && filterRecursion < maxRecursion) {
			filterRecursion++;
			addfilteredChildren(((IExpressionNode) node).getChildren());
			filterRecursion--;
		} else {
			System.out.println("else:" + node);
		}
	}

	private FBAsFunction getFunctionByFunctionCallExpression(IFunctionCallExpressionNode functionCall) {
		//System.out.println(functionCall.getFunctionName());
		return new FBAsFunction(functionCall.resolveCalledFunction(defCache));
	}

	private FBAsFunction getFunctionByIMemberAccessExpression(IMemberAccessExpressionNode memberAccess) {
		return new FBAsFunction((IFunction) memberAccess.getDefinition(defCache));
	}

	@Override
	public String toString() {
		if (definition instanceof IFunctionCallExpressionNode) {
			IFunctionCallExpressionNode functionCall = (IFunctionCallExpressionNode) definition;
			String result = functionCall.getFunctionName() + "(";
			IExpressionNode[] params = functionCall.getParameters();
			IExpressionNode expr;
			for (int i = 0; i < params.length; i++) {
				expr = params[i];
				result += toReadableString(expr);
				result += (i < params.length - 2 ? "," : "");
			}
			result += ")";
			return result;
		} else if (definition instanceof IReturnStatementNode) {
			String result = "return " + additionalExpression.toString();
			return result;
		} else if (definition instanceof IExpressionNode) {
			return toReadableString((IExpressionNode)definition);
		} else {
			return ((IASNode) definition).toString();
		}
	}

	private String toReadableString(IExpressionNode expression) {
		if (expression instanceof ILiteralNode) {
			return ((ILiteralNode) expression).getValue();
		} else if (expression instanceof IIdentifierNode) {
			return ((IIdentifierNode) expression).getName();
		} else if (expression instanceof IIfExpressionNode) {
			return "( ? : )";
		} else {
			return expression.toString();
		}
	}
}
