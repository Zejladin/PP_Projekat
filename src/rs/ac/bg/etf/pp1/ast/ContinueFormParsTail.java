// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class ContinueFormParsTail extends FormParsTail {

    private FormParsTail FormParsTail;
    private FormParsNode FormParsNode;

    public ContinueFormParsTail (FormParsTail FormParsTail, FormParsNode FormParsNode) {
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
        buffer.append("ContinueFormParsTail(\n");

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
        buffer.append(") [ContinueFormParsTail]");
        return buffer.toString();
    }
}
