/**
 * Copyright (C) SEI, PKU, PRC. - All Rights Reserved.
 * Unauthorized copying of this file via any medium is
 * strictly prohibited Proprietary and Confidential.
 * Written by Jiajun Jiang<jiajun.jiang@pku.edu.cn>.
 */
package mfix.core.node.ast.expr;

import mfix.core.node.ast.Node;
import mfix.core.node.match.metric.FVector;
import org.eclipse.jdt.core.dom.ASTNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Jiajun
 * @date: 2018/9/21
 */
public class BoolLiteral extends Expr {

	private static final long serialVersionUID = 2944431726908480955L;
	private boolean _value = false;

	/**
	 * BooleanLiteral: true false
	 */
	public BoolLiteral(String fileName, int startLine, int endLine, ASTNode node) {
		super(fileName, startLine, endLine, node);
		_nodeType = TYPE.BLITERAL;
	}

	public void setValue(boolean value) {
		_value = value;
	}

	public boolean getValue() {
		return _value;
	}

	@Override
	public StringBuffer toSrcString() {
		return new StringBuffer(String.valueOf(_value));
	}
	
	@Override
	protected void tokenize() {
		_tokens = new LinkedList<>();
		_tokens.add(String.valueOf(_value));
	}

	@Override
	public List<Node> getAllChildren() {
		return new ArrayList<>(0);
	}
	
	@Override
	public boolean compare(Node other) {
		if(other instanceof BoolLiteral) {
			return (_value == ((BoolLiteral) other)._value);
		}
		return false;
	}
	
	@Override
	public void computeFeatureVector() {
		_fVector = new FVector();
		_fVector.inc(FVector.E_BOOL);
	}

	@Override
	public boolean postAccurateMatch(Node node) {
		if(getBindingNode() == node) return true;
		if(getBindingNode() == null && canBinding(node)) {
			setBindingNode(node);
			return true;
		}
		return false;
	}
}
