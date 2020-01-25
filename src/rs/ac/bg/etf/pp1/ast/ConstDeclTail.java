// generated with ast extension for cup
// version 0.8
// 25/0/2020 23:25:49


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclTail implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ConstDeclTail ConstDeclTail;
    private ConstDeclNode ConstDeclNode;

    public ConstDeclTail (ConstDeclTail ConstDeclTail, ConstDeclNode ConstDeclNode) {
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
        buffer.append("ConstDeclTail(\n");

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
        buffer.append(") [ConstDeclTail]");
        return buffer.toString();
    }
}
