package rs.ac.bg.etf.pp1;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends RuleVisitor {
	
	Logger log = Logger.getLogger(getClass());
	
	private Obj curClass = Tab.noObj;
	private Obj curMethod = Tab.noObj;
	
	public int varCount = 0;
	
	private int loopDepth = 0;
	
	private boolean errorDetected;
	private boolean returnFound = false;

	public SemanticPass() {
		Tab.insert(Obj.Type, "bool", new Struct(Struct.Bool)).getType();
	}
	
	public boolean getErrorDetected() {
		return errorDetected;
	}
	
	private static Obj find(String name) {
		if(Tab.currentScope().getLocals() == null)
			return Tab.noObj;
		else {
			if(Tab.currentScope().getLocals().searchKey(name) == null) 
				return Tab.noObj;
			else 
				return null;
		}
	}
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public void visit(ProgramName programName) {
		programName.obj = Tab.insert(Obj.Prog, programName.getProgName(), Tab.noType);
		Tab.openScope();
	}
	
	public void visit(Program prog) {
		Tab.chainLocalSymbols(prog.getProgramName().obj);
		Tab.closeScope();
	}

	public void visit(ClassDeclHeader classHeader) {
		if(SemanticPass.find(classHeader.getClassName()) == Tab.noObj) {
			curClass = Tab.insert(Obj.Type, classHeader.getClassName(), new Struct(Struct.Class));
			curClass.getType().setElementType(Tab.noType);
			Tab.openScope();
		}
		else {
			this.report_error("GReska, klasa sa imenom " + classHeader.getClassName() + " vec postoji", null);
		}
	}
	
	public void visit(ClassDecl classDecl) {
		Tab.chainLocalSymbols(curClass.getType());
		curClass = Tab.noObj;
		Tab.closeScope();
	}
	
	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if(typeNode == Tab.noObj) {
			this.report_error("Tip " + type.getTypeName() + " ne postoji", null);
			type.struct = Tab.noType;
		}
		else {
			if(typeNode.getKind() == Obj.Type) {
				type.struct = typeNode.getType();
			} 
			else {
				report_error("Greska " + type.getTypeName() + " ne predstavlja tip!", null);
				type.struct = Tab.noType;
			}
		}
	}
	
	private Type getVarType(VarDeclCore core) {
		SyntaxNode parent = core.getParent();
		while(!(parent instanceof VarDeclBase)) {
			parent = parent.getParent();
		}
		return ((VarDeclBase)parent).getType();
	}
	
	public static int getNumOfFields(Struct struc) {
		if(struc.getElemType() == Tab.noType)
			return 0;
		return struc.getElemType().getNumberOfFields();
	}
	
	public void visit(VarDecl vardecl) {
		if(SemanticPass.find(vardecl.getVarName()) == Tab.noObj) {
			Type varType = getVarType(vardecl);
			if(curClass != Tab.noObj && curMethod == Tab.noObj) {
				Obj o = Tab.insert(Obj.Fld, vardecl.getVarName(), varType.struct);
				o.setAdr(o.getAdr() + SemanticPass.getNumOfFields(curClass.getType()));
			}
			else {
				Tab.insert(Obj.Var, vardecl.getVarName(), varType.struct);
			}
		}
		else {
			this.report_error("Greska,  promenljiva sa imenom " + vardecl.getVarName() + " vec postoji", null);
		}
		if(curMethod == Tab.noObj)
			varCount++;
	}
	
	public int getVarCount() {
		return this.varCount;
	}
	
	public void visit(VarDeclArray vardecl) {
		if(SemanticPass.find(vardecl.getVarName()) == Tab.noObj) {
			Type varType = getVarType(vardecl);
			Struct myStruc = new Struct(Struct.Array, varType.struct);
			if(curClass != Tab.noObj && curMethod == Tab.noObj) {
				Obj o = Tab.insert(Obj.Fld, vardecl.getVarName(), myStruc);
				this.report_info("Pravim novi niz sa " + myStruc, null);
				o.setAdr(o.getAdr() + SemanticPass.getNumOfFields(curClass.getType()));
			}
			else {
				Tab.insert(Obj.Var, vardecl.getVarName(), myStruc);
				this.report_info("Pravim novi niz tipa " + varType, vardecl);
			}
		}
		else {
			this.report_error("Greska, promenljiva sa imenom " + vardecl.getVarName() + " vec postoji", null);
		}
		if(curMethod == Tab.noObj)
			varCount++;
	}
	
	public void visit(MethodName methodName) {
		MethodDecl parent = (MethodDecl) methodName.getParent();
		Struct methodType;
		if(parent.getMethodType() instanceof MethodTypeVoid)
			methodType = Tab.noType;
		else
			methodType = ((MethodTypeActual)parent.getMethodType()).getType().struct;
		if(SemanticPass.find(methodName.getMethodName()) != Tab.noObj)
			this.report_error("Greska, metoda vec postoji", null);
		else {
			methodName.obj = Tab.insert(Obj.Meth, methodName.getMethodName(), methodType);
			curMethod = methodName.obj;
			Tab.openScope();
			curMethod.setLevel(0);
			curMethod.setFpPos(0);
			if(curClass != Tab.noObj) {
				Tab.insert(Obj.Var, "this", curClass.getType());
				curMethod.setLevel(1);
				curMethod.setFpPos(1);
			}
		}
		
	}
	
	public void visit(MethodDecl methodDecl) {
		if(returnFound == false && curMethod.getType() != Tab.noType) {
			this.report_error("Greska, funkcija nema return statement", methodDecl);
		}
		Tab.chainLocalSymbols(methodDecl.getMethodName().obj);
		Tab.closeScope();
		returnFound = false;
		curMethod = Tab.noObj;
	}
	
	private static Type getConstDeclType(ConstDeclCore core) {
		SyntaxNode parent = core.getParent();
		while(!(parent instanceof ConstDeclBase)) {
			parent = parent.getParent();
		}
		return ((ConstDeclBase)parent).getType();
	}
	
	public void visit(ConstDeclNum numConst) {
		Type type = getConstDeclType(numConst);
		if(type.struct != Tab.intType) {
			this.report_error("Pogresan tip konstante uparen sa numerickom konstantom", null);
		}
		else {
			if(SemanticPass.find(numConst.getConstIdentifier()) != Tab.noObj) {
				this.report_error("Iskorisceno zauzeto ime za konstantu", null);
			}
			Obj con = Tab.insert(Obj.Con, numConst.getConstIdentifier(), Tab.intType);
			con.setAdr(numConst.getConstVal());
		}
	}
	
	public void visit(ConstDeclChar charConst) {
		Type type = getConstDeclType(charConst);
		if(type.struct != Tab.charType) {
			this.report_error("Pogresan tip konstante uparen sa numerickom konstantom", null);
		}
		else {
			if(SemanticPass.find(charConst.getConstIdentifier()) != Tab.noObj) {
				this.report_error("Iskorisceno zauzeto ime za konstantu", null);
			}
			Obj con = Tab.insert(Obj.Con, charConst.getConstIdentifier(), Tab.charType);
			con.setAdr(charConst.getConstVal());
		}
	}
	
	public void visit(ConstDeclBool boolConst) {
		Type type = getConstDeclType(boolConst);
		Struct s = Tab.find("bool").getType();
		if(type.struct != s) {
			this.report_error("Greska u assajnovanju", boolConst);
		}
		else {
			if(SemanticPass.find(boolConst.getConstIdentifier()) != Tab.noObj) {
				this.report_error("Ime promenljive vec iskorisceno", boolConst);
			}
			else {
				Obj newConst = Tab.insert(Obj.Con, boolConst.getConstIdentifier(), s);
				newConst.setAdr((boolConst.getConstVal() == true)? 1 : 0);
			}
		}
	}
	
	public void visit(FormalParamSingle formPar) {
		if(SemanticPass.find(formPar.getParamName()) == Tab.noObj) {
			Obj o = Tab.insert(Obj.Var, formPar.getParamName(), formPar.getType().struct);
			int pos = 0;
			if(Tab.currentScope().getLocals() != null)
				pos = Tab.currentScope().getLocals().symbols().size();
			o.setFpPos(pos);
			curMethod.setLevel(curMethod.getLevel() + 1);
			
		}
		else {
			this.report_error("Pogresno ime za formalni argument " + formPar.getParamName(), null);
		}
	}
	
	public void visit(FormalParamArray formPar) {
		if(SemanticPass.find(formPar.getParamName()) == Tab.noObj) {
			Struct type = new Struct(Struct.Array, formPar.getType().struct);
			Obj o = Tab.insert(Obj.Var, formPar.getParamName(), type);
			int pos = 0;
			if(Tab.currentScope().getLocals() != null)
				pos = Tab.currentScope().getLocals().symbols().size();
			o.setFpPos(pos);
			curMethod.setLevel(curMethod.getLevel() + 1);
		} 
		else {
			this.report_error("Pogresno ime za formalni argument " + formPar.getParamName(), null);
		}
	}
	
	public void visit(DesignatorBase base) {
		base.obj = base.getDesignator().obj;
	}
	
	public void visit(DesignatorIdent des) {
		Obj o = Tab.find(des.getDesignatorName());
		if(o == Tab.noObj) {
			this.report_error("Greska, referencirana varijabla koja ne postoji", null);
		}
		des.obj = o;
	}
	
	public void visit(DesignatorInc des) {
		if(des.getDesignatorBase().obj.getType() != Tab.intType) {
			this.report_error("Greska, nije moguce inkrementirati ne int promenljivu", null);
		}
		if(!(des.getDesignatorBase().obj.getKind() == Obj.Var || des.getDesignatorBase().obj.getKind() == Obj.Elem || des.getDesignatorBase().obj.getKind() == Obj.Fld)) {
			this.report_error("greska, tip promenljive nije moguce promeniti", null);
		}
	}
	
	public void visit(DesignatorDec des) {
		if(des.getDesignatorBase().obj.getType() != Tab.intType) {
			this.report_error("Greska, nije moguce dekrementirati ne int promenljivu", null);
		}
		if(!(des.getDesignatorBase().obj.getKind() == Obj.Var || des.getDesignatorBase().obj.getKind() == Obj.Elem || des.getDesignatorBase().obj.getKind() == Obj.Fld)) {
			this.report_error("greska, tip promenljive nije moguce promeniti", null);
		}
	}
	
	public void visit(DesignatorAssign des) {
		if(!(des.getDesignatorBase().obj.getKind() == Obj.Var || des.getDesignatorBase().obj.getKind() == Obj.Elem || des.getDesignatorBase().obj.getKind() == Obj.Fld)) {
			this.report_error("Promenljiva ovog tipa se ne moze promeniti assignom!", null);
		}
		this.report_info(des.getExpr().struct.toString(), null);
		this.report_info(des.getDesignatorBase().obj.getType().toString(), null);
		if(des.getDesignatorBase().obj.getType().getKind() == Struct.Array && des.getExpr().struct.getKind() == Struct.Array) {
			if(des.getDesignatorBase().obj.getType().getElemType() != des.getExpr().struct.getElemType()) {
				this.report_error("Greska pri dodeli vrednosti", des);
			}
		}
		else if(des.getDesignatorBase().obj.getType() != des.getExpr().struct) {
			this.report_error("Greska pri dodeli vrednosti", des);
		}
	}
	
	public void visit(FactorDesignator fac) {
		fac.struct = fac.getDesignatorBase().obj.getType();
	}
	
	public void visit(FactorNum fac) {
		fac.struct = Tab.intType;
	}
	
	public void visit(FactorChar fac) {
		fac.struct = Tab.charType;
	}
	
	public void visit(FactorBool fac) {
		fac.struct = Tab.find("bool").getType();
	}
	
	public void visit(TermBase term) {
		term.struct = term.getFactor().struct;
	}
	
	public void visit(ExprTerm exp) {
		exp.struct = exp.getTerm().struct;
	}
	
	public void visit(DesignatorCall des) {
		if(des.getDesignatorBase().obj.getKind() != Obj.Meth)
			this.report_error("Pokusaj pozivanja ne metode!!", null);
	}
	
	public void visit(NoActualParams actParams) {
		Obj o;
		if(actParams.getParent() instanceof DesignatorCall)
			o = ((DesignatorCall)actParams.getParent()).getDesignatorBase().obj;
		else {
			o = ((FactorDesignatorCall)actParams.getParent()).getDesignatorBase().obj;
		}
		if(o.getLevel() != o.getFpPos()) {
			this.report_error("Pozvana metoda sa neodgovarajucim brojem parametra", null);
		}
	}
	
	public void visit(HasActualParams actParams) {
		Obj o;
		if(actParams.getParent() instanceof DesignatorCall) {
			o = ((DesignatorCall)actParams.getParent()).getDesignatorBase().obj;
		}
		else {
			o = ((FactorDesignatorCall)actParams.getParent()).getDesignatorBase().obj;
		}
		this.report_info("Fp ove funkcije je " + o.getFpPos(), null);
		Collection<Obj> c = o.getLocalSymbols();
		Iterator<Obj> i = c.iterator();
		ActualParams par = actParams.getActualParams();
		while(par instanceof ActualParamsMultiple)
			par = ((ActualParamsMultiple)par).getActualParams();
		Struct s = ((ActualParamsSingle)par).getExpr().struct;
		while(i.hasNext()) {
			Obj ob = i.next();
			if(ob.getType() != s) {
				this.report_error("Argumenti ne odgovaraju pozivu funkcije!", null);
			}
			if(!(par.getParent() instanceof ActualParamsMultiple))
				break;
			par = (ActualParamsMultiple)par.getParent();
			s = ((ActualParamsMultiple)par).getExpr().struct;
		}
		if(par.getParent() instanceof ActualParamsMultiple) {
			this.report_error("Previse argumenata pri pozivu funkcije", null);
		}
	}
	
	public void visit(BreakStatement stm) {
		if(this.loopDepth == 0) {
			this.report_error("Greska, nije moguce pozvati break van for petlje", null);
		}
		this.loopDepth--;
	}
	
	public void visit(ContinueStatement stm) {
		if(this.loopDepth == 0) {
			this.report_error("Greska, nije moguce pozvati continue van for petlje", null);
		}
	}
	
	public void visit(ReadStatement stm) {
		Struct s = stm.getDesignatorBase().obj.getType();
		Struct bool = Tab.find("bool").getType();
		if(!(s == Tab.charType || s == Tab.intType || s == bool)) {
			this.report_error("Unesena promenljiva ne moze da se cita", null);
		}
	}
	
	public void visit(PrintStatementOneArg stm) {
		Struct s = stm.getExpr().struct;
		Struct bool = Tab.find("bool").getType();
		if(!(s == Tab.charType || s == Tab.intType || s == bool)) {
			this.report_error("Unesena promenljiva ne moze da se stampa jer nije primitivan tip", null);
		}
	}
	
	public void visit(PrintStatementTwoArg stm) {
		Struct s = stm.getExpr().struct;
		Struct bool = Tab.find("bool").getType();
		if(!(s == Tab.charType || s == Tab.intType || s == bool)) {
			this.report_error("Unesena promenljiva ne moze da se stampa jer nije primitivan tip", null);
		}
	}
	
	public void visit(ReturnStatementVoid stm) {
		if(curMethod == Tab.noObj) {
			this.report_error("Nije moguce koristiti return van funkcije", null);
		}
		if(curMethod.getType() != Tab.noType) {
			this.report_error("U void metodi se mora pozvati return bez argumenta", null);
		}
		this.returnFound = true;
	}
	
	public void visit(ReturnStatement stm) {
		if(curMethod == Tab.noObj) {
			this.report_error("Nije moguce koristiti return van funkcije", null);
		}
		if(curMethod.getType() != stm.getExpr().struct) {
			this.report_error("Pogresan tip povratne vrednosti!", null);
		}
		this.returnFound = true;
	}
	
	public void visit(ForStartMarker marker) {
		this.loopDepth++;
	}
	
	public void visit(ForStatement stm) {
		this.loopDepth--;
	}
	
	public void visit(CondFactRel condFact) {
		Struct s = condFact.getExpr().struct;
		Struct s1 = condFact.getExpr1().struct;
		if(s != s1) {
			this.report_error("Tipovi promenljivih nisu kompatibilni za poredjenje", condFact);
		}
		if(s.getKind() == Struct.Array) {
			if(!(condFact.getRelop() instanceof RelopEquals || condFact.getRelop() instanceof RelopNotEquals)) {
				this.report_error("Neodgovarajuca relaciona operacija za nizove!", condFact);
			}
		}
	}
	
	public void visit(ExprNegatedTerm expr) {
		if(expr.getTerm().struct != Tab.intType) {
			this.report_error("Samo integer promenljive mogu biti negativne", expr);
		}
		expr.struct = expr.getTerm().struct;
	}
	
	public void visit(ExprList expr) {
		if(expr.getExpr().struct != Tab.intType || expr.getTerm().struct != Tab.intType) {
			this.report_error("Greska, operandi pri sabiranju/oduzimanju moraju biti integeri!", expr);
		}
		expr.struct = expr.getTerm().struct;
	}
	
	public void visit(TermList term) {
		if(term.getTerm().struct != Tab.intType || term.getFactor().struct != Tab.intType) {
			this.report_error("Greska, operandi u multiplikativnim operacijama moraju biti integeri!", term);
		}
		term.struct = term.getTerm().struct;
	}
	
	public void visit(FactorDesignatorCall fact) {
		if(fact.getDesignatorBase().obj.getKind() != Obj.Meth) {
			this.report_error("Greska, pokusan poziv ne metode", fact);
		}
		fact.struct = fact.getDesignatorBase().obj.getType();
	}
	
	public void visit(FactorAllocationArray fact) {
		if(fact.getExpr().struct != Tab.intType) {
			this.report_error("Greska pri deklaraciji integera se mora koristiti integer!", fact);
		}
		fact.struct = new Struct(Struct.Array, fact.getType().struct);
		this.report_info("pravim novi niz tipa " + fact.getType().struct, fact);
	}
	
	public void visit(DesignatorArray des) {
		this.report_info(des.getDesignator().obj.getKind() + "asd ", null);
		if(des.getDesignator().obj.getType().getKind() != Struct.Array) {
			this.report_error("Designator mora biti niz", des);
		}
		if(des.getExpr().struct != Tab.intType) {
			this.report_error("Indeks mora biti integer!", des);
		}
		des.obj = new Obj(Obj.Elem, "", des.getDesignator().obj.getType().getElemType());
	}
	
	public void visit(FactorGrouped fac) {
		fac.struct = fac.getExpr().struct;
	}
}
