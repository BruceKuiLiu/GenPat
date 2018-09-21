/**
 * Copyright (C) SEI, PKU, PRC. - All Rights Reserved.
 * Unauthorized copying of this file via any medium is
 * strictly prohibited Proprietary and Confidential.
 * Written by Jiajun Jiang<jiajun.jiang@pku.edu.cn>.
 */
package mfix.core.parse.node.expr;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Type;

import mfix.core.parse.node.Node;
import mfix.core.parse.node.stmt.Stmt;


/**
 * 
 * @author Jiajun
 * @date Oct 8, 2017
 */
public abstract class Expr extends Node {
	
	protected Type _exprType = null;

	protected Expr(int startLine, int endLine, ASTNode node) {
		super(startLine, endLine, node, null);
	}
	
	public void setType(Type exprType){
		_exprType = exprType;
	}
	
	public Type getType(){
		return _exprType;
	}
	
	@Override
	public Stmt getParentStmt() {
		return getParent().getParentStmt();
	}
	
	@Override
	public List<Stmt> getChildren() {
		return new ArrayList<>(0);
	}
	
	
}