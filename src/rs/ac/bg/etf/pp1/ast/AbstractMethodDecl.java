// generated with ast extension for cup
// version 0.8
// 25/0/2020 22:59:26


package rs.ac.bg.etf.pp1.ast;

public class AbstractMethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodTypeOption MethodTypeOption;
    private String I2;
    private FormParsOption FormParsOption;

    public AbstractMethodDecl (MethodTypeOption MethodTypeOption, String I2, FormParsOption FormParsOption) {
        this.MethodTypeOption=MethodTypeOption;
        if(MethodTypeOption!=null) MethodTypeOption.setParent(this);
        this.I2=I2;
        this.FormParsOption=FormParsOption;
        if(FormParsOption!=null) FormParsOption.setParent(this);
    }

    public MethodTypeOption getMethodTypeOption() {
        return MethodTypeOption;
    }

    public void setMethodTypeOption(MethodTypeOption MethodTypeOption) {
        this.MethodTypeOption=MethodTypeOption;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public FormParsOption getFormParsOption() {
        return FormParsOption;
    }

    public void setFormParsOption(FormParsOption FormParsOption) {
        this.FormParsOption=FormParsOption;
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
        if(MethodTypeOption!=null) MethodTypeOption.accept(visitor);
        if(FormParsOption!=null) FormParsOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodTypeOption!=null) MethodTypeOption.traverseTopDown(visitor);
        if(FormParsOption!=null) FormParsOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodTypeOption!=null) MethodTypeOption.traverseBottomUp(visitor);
        if(FormParsOption!=null) FormParsOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractMethodDecl(\n");

        if(MethodTypeOption!=null)
            buffer.append(MethodTypeOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(FormParsOption!=null)
            buffer.append(FormParsOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractMethodDecl]");
        return buffer.toString();
    }
}
