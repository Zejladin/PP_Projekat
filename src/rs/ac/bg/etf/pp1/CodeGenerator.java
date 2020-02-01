package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.*;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	
	public CodeGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(FactorNum fac) {
		Code.loadConst(fac.getNumberFactor());
	}
	
	public void visit(FactorChar fac) {
		Code.loadConst(fac.getCharFactor());
	}
	
	public void visit(PrintStatementOneArg stm) {
		if(stm.getExpr().struct == Tab.intType) {
			Code.put(Code.const_4);
			Code.put(Code.print);
		}
		else {
			Code.put(Code.const_1);
			Code.put(Code.bprint);
		}
	}

	public void visit(MethodName meth) {
		if("main".equalsIgnoreCase(meth.getMethodName())){
			mainPc = Code.pc;
		}
		meth.obj.setAdr(Code.pc);
		SyntaxNode methodNode = meth.getParent();
		
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);
		
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(fpCnt.getCount() + varCnt.getCount());
	}
	
	public void visit(MethodDecl meth) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(FactorDesignator fac) {
		Obj o = fac.getDesignatorBase().obj;
		Code.load(o);
	}
	
	public void visit(DesignatorAssign des) {
		Code.store(des.getDesignatorBase().obj);
	}
	
	public void visit(TermList term) {
		if(term.getMulop() instanceof MulopMul)
			Code.put(Code.mul);
		if(term.getMulop() instanceof MulopDiv)
			Code.put(Code.div);
		if(term.getMulop() instanceof MulopMod)
			Code.put(Code.rem);
	}
	
	public void visit(ExprNegatedTerm expr) {
		Code.put(Code.const_m1 );
		Code.put(Code.mul);
	}
	
	public void visit(ExprList expr) {
		if(expr.getAddop() instanceof AddopAdd)
			Code.put(Code.add);
		if(expr.getAddop() instanceof AddopSub)
			Code.put(Code.sub);
	}
	
	public void visit(ReadStatement stm) {
		Code.put(Code.read);
	}
}
