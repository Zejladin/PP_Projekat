// generated with ast extension for cup
// version 0.8
// 2/1/2020 0:4:59


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignatorCall extends Factor {

    private DesignatorBase DesignatorBase;
    private ActualParamsChoice ActualParamsChoice;

    public FactorDesignatorCall (DesignatorBase DesignatorBase, ActualParamsChoice ActualParamsChoice) {
        this.DesignatorBase=DesignatorBase;
        if(DesignatorBase!=null) DesignatorBase.setParent(this);
        this.ActualParamsChoice=ActualParamsChoice;
        if(ActualParamsChoice!=null) ActualParamsChoice.setParent(this);
    }

    public DesignatorBase getDesignatorBase() {
        return DesignatorBase;
    }

    public void setDesignatorBase(DesignatorBase DesignatorBase) {
        this.DesignatorBase=DesignatorBase;
    }

    public ActualParamsChoice getActualParamsChoice() {
        return ActualParamsChoice;
    }

    public void setActualParamsChoice(ActualParamsChoice ActualParamsChoice) {
        this.ActualParamsChoice=ActualParamsChoice;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorBase!=null) DesignatorBase.accept(visitor);
        if(ActualParamsChoice!=null) ActualParamsChoice.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorBase!=null) DesignatorBase.traverseTopDown(visitor);
        if(ActualParamsChoice!=null) ActualParamsChoice.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorBase!=null) DesignatorBase.traverseBottomUp(visitor);
        if(ActualParamsChoice!=null) ActualParamsChoice.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignatorCall(\n");

        if(DesignatorBase!=null)
            buffer.append(DesignatorBase.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActualParamsChoice!=null)
            buffer.append(ActualParamsChoice.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignatorCall]");
        return buffer.toString();
    }
}
