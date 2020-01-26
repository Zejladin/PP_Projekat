// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class ContinueCondTermTail extends CondTermTail {

    private CondTermTail CondTermTail;
    private CondFact CondFact;

    public ContinueCondTermTail (CondTermTail CondTermTail, CondFact CondFact) {
        this.CondTermTail=CondTermTail;
        if(CondTermTail!=null) CondTermTail.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
    }

    public CondTermTail getCondTermTail() {
        return CondTermTail;
    }

    public void setCondTermTail(CondTermTail CondTermTail) {
        this.CondTermTail=CondTermTail;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTermTail!=null) CondTermTail.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermTail!=null) CondTermTail.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermTail!=null) CondTermTail.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ContinueCondTermTail(\n");

        if(CondTermTail!=null)
            buffer.append(CondTermTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ContinueCondTermTail]");
        return buffer.toString();
    }
}
