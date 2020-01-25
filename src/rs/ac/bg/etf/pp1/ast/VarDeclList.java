// generated with ast extension for cup
// version 0.8
// 25/0/2020 22:59:26


package rs.ac.bg.etf.pp1.ast;

public class VarDeclList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private VarDeclNode VarDeclNode;
    private VarDeclTail VarDeclTail;

    public VarDeclList (Type Type, VarDeclNode VarDeclNode, VarDeclTail VarDeclTail) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarDeclNode=VarDeclNode;
        if(VarDeclNode!=null) VarDeclNode.setParent(this);
        this.VarDeclTail=VarDeclTail;
        if(VarDeclTail!=null) VarDeclTail.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarDeclNode getVarDeclNode() {
        return VarDeclNode;
    }

    public void setVarDeclNode(VarDeclNode VarDeclNode) {
        this.VarDeclNode=VarDeclNode;
    }

    public VarDeclTail getVarDeclTail() {
        return VarDeclTail;
    }

    public void setVarDeclTail(VarDeclTail VarDeclTail) {
        this.VarDeclTail=VarDeclTail;
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
        if(VarDeclNode!=null) VarDeclNode.accept(visitor);
        if(VarDeclTail!=null) VarDeclTail.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDeclNode!=null) VarDeclNode.traverseTopDown(visitor);
        if(VarDeclTail!=null) VarDeclTail.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDeclNode!=null) VarDeclNode.traverseBottomUp(visitor);
        if(VarDeclTail!=null) VarDeclTail.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclList(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclNode!=null)
            buffer.append(VarDeclNode.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclTail!=null)
            buffer.append(VarDeclTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclList]");
        return buffer.toString();
    }
}
