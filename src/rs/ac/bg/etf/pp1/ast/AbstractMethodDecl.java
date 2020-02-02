// generated with ast extension for cup
// version 0.8
// 2/1/2020 0:4:59


package rs.ac.bg.etf.pp1.ast;

public class AbstractMethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodType MethodType;
    private MethodName MethodName;
    private FormalParamsChoice FormalParamsChoice;

    public AbstractMethodDecl (MethodType MethodType, MethodName MethodName, FormalParamsChoice FormalParamsChoice) {
        this.MethodType=MethodType;
        if(MethodType!=null) MethodType.setParent(this);
        this.MethodName=MethodName;
        if(MethodName!=null) MethodName.setParent(this);
        this.FormalParamsChoice=FormalParamsChoice;
        if(FormalParamsChoice!=null) FormalParamsChoice.setParent(this);
    }

    public MethodType getMethodType() {
        return MethodType;
    }

    public void setMethodType(MethodType MethodType) {
        this.MethodType=MethodType;
    }

    public MethodName getMethodName() {
        return MethodName;
    }

    public void setMethodName(MethodName MethodName) {
        this.MethodName=MethodName;
    }

    public FormalParamsChoice getFormalParamsChoice() {
        return FormalParamsChoice;
    }

    public void setFormalParamsChoice(FormalParamsChoice FormalParamsChoice) {
        this.FormalParamsChoice=FormalParamsChoice;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodType!=null) MethodType.accept(visitor);
        if(MethodName!=null) MethodName.accept(visitor);
        if(FormalParamsChoice!=null) FormalParamsChoice.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodType!=null) MethodType.traverseTopDown(visitor);
        if(MethodName!=null) MethodName.traverseTopDown(visitor);
        if(FormalParamsChoice!=null) FormalParamsChoice.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodType!=null) MethodType.traverseBottomUp(visitor);
        if(MethodName!=null) MethodName.traverseBottomUp(visitor);
        if(FormalParamsChoice!=null) FormalParamsChoice.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractMethodDecl(\n");

        if(MethodType!=null)
            buffer.append(MethodType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodName!=null)
            buffer.append(MethodName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormalParamsChoice!=null)
            buffer.append(FormalParamsChoice.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractMethodDecl]");
        return buffer.toString();
    }
}
