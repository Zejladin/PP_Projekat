// generated with ast extension for cup
// version 0.8
// 25/0/2020 23:25:49


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private ConstDeclNode ConstDeclNode;
    private ConstDeclTail ConstDeclTail;

    public ConstDeclList (Type Type, ConstDeclNode ConstDeclNode, ConstDeclTail ConstDeclTail) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstDeclNode=ConstDeclNode;
        if(ConstDeclNode!=null) ConstDeclNode.setParent(this);
        this.ConstDeclTail=ConstDeclTail;
        if(ConstDeclTail!=null) ConstDeclTail.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstDeclNode getConstDeclNode() {
        return ConstDeclNode;
    }

    public void setConstDeclNode(ConstDeclNode ConstDeclNode) {
        this.ConstDeclNode=ConstDeclNode;
    }

    public ConstDeclTail getConstDeclTail() {
        return ConstDeclTail;
    }

    public void setConstDeclTail(ConstDeclTail ConstDeclTail) {
        this.ConstDeclTail=ConstDeclTail;
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
        if(Type!=null) Type.accept(visitor);
        if(ConstDeclNode!=null) ConstDeclNode.accept(visitor);
        if(ConstDeclTail!=null) ConstDeclTail.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstDeclNode!=null) ConstDeclNode.traverseTopDown(visitor);
        if(ConstDeclTail!=null) ConstDeclTail.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstDeclNode!=null) ConstDeclNode.traverseBottomUp(visitor);
        if(ConstDeclTail!=null) ConstDeclTail.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclList(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclNode!=null)
            buffer.append(ConstDeclNode.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclTail!=null)
            buffer.append(ConstDeclTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclList]");
        return buffer.toString();
    }
}
