// generated with ast extension for cup
// version 0.8
// 25/0/2020 22:59:26


package rs.ac.bg.etf.pp1.ast;

public class FormParsTail implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private FormParsTail FormParsTail;
    private FormParsNode FormParsNode;

    public FormParsTail (FormParsTail FormParsTail, FormParsNode FormParsNode) {
        this.FormParsTail=FormParsTail;
        if(FormParsTail!=null) FormParsTail.setParent(this);
        this.FormParsNode=FormParsNode;
        if(FormParsNode!=null) FormParsNode.setParent(this);
    }

    public FormParsTail getFormParsTail() {
        return FormParsTail;
    }

    public void setFormParsTail(FormParsTail FormParsTail) {
        this.FormParsTail=FormParsTail;
    }

    public FormParsNode getFormParsNode() {
        return FormParsNode;
    }

    public void setFormParsNode(FormParsNode FormParsNode) {
        this.FormParsNode=FormParsNode;
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
        if(FormParsTail!=null) FormParsTail.accept(visitor);
        if(FormParsNode!=null) FormParsNode.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsTail!=null) FormParsTail.traverseTopDown(visitor);
        if(FormParsNode!=null) FormParsNode.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsTail!=null) FormParsTail.traverseBottomUp(visitor);
        if(FormParsNode!=null) FormParsNode.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsTail(\n");

        if(FormParsTail!=null)
            buffer.append(FormParsTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsNode!=null)
            buffer.append(FormParsNode.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsTail]");
        return buffer.toString();
    }
}
