// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class ContinueConstDeclTail extends ConstDeclTail {

    private ConstDeclTail ConstDeclTail;
    private ConstDeclNode ConstDeclNode;

    public ContinueConstDeclTail (ConstDeclTail ConstDeclTail, ConstDeclNode ConstDeclNode) {
        this.ConstDeclTail=ConstDeclTail;
        if(ConstDeclTail!=null) ConstDeclTail.setParent(this);
        this.ConstDeclNode=ConstDeclNode;
        if(ConstDeclNode!=null) ConstDeclNode.setParent(this);
    }

    public ConstDeclTail getConstDeclTail() {
        return ConstDeclTail;
    }

    public void setConstDeclTail(ConstDeclTail ConstDeclTail) {
        this.ConstDeclTail=ConstDeclTail;
    }

    public ConstDeclNode getConstDeclNode() {
        return ConstDeclNode;
    }

    public void setConstDeclNode(ConstDeclNode ConstDeclNode) {
        this.ConstDeclNode=ConstDeclNode;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclTail!=null) ConstDeclTail.accept(visitor);
        if(ConstDeclNode!=null) ConstDeclNode.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclTail!=null) ConstDeclTail.traverseTopDown(visitor);
        if(ConstDeclNode!=null) ConstDeclNode.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclTail!=null) ConstDeclTail.traverseBottomUp(visitor);
        if(ConstDeclNode!=null) ConstDeclNode.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ContinueConstDeclTail(\n");

        if(ConstDeclTail!=null)
            buffer.append(ConstDeclTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclNode!=null)
            buffer.append(ConstDeclNode.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ContinueConstDeclTail]");
        return buffer.toString();
    }
}
