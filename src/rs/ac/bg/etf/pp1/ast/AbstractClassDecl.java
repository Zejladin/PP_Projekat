// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private ExtendsOption ExtendsOption;
    private MethodVarListOption MethodVarListOption;
    private AbstractClassMethodsOption AbstractClassMethodsOption;

    public AbstractClassDecl (String I1, ExtendsOption ExtendsOption, MethodVarListOption MethodVarListOption, AbstractClassMethodsOption AbstractClassMethodsOption) {
        this.I1=I1;
        this.ExtendsOption=ExtendsOption;
        if(ExtendsOption!=null) ExtendsOption.setParent(this);
        this.MethodVarListOption=MethodVarListOption;
        if(MethodVarListOption!=null) MethodVarListOption.setParent(this);
        this.AbstractClassMethodsOption=AbstractClassMethodsOption;
        if(AbstractClassMethodsOption!=null) AbstractClassMethodsOption.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ExtendsOption getExtendsOption() {
        return ExtendsOption;
    }

    public void setExtendsOption(ExtendsOption ExtendsOption) {
        this.ExtendsOption=ExtendsOption;
    }

    public MethodVarListOption getMethodVarListOption() {
        return MethodVarListOption;
    }

    public void setMethodVarListOption(MethodVarListOption MethodVarListOption) {
        this.MethodVarListOption=MethodVarListOption;
    }

    public AbstractClassMethodsOption getAbstractClassMethodsOption() {
        return AbstractClassMethodsOption;
    }

    public void setAbstractClassMethodsOption(AbstractClassMethodsOption AbstractClassMethodsOption) {
        this.AbstractClassMethodsOption=AbstractClassMethodsOption;
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
        if(ExtendsOption!=null) ExtendsOption.accept(visitor);
        if(MethodVarListOption!=null) MethodVarListOption.accept(visitor);
        if(AbstractClassMethodsOption!=null) AbstractClassMethodsOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsOption!=null) ExtendsOption.traverseTopDown(visitor);
        if(MethodVarListOption!=null) MethodVarListOption.traverseTopDown(visitor);
        if(AbstractClassMethodsOption!=null) AbstractClassMethodsOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsOption!=null) ExtendsOption.traverseBottomUp(visitor);
        if(MethodVarListOption!=null) MethodVarListOption.traverseBottomUp(visitor);
        if(AbstractClassMethodsOption!=null) AbstractClassMethodsOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ExtendsOption!=null)
            buffer.append(ExtendsOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodVarListOption!=null)
            buffer.append(MethodVarListOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AbstractClassMethodsOption!=null)
            buffer.append(AbstractClassMethodsOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDecl]");
        return buffer.toString();
    }
}
