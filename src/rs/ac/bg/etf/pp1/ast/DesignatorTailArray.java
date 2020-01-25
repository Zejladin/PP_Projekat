// generated with ast extension for cup
// version 0.8
// 25/0/2020 23:25:49


package rs.ac.bg.etf.pp1.ast;

public class DesignatorTailArray extends DesignatorTail {

    private DesignatorTail DesignatorTail;
    private Expr Expr;

    public DesignatorTailArray (DesignatorTail DesignatorTail, Expr Expr) {
        this.DesignatorTail=DesignatorTail;
        if(DesignatorTail!=null) DesignatorTail.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesignatorTail getDesignatorTail() {
        return DesignatorTail;
    }

    public void setDesignatorTail(DesignatorTail DesignatorTail) {
        this.DesignatorTail=DesignatorTail;
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
        if(DesignatorTail!=null) DesignatorTail.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorTail!=null) DesignatorTail.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorTail!=null) DesignatorTail.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorTailArray(\n");

        if(DesignatorTail!=null)
            buffer.append(DesignatorTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorTailArray]");
        return buffer.toString();
    }
}
