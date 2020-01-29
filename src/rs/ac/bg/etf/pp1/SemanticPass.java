package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends RuleVisitor {
	
	Logger log = Logger.getLogger(getClass());
	
	private Obj curClass = Tab.noObj;
	private Obj curMethod = Tab.noObj;
	
	private boolean errorDetected;

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
			this.report_error("Greska, promenljiva sa imenom " + vardecl.getVarName() + " vec postoji", null);
		}
	}
	
	public void visit(VarDeclArray vardecl) {
		if(SemanticPass.find(vardecl.getVarName()) == Tab.noObj) {
			
		}
		else {
			this.report_error("Greska, promenljiva sa imenom " + vardecl.getVarName() + " vec postoji", null);
		}
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
			Tab.openScope();
			curMethod.setLevel(0);
			curMethod.setFpPos(0);
		}
		
	}
	
	public void visit(MethodDecl methodDecl) {
		Tab.chainLocalSymbols(methodDecl.getMethodName().obj);
		Tab.closeScope();
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
}
