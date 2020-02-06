package rs.ac.bg.etf.pp1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.CounterVisitor.*;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

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
	
	public void visit(FactorBool fac) {
		if(fac.getBoolFactor() == true)
			Code.loadConst(1);
		else
			Code.loadConst(0);
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
		
		Obj o = stm.getDesignatorBase().obj;
		if(o.getType().getKind() == Struct.Char) {
			Code.put(Code.bread);
		}
		else {
			Code.put(Code.read);
		}
		Code.store(o);
	}
	
	public void visit(FactorAllocationArray fac) {
		Code.put(Code.newarray);
		if(fac.getType().struct == Tab.charType)
			Code.put(0);
		else {
			Code.put(1);
			System.out.println("Pravimo niz integera!");
		}
	}
	
	public void visit(ArrayLoadMarker mark) {
		Obj o = ((DesignatorArray)mark.getParent()).getDesignator().obj;
		Code.load(o);
	}
	
	public void visit(DesignatorIdent des) {
		if(des.obj.getKind() == Obj.Fld)
			Code.put(Code.load_n);
	}
	
	public void visit(FactorDesignatorCall fac) {
		int n = fac.getDesignatorBase().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(n);
	}
	
	public void visit(DesignatorCall des) {
		int n = des.getDesignatorBase().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(n);
	}
	
	public void visit(ReturnStatementVoid stm) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(ReturnStatement stm) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(DesignatorInc des) {
		des.getDesignatorBase().getDesignator().traverseBottomUp(this);
		Code.load(des.getDesignatorBase().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(des.getDesignatorBase().obj);
	}
	
	public void visit(DesignatorDec des) {
		des.getDesignatorBase().getDesignator().traverseBottomUp(this);
		Code.load(des.getDesignatorBase().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(des.getDesignatorBase().obj);
	}
	
	//public int adr = 0;
	private Stack<Integer> adr = new Stack<Integer>();
	
	public void visit(CondFactRel condFact) {
		int cond = 0;
        Relop relop = condFact.getRelop();
        if(relop instanceof RelopEquals)
            cond = Code.eq;
        else if(relop instanceof RelopNotEquals)
            cond = Code.ne;
        else if(relop instanceof RelopGreaterEqual)
            cond = Code.ge;
        else if(relop instanceof RelopGreaterThan)
            cond = Code.gt;
        else if(relop instanceof RelopLessThan)
            cond = Code.lt;
        else if(relop instanceof RelopLessEqual)
            cond = Code.le;
		Code.put(Code.jcc + cond);
		Code.put2(0);
		int adr = Code.pc - 2;
		Code.loadConst(0);
		Code.put(Code.jmp); 
		Code.put2(0);
		int adr2 = Code.pc - 2;
		Code.fixup(adr); // ovde skacem ako je tacno
		Code.loadConst(1);
		Code.fixup(adr2); // ovde skacem ako je netacno
	}
	
	public void visit(CondTermList condTerm) {
		Code.put(Code.mul);
		Code.loadConst(1);
		Code.put(Code.jcc + Code.eq);
		Code.put2(0);
		int adr = Code.pc - 2;
		Code.loadConst(0);
		Code.put(Code.jmp);
		Code.put2(0);
		int adr2 = Code.pc - 2;
		Code.fixup(adr);
		Code.loadConst(1);
		Code.fixup(adr2);
	}
	
	//private int pocetakIfa = 0;
	private Stack<Integer> pocetakIfa = new Stack();
	private Stack<Integer> pocetakSledecegOra = new Stack();
	
	public void visit(CondTermBase condTerm) {
		Code.loadConst(1);
		Code.put(Code.jcc + Code.eq);
		Code.put2(0);
		pocetakIfa.push(Code.pc - 2);
		Code.loadConst(0);
	}
	
	/*public void visit(CondFactBase condFact) {
		Code.loadConst(0);
		Code.put(Code.jcc + Code.eq);
		Code.put2(0);
		pocetakSledecegOra.push(Code.pc - 2);
		Code.loadConst(1);
	}*/
	
	public void visit(ConditionList cond) {
		Code.put(Code.add);
		Code.loadConst(1);
		Code.put(Code.jcc + Code.ge);
		Code.put2(0);
		int adr = Code.pc - 2;
		Code.loadConst(0);
		Code.put(Code.jmp);
		Code.put2(0);
		int adr2 = Code.pc - 2;
		Code.fixup(adr);
		Code.loadConst(1);
		Code.fixup(adr2);
	}
	
	public void visit(IfStartMarkerCond mark) {
		Code.loadConst(1);
		Code.put(Code.jcc + Code.ne);
		Code.put2(0);
		this.adr.push(Code.pc - 2);
		while(pocetakIfa.size() > 0)
			Code.fixup(pocetakIfa.pop());
		//this.adr = Code.pc - 2; //preskacemo if ili skacemo na else!
	}
	
	public void visit(IfStatement stm) {
		//Code.fixup(this.adr);
		Code.fixup(this.adr.pop());
	}
	
	//private int elseAdr = 0;
	private Stack<Integer> elseAdr = new Stack();
	
	public void visit(IfElseMarker mark) {
		Code.put(Code.jmp);
		Code.put2(0);
		this.elseAdr.push(Code.pc - 2);
		//elseAdr = Code.pc - 2;
		Code.fixup(this.adr.pop());
		//Code.fixup(this.adr);
	}
	
	public void visit(IfElseStatement stm) {
		Code.fixup(this.elseAdr.pop());
		//Code.fixup(this.elseAdr);
	}
	
	//private int forCond = 0;
	private Stack<Integer> forCond = new Stack();
	
	public void visit(ForInit forInit) {
		//forCond = Code.pc;
		forCond.push(Code.pc);
	}
	
	public void visit(NoForInit forInit) {
		//forCond = Code.pc;
		forCond.push(Code.pc);
	}
	
	//private int forSkip = 0;
	private Stack<Integer> forSkip = new Stack();
	//private int forStm = 0;
	private Stack<Integer> forStm = new Stack();
	//private int forStep = 0;
	private Stack<Integer> forStep = new Stack();
	private Stack<LinkedList<Integer>> continueStack = new Stack();
	private Stack<LinkedList<Integer>> breakStack = new Stack();
	
	public void visit(ForStartMarker mark) {
		LinkedList<Integer> l1 = new LinkedList();
		LinkedList<Integer> l2 = new LinkedList();
		
		continueStack.push(l1);
		breakStack.push(l2);
	}
	
	public void visit(ForCond forCond) {
		Code.loadConst(1);
		Code.put(Code.jcc + Code.ne);
		Code.put2(0);
		//forSkip = Code.pc - 2; // Adresa posle fora na koju skacemo ako nije ispunjen uslov
		forSkip.push(Code.pc - 2);
		Code.put(Code.jmp);
		Code.put2(0);
		forStm.push(Code.pc - 2);
		//forStm = Code.pc - 2;
		//forStep = Code.pc;
		forStep.push(Code.pc);
	}
	
	public void visit(NoForCond forCond) {
		Code.put(Code.jmp);
		Code.put2(0);
		forStm.push(Code.pc - 2);
		forStep.push(Code.pc);
	}
	
	public void visit(ForStep step) {
		Code.putJump(forCond.pop());
	}
	
	public void visit(NoForStep step) {
		Code.putJump(forCond.pop());
	}
	
	public void visit(ForStatementMarker stm) {
		Code.fixup(forStm.pop());
		while(this.pocetakIfa.size() > 0) {
			Code.fixup(pocetakIfa.pop());
		}
	}
	
	public void visit(ForStatement stm) {
		int step = forStep.pop();
		Code.putJump(step);
		Code.fixup(forSkip.pop());
		
		LinkedList<Integer> l1 = breakStack.pop();
		for(int i = 0;i<l1.size();i++) {
			Code.fixup(l1.get(i));
		}
		
		LinkedList<Integer> l2 = continueStack.pop();
		for(int i = 0;i<l2.size();i++) {
			Code.put2(l2.get(i), step - l2.get(i) + 1);
		}
	}
	
	public void visit(BreakStatement stm) {
		Code.put(Code.jmp);
		Code.put2(0);
		breakStack.peek().add(Code.pc - 2);
	}
	
	public void visit(ContinueStatement stm) {
		Code.put(Code.jmp);
		Code.put2(0);
		continueStack.peek().add(Code.pc - 2);
	}
	
	public void visit(ProgramName program){
        Obj chr = Tab.find("chr");
        chr.setAdr(Code.pc);
        Code.put(Code.return_);
        Obj ord = Tab.find("ord");
        ord.setAdr(Code.pc);
        Code.put(Code.return_);
        Obj len = Tab.find("len");
        len.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(1);
        Code.put(1);
        Code.put(Code.load);
        Code.put(0);
        Code.loadConst(1);
        Code.put(Code.sub);
        Code.put(Code.getfield);
        Code.put2(0);
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

	
}
