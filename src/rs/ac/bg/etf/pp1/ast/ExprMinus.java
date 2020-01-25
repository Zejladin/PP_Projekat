// generated with ast extension for cup
// version 0.8
// 25/0/2020 23:25:49


package rs.ac.bg.etf.pp1.ast;

public class ExprMinus extends Expr {

    private Term Term;
    private ExprTail ExprTail;

    public ExprMinus (Term Term, ExprTail ExprTail) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.ExprTail=ExprTail;
        if(ExprTail!=null) ExprTail.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public ExprTail getExprTail() {
        return ExprTail;
    }

    public void setExprTail(ExprTail ExprTail) {
        this.ExprTail=ExprTail;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(ExprTail!=null) ExprTail.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(ExprTail!=null) ExprTail.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(ExprTail!=null) ExprTail.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprMinus(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprTail!=null)
            buffer.append(ExprTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprMinus]");
        return buffer.toString();
    }
}
