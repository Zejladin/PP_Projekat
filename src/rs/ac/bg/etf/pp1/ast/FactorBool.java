// generated with ast extension for cup
// version 0.8
// 1/1/2020 21:41:16


package rs.ac.bg.etf.pp1.ast;

public class FactorBool extends Factor {

    private Boolean boolFactor;

    public FactorBool (Boolean boolFactor) {
        this.boolFactor=boolFactor;
        //if(boolFactor!=null) boolFactor.setParent(this);
    }

    public Boolean getBoolFactor() {
        return boolFactor;
    }

    public void setBoolFactor(Boolean boolFactor) {
        this.boolFactor=boolFactor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        //if(boolFactor!=null) boolFactor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
       // if(boolFactor!=null) boolFactor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
       // if(boolFactor!=null) boolFactor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorBool(\n");

       /* if(boolFactor!=null)
          //  buffer.append(boolFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n"); */

        buffer.append(tab);
        buffer.append(") [FactorBool]");
        return buffer.toString();
    }
}
