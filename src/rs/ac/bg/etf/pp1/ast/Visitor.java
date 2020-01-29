// generated with ast extension for cup
// version 0.8
// 29/0/2020 18:20:51


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Mulop Mulop);
    public void visit(Relop Relop);
    public void visit(Assignop Assignop);
    public void visit(MethodType MethodType);
    public void visit(MethDeclChoice MethDeclChoice);
    public void visit(StatementList StatementList);
    public void visit(FormalParamsChoice FormalParamsChoice);
    public void visit(Addop Addop);
    public void visit(ForCondPart ForCondPart);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(Designator Designator);
    public void visit(IfStartMarker IfStartMarker);
    public void visit(ActualParamsChoice ActualParamsChoice);
    public void visit(CondStatement CondStatement);
    public void visit(Term Term);
    public void visit(ClassImplementsChoice ClassImplementsChoice);
    public void visit(ProgramHeaderDeclList ProgramHeaderDeclList);
    public void visit(Condition Condition);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(AbstractClassMethodList AbstractClassMethodList);
    public void visit(ActualParams ActualParams);
    public void visit(ConstDeclCore ConstDeclCore);
    public void visit(FormalParam FormalParam);
    public void visit(VarDeclChoice VarDeclChoice);
    public void visit(ForStepPart ForStepPart);
    public void visit(VarDeclList VarDeclList);
    public void visit(Expr Expr);
    public void visit(FormalParams FormalParams);
    public void visit(ConstDeclMore ConstDeclMore);
    public void visit(ClassExtendsChoice ClassExtendsChoice);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(EnumTypeDecl EnumTypeDecl);
    public void visit(VarDeclCore VarDeclCore);
    public void visit(ForInitPart ForInitPart);
    public void visit(ClassImplementsMultiple ClassImplementsMultiple);
    public void visit(Statement Statement);
    public void visit(VarDeclMore VarDeclMore);
    public void visit(CondFact CondFact);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(AbstractMethDeclChoice AbstractMethDeclChoice);
    public void visit(LocalVarDeclList LocalVarDeclList);
    public void visit(ForStartMarker ForStartMarker);
    public void visit(ForStatementMarker ForStatementMarker);
    public void visit(NoForStep NoForStep);
    public void visit(ForStep ForStep);
    public void visit(NoForCond NoForCond);
    public void visit(ForCond ForCond);
    public void visit(NoForInit NoForInit);
    public void visit(ForInit ForInit);
    public void visit(IfElseStatement IfElseStatement);
    public void visit(IfStatement IfStatement);
    public void visit(IfElseMarker IfElseMarker);
    public void visit(IfCondError IfCondError);
    public void visit(IfStartMarkerCond IfStartMarkerCond);
    public void visit(DesignatorError DesignatorError);
    public void visit(DesignatorDec DesignatorDec);
    public void visit(DesignatorInc DesignatorInc);
    public void visit(DesignatorCall DesignatorCall);
    public void visit(DesignatorAssign DesignatorAssign);
    public void visit(ForStatement ForStatement);
    public void visit(DesignatorStatementBase DesignatorStatementBase);
    public void visit(ReadStatement ReadStatement);
    public void visit(ConditionalStatement ConditionalStatement);
    public void visit(PrintStatementTwoArg PrintStatementTwoArg);
    public void visit(PrintStatementOneArg PrintStatementOneArg);
    public void visit(ReturnStatement ReturnStatement);
    public void visit(ReturnStatementVoid ReturnStatementVoid);
    public void visit(MultipleStatements MultipleStatements);
    public void visit(ContinueStatement ContinueStatement);
    public void visit(BreakStatement BreakStatement);
    public void visit(NoStatement NoStatement);
    public void visit(SingleStatement SingleStatement);
    public void visit(CondFactRel CondFactRel);
    public void visit(CondFactBase CondFactBase);
    public void visit(CondTermList CondTermList);
    public void visit(CondTermBase CondTermBase);
    public void visit(ConditionList ConditionList);
    public void visit(ConditionBase ConditionBase);
    public void visit(MulopMod MulopMod);
    public void visit(MulopDiv MulopDiv);
    public void visit(MulopMul MulopMul);
    public void visit(AddopSub AddopSub);
    public void visit(AddopAdd AddopAdd);
    public void visit(RelopLessEqual RelopLessEqual);
    public void visit(RelopLessThan RelopLessThan);
    public void visit(RelopGreaterEqual RelopGreaterEqual);
    public void visit(RelopGreaterThan RelopGreaterThan);
    public void visit(RelopNotEquals RelopNotEquals);
    public void visit(RelopEquals RelopEquals);
    public void visit(FactorDesignatorCall FactorDesignatorCall);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(FactorGrouped FactorGrouped);
    public void visit(FactorAllocationArray FactorAllocationArray);
    public void visit(FactorAllocation FactorAllocation);
    public void visit(FactorBool FactorBool);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNum FactorNum);
    public void visit(DesignatorArray DesignatorArray);
    public void visit(DesignatorDot DesignatorDot);
    public void visit(DesignatorIdent DesignatorIdent);
    public void visit(ArrayLoadMarker ArrayLoadMarker);
    public void visit(DesignatorBase DesignatorBase);
    public void visit(TermList TermList);
    public void visit(TermBase TermBase);
    public void visit(AssignopDerived1 AssignopDerived1);
    public void visit(ExprList ExprList);
    public void visit(ExprNegatedTerm ExprNegatedTerm);
    public void visit(ExprTerm ExprTerm);
    public void visit(ActualParamsMultiple ActualParamsMultiple);
    public void visit(ActualParamsSingle ActualParamsSingle);
    public void visit(NoActualParams NoActualParams);
    public void visit(HasActualParams HasActualParams);
    public void visit(AbstractMethodDecl AbstractMethodDecl);
    public void visit(NoAbstractClassMethod NoAbstractClassMethod);
    public void visit(AbstractClassAbstractMethodDecl AbstractClassAbstractMethodDecl);
    public void visit(AbstractClassMethodDecl AbstractClassMethodDecl);
    public void visit(AbstractNoMethodDecl AbstractNoMethodDecl);
    public void visit(AbstractYesMethodDecl AbstractYesMethodDecl);
    public void visit(AbstractClassDecl AbstractClassDecl);
    public void visit(ClassExtendsError ClassExtendsError);
    public void visit(NoClassExtends NoClassExtends);
    public void visit(ClassExtends ClassExtends);
    public void visit(ClassDecl ClassDecl);
    public void visit(ClassDeclHeader ClassDeclHeader);
    public void visit(ClassNoMethodDecl ClassNoMethodDecl);
    public void visit(ClassMethodDecl ClassMethodDecl);
    public void visit(MethodTypeVoid MethodTypeVoid);
    public void visit(MethodTypeActual MethodTypeActual);
    public void visit(MethodName MethodName);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMethodList NoMethodList);
    public void visit(MethodList MethodList);
    public void visit(FormalParamError FormalParamError);
    public void visit(FormalParamArray FormalParamArray);
    public void visit(FormalParamSingle FormalParamSingle);
    public void visit(FormalParamsNext FormalParamsNext);
    public void visit(FormalParamsFirst FormalParamsFirst);
    public void visit(NoFormalParams NoFormalParams);
    public void visit(HasFormalParams HasFormalParams);
    public void visit(VarDeclNo VarDeclNo);
    public void visit(VarDeclYes VarDeclYes);
    public void visit(MethodVarDeclMultiple MethodVarDeclMultiple);
    public void visit(MethodVarDeclSingle MethodVarDeclSingle);
    public void visit(VarDeclCoreError VarDeclCoreError);
    public void visit(VarDeclArray VarDeclArray);
    public void visit(VarDecl VarDecl);
    public void visit(NoVarDecl NoVarDecl);
    public void visit(VarDeclMultiple VarDeclMultiple);
    public void visit(VarDeclError VarDeclError);
    public void visit(VarDeclBase VarDeclBase);
    public void visit(ConstDeclBool ConstDeclBool);
    public void visit(ConstDeclChar ConstDeclChar);
    public void visit(ConstDeclNum ConstDeclNum);
    public void visit(NoConstDecl NoConstDecl);
    public void visit(ConstDeclMultiple ConstDeclMultiple);
    public void visit(ConstDeclBase ConstDeclBase);
    public void visit(NoProgramHeaderDecl NoProgramHeaderDecl);
    public void visit(ProgramHeaderClassDecl ProgramHeaderClassDecl);
    public void visit(ProgramHeaderAbstractClassDecl ProgramHeaderAbstractClassDecl);
    public void visit(ProgramHeaderVarDecl ProgramHeaderVarDecl);
    public void visit(ProgramHeaderConstDecl ProgramHeaderConstDecl);
    public void visit(Type Type);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
