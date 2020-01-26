// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class VarDeclListt extends VarDeclList {

    private Type Type;
    private VarDeclNode VarDeclNode;
    private VarDeclTail VarDeclTail;

    public VarDeclListt (Type Type, VarDeclNode VarDeclNode, VarDeclTail VarDeclTail) {
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
        buffer.append("VarDeclListt(\n");

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
        buffer.append(") [VarDeclListt]");
        return buffer.toString();
    }
}
