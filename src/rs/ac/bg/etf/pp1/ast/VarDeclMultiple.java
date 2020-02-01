// generated with ast extension for cup
// version 0.8
// 1/1/2020 21:41:16


package rs.ac.bg.etf.pp1.ast;

public class VarDeclMultiple extends VarDeclMore {

    private VarDeclMore VarDeclMore;
    private VarDeclCore VarDeclCore;

    public VarDeclMultiple (VarDeclMore VarDeclMore, VarDeclCore VarDeclCore) {
        this.VarDeclMore=VarDeclMore;
        if(VarDeclMore!=null) VarDeclMore.setParent(this);
        this.VarDeclCore=VarDeclCore;
        if(VarDeclCore!=null) VarDeclCore.setParent(this);
    }

    public VarDeclMore getVarDeclMore() {
        return VarDeclMore;
    }

    public void setVarDeclMore(VarDeclMore VarDeclMore) {
        this.VarDeclMore=VarDeclMore;
    }

    public VarDeclCore getVarDeclCore() {
        return VarDeclCore;
    }

    public void setVarDeclCore(VarDeclCore VarDeclCore) {
        this.VarDeclCore=VarDeclCore;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclMore!=null) VarDeclMore.accept(visitor);
        if(VarDeclCore!=null) VarDeclCore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclMore!=null) VarDeclMore.traverseTopDown(visitor);
        if(VarDeclCore!=null) VarDeclCore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclMore!=null) VarDeclMore.traverseBottomUp(visitor);
        if(VarDeclCore!=null) VarDeclCore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclMultiple(\n");

        if(VarDeclMore!=null)
            buffer.append(VarDeclMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclCore!=null)
            buffer.append(VarDeclCore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclMultiple]");
        return buffer.toString();
    }
}
