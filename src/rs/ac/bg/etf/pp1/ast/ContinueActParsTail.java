// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class ContinueActParsTail extends ActParsTail {

    private ActParsTail ActParsTail;
    private Expr Expr;

    public ContinueActParsTail (ActParsTail ActParsTail, Expr Expr) {
        this.ActParsTail=ActParsTail;
        if(ActParsTail!=null) ActParsTail.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ActParsTail getActParsTail() {
        return ActParsTail;
    }

    public void setActParsTail(ActParsTail ActParsTail) {
        this.ActParsTail=ActParsTail;
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
        if(ActParsTail!=null) ActParsTail.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsTail!=null) ActParsTail.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsTail!=null) ActParsTail.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ContinueActParsTail(\n");

        if(ActParsTail!=null)
            buffer.append(ActParsTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ContinueActParsTail]");
        return buffer.toString();
    }
}
