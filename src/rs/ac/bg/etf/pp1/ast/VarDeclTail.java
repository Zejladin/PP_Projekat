// generated with ast extension for cup
// version 0.8
// 25/0/2020 22:59:26


package rs.ac.bg.etf.pp1.ast;

public class VarDeclTail implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private VarDeclTail VarDeclTail;
    private VarDeclNode VarDeclNode;

    public VarDeclTail (VarDeclTail VarDeclTail, VarDeclNode VarDeclNode) {
        this.VarDeclTail=VarDeclTail;
        if(VarDeclTail!=null) VarDeclTail.setParent(this);
        this.VarDeclNode=VarDeclNode;
        if(VarDeclNode!=null) VarDeclNode.setParent(this);
    }

    public VarDeclTail getVarDeclTail() {
        return VarDeclTail;
    }

    public void setVarDeclTail(VarDeclTail VarDeclTail) {
        this.VarDeclTail=VarDeclTail;
    }

    public VarDeclNode getVarDeclNode() {
        return VarDeclNode;
    }

    public void setVarDeclNode(VarDeclNode VarDeclNode) {
        this.VarDeclNode=VarDeclNode;
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
        if(VarDeclTail!=null) VarDeclTail.accept(visitor);
        if(VarDeclNode!=null) VarDeclNode.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclTail!=null) VarDeclTail.traverseTopDown(visitor);
        if(VarDeclNode!=null) VarDeclNode.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclTail!=null) VarDeclTail.traverseBottomUp(visitor);
        if(VarDeclNode!=null) VarDeclNode.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclTail(\n");

        if(VarDeclTail!=null)
            buffer.append(VarDeclTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclNode!=null)
            buffer.append(VarDeclNode.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclTail]");
        return buffer.toString();
    }
}
