// generated with ast extension for cup
// version 0.8
// 30/0/2020 0:7:23


package rs.ac.bg.etf.pp1.ast;

public class DesignatorAssign extends DesignatorStatement {

    private DesignatorBase DesignatorBase;
    private Assignop Assignop;
    private Expr Expr;

    public DesignatorAssign (DesignatorBase DesignatorBase, Assignop Assignop, Expr Expr) {
        this.DesignatorBase=DesignatorBase;
        if(DesignatorBase!=null) DesignatorBase.setParent(this);
        this.Assignop=Assignop;
        if(Assignop!=null) Assignop.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesignatorBase getDesignatorBase() {
        return DesignatorBase;
    }

    public void setDesignatorBase(DesignatorBase DesignatorBase) {
        this.DesignatorBase=DesignatorBase;
    }

    public Assignop getAssignop() {
        return Assignop;
    }

    public void setAssignop(Assignop Assignop) {
        this.Assignop=Assignop;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorBase!=null) DesignatorBase.accept(visitor);
        if(Assignop!=null) Assignop.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorBase!=null) DesignatorBase.traverseTopDown(visitor);
        if(Assignop!=null) Assignop.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorBase!=null) DesignatorBase.traverseBottomUp(visitor);
        if(Assignop!=null) Assignop.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorAssign(\n");

        if(DesignatorBase!=null)
            buffer.append(DesignatorBase.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Assignop!=null)
            buffer.append(Assignop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorAssign]");
        return buffer.toString();
    }
}
