// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class ContinueConditionTail extends ConditionTail {

    private ConditionTail ConditionTail;
    private CondTerm CondTerm;

    public ContinueConditionTail (ConditionTail ConditionTail, CondTerm CondTerm) {
        this.ConditionTail=ConditionTail;
        if(ConditionTail!=null) ConditionTail.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public ConditionTail getConditionTail() {
        return ConditionTail;
    }

    public void setConditionTail(ConditionTail ConditionTail) {
        this.ConditionTail=ConditionTail;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionTail!=null) ConditionTail.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionTail!=null) ConditionTail.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionTail!=null) ConditionTail.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ContinueConditionTail(\n");

        if(ConditionTail!=null)
            buffer.append(ConditionTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ContinueConditionTail]");
        return buffer.toString();
    }
}
