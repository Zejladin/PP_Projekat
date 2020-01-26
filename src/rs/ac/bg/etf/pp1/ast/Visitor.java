// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(FormParsTail FormParsTail);
    public void visit(Mulop Mulop);
    public void visit(ConstDeclTail ConstDeclTail);
    public void visit(ActParsTail ActParsTail);
    public void visit(Relop Relop);
    public void visit(MethodVarList MethodVarList);
    public void visit(ProgramDeclList ProgramDeclList);
    public void visit(ExprTail ExprTail);
    public void visit(MethodVarListOption MethodVarListOption);
    public void visit(VarDeclTail VarDeclTail);
    public void visit(FormParsOption FormParsOption);
    public void visit(StatementList StatementList);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(DesignatorStatementOption DesignatorStatementOption);
    public void visit(Designator Designator);
    public void visit(AbstractClassMethods AbstractClassMethods);
    public void visit(AbstractClassMethodsOption AbstractClassMethodsOption);
    public void visit(FormParsNode FormParsNode);
    public void visit(VarDeclList VarDeclList);
    public void visit(TermTail TermTail);
    public void visit(ConstDeclNode ConstDeclNode);
    public void visit(Expr Expr);
    public void visit(ConditionTail ConditionTail);
    public void visit(CondTermTail CondTermTail);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ConditionOption ConditionOption);
    public void visit(ExtendsOption ExtendsOption);
    public void visit(Statement Statement);
    public void visit(VarDeclNode VarDeclNode);
    public void visit(ClassDecl ClassDecl);
    public void visit(CondFact CondFact);
    public void visit(ActParsOption ActParsOption);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(MethodTypeOption MethodTypeOption);
    public void visit(Minus Minus);
    public void visit(Plus Plus);
    public void visit(Mod Mod);
    public void visit(Div Div);
    public void visit(Mul Mul);
    public void visit(ExprFactor ExprFactor);
    public void visit(NewExprFactor NewExprFactor);
    public void visit(NewFactor NewFactor);
    public void visit(BoolConstFactor BoolConstFactor);
    public void visit(CharConstFactor CharConstFactor);
    public void visit(NumConstFactor NumConstFactor);
    public void visit(DesignatorActParsFactor DesignatorActParsFactor);
    public void visit(NoActParsOption NoActParsOption);
    public void visit(YesActParsOption YesActParsOption);
    public void visit(NoTermTail NoTermTail);
    public void visit(ContinueTermTail ContinueTermTail);
    public void visit(Term Term);
    public void visit(LessEqual LessEqual);
    public void visit(Less Less);
    public void visit(GreaterEqual GreaterEqual);
    public void visit(Greater Greater);
    public void visit(NotEqual NotEqual);
    public void visit(Equal Equal);
    public void visit(NoActParsTail NoActParsTail);
    public void visit(ContinueActParsTail ContinueActParsTail);
    public void visit(ActPars ActPars);
    public void visit(Assignop Assignop);
    public void visit(DesignatorArray DesignatorArray);
    public void visit(DesignatorDot DesignatorDot);
    public void visit(DesignatorIdent DesignatorIdent);
    public void visit(NoExprTail NoExprTail);
    public void visit(ContinueExprTail ContinueExprTail);
    public void visit(ExprLongTerm ExprLongTerm);
    public void visit(ExprMinusTerm ExprMinusTerm);
    public void visit(ExprTerm ExprTerm);
    public void visit(NoConditionOption NoConditionOption);
    public void visit(YesConditionOption YesConditionOption);
    public void visit(NoDesignatorStatementOption NoDesignatorStatementOption);
    public void visit(YesDesignatorStatementOption YesDesignatorStatementOption);
    public void visit(CondFactRelop CondFactRelop);
    public void visit(CondFactNoRelop CondFactNoRelop);
    public void visit(NoCondTermTail NoCondTermTail);
    public void visit(ContinueCondTermTail ContinueCondTermTail);
    public void visit(CondTerm CondTerm);
    public void visit(NoConditionTail NoConditionTail);
    public void visit(ContinueConditionTail ContinueConditionTail);
    public void visit(Condition Condition);
    public void visit(DesignatorStatementError DesignatorStatementError);
    public void visit(DesignatorStatementDec DesignatorStatementDec);
    public void visit(DesignatorStatementInc DesignatorStatementInc);
    public void visit(DesignatorStatementNoActPars DesignatorStatementNoActPars);
    public void visit(DesignatorStatementActPars DesignatorStatementActPars);
    public void visit(DesignatorStatementAssignop DesignatorStatementAssignop);
    public void visit(StatementStatement StatementStatement);
    public void visit(PrintNumStatement PrintNumStatement);
    public void visit(PrintStatement PrintStatement);
    public void visit(ReadStatement ReadStatement);
    public void visit(ReturnExprStatement ReturnExprStatement);
    public void visit(ReturnStatement ReturnStatement);
    public void visit(ContinueStatement ContinueStatement);
    public void visit(BreakStatement BreakStatement);
    public void visit(ForStatement ForStatement);
    public void visit(IfElseStatement IfElseStatement);
    public void visit(IfStatement IfStatement);
    public void visit(DesignatorStatementStatement DesignatorStatementStatement);
    public void visit(ClassDeclMethods ClassDeclMethods);
    public void visit(ClassDeclNoMethods ClassDeclNoMethods);
    public void visit(NoFormParsTail NoFormParsTail);
    public void visit(ContinueFormParsTail ContinueFormParsTail);
    public void visit(FormParsNodeError FormParsNodeError);
    public void visit(FormParsNodeArray FormParsNodeArray);
    public void visit(FormParsNodeSingle FormParsNodeSingle);
    public void visit(FormPars FormPars);
    public void visit(AbstractMethodDecl AbstractMethodDecl);
    public void visit(NoStatementList NoStatementList);
    public void visit(ContinueStatementList ContinueStatementList);
    public void visit(NoFormPars NoFormPars);
    public void visit(NoFormParsOption NoFormParsOption);
    public void visit(YesFormParsOption YesFormParsOption);
    public void visit(VoidMethod VoidMethod);
    public void visit(MethodType MethodType);
    public void visit(MethodDecl MethodDecl);
    public void visit(MethodVarListMany MethodVarListMany);
    public void visit(MethodVarListOne MethodVarListOne);
    public void visit(NoMethodVarListOption NoMethodVarListOption);
    public void visit(YesMethodVarListOption YesMethodVarListOption);
    public void visit(NoAbstractClassMethods NoAbstractClassMethods);
    public void visit(AbstractClassMethodsAbstractMethod AbstractClassMethodsAbstractMethod);
    public void visit(AbstractClassMethodsMethod AbstractClassMethodsMethod);
    public void visit(NoAbstractClassMethodsOptions NoAbstractClassMethodsOptions);
    public void visit(YesAbstractClassMethodsOption YesAbstractClassMethodsOption);
    public void visit(NoExtendsOption NoExtendsOption);
    public void visit(YesExtendsOption YesExtendsOption);
    public void visit(AbstractClassDecl AbstractClassDecl);
    public void visit(Type Type);
    public void visit(NoVarDeclTail NoVarDeclTail);
    public void visit(YesVarDeclTail YesVarDeclTail);
    public void visit(VarDeclNodeError VarDeclNodeError);
    public void visit(VarDeclNodeArray VarDeclNodeArray);
    public void visit(VarDeclNodeSingle VarDeclNodeSingle);
    public void visit(VarDeclError VarDeclError);
    public void visit(VarDeclListt VarDeclListt);
    public void visit(NoConstDeclTail NoConstDeclTail);
    public void visit(ContinueConstDeclTail ContinueConstDeclTail);
    public void visit(ConstDeclBool ConstDeclBool);
    public void visit(ConstDeclChar ConstDeclChar);
    public void visit(ConstDeclNum ConstDeclNum);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(NoMethodDeclList NoMethodDeclList);
    public void visit(ContinueMethodDeclList ContinueMethodDeclList);
    public void visit(NoProgramDecl NoProgramDecl);
    public void visit(ProgramDeclClass ProgramDeclClass);
    public void visit(ProgramDeclAbstractClass ProgramDeclAbstractClass);
    public void visit(ProgramDeclVar ProgramDeclVar);
    public void visit(ProgramDeclConst ProgramDeclConst);
    public void visit(Program Program);

}
