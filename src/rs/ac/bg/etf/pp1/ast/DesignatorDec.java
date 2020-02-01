// generated with ast extension for cup
// version 0.8
// 30/0/2020 0:7:23


package rs.ac.bg.etf.pp1.ast;

public class DesignatorDec extends DesignatorStatement {

    private DesignatorBase DesignatorBase;

    public DesignatorDec (DesignatorBase DesignatorBase) {
        this.DesignatorBase=DesignatorBase;
        if(DesignatorBase!=null) DesignatorBase.setParent(this);
    }

    public DesignatorBase getDesignatorBase() {
        return DesignatorBase;
    }

    public void setDesignatorBase(DesignatorBase DesignatorBase) {
        this.DesignatorBase=DesignatorBase;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorBase!=null) DesignatorBase.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorBase!=null) DesignatorBase.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorBase!=null) DesignatorBase.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorDec(\n");

        if(DesignatorBase!=null)
            buffer.append(DesignatorBase.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorDec]");
        return buffer.toString();
    }
}
