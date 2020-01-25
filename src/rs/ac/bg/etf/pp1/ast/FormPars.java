// generated with ast extension for cup
// version 0.8
// 25/0/2020 22:59:26


package rs.ac.bg.etf.pp1.ast;

public class FormPars implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private FormParsNode FormParsNode;
    private FormParsTail FormParsTail;

    public FormPars (FormParsNode FormParsNode, FormParsTail FormParsTail) {
        this.FormParsNode=FormParsNode;
        if(FormParsNode!=null) FormParsNode.setParent(this);
        this.FormParsTail=FormParsTail;
        if(FormParsTail!=null) FormParsTail.setParent(this);
    }

    public FormParsNode getFormParsNode() {
        return FormParsNode;
    }

    public void setFormParsNode(FormParsNode FormParsNode) {
        this.FormParsNode=FormParsNode;
    }

    public FormParsTail getFormParsTail() {
        return FormParsTail;
    }

    public void setFormParsTail(FormParsTail FormParsTail) {
        this.FormParsTail=FormParsTail;
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
        if(FormParsNode!=null) FormParsNode.accept(visitor);
        if(FormParsTail!=null) FormParsTail.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsNode!=null) FormParsNode.traverseTopDown(visitor);
        if(FormParsTail!=null) FormParsTail.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsNode!=null) FormParsNode.traverseBottomUp(visitor);
        if(FormParsTail!=null) FormParsTail.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormPars(\n");

        if(FormParsNode!=null)
            buffer.append(FormParsNode.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsTail!=null)
            buffer.append(FormParsTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormPars]");
        return buffer.toString();
    }
}
