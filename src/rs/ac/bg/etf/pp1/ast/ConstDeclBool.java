// generated with ast extension for cup
// version 0.8
// 1/1/2020 21:41:16


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclBool extends ConstDeclCore {

    private String constIdentifier;
    private Boolean constVal;

    public ConstDeclBool (String constIdentifier, Boolean constVal) {
        this.constIdentifier=constIdentifier;
        this.constVal=constVal;
       // if(constVal!=null) constVal.setParent(this);
    }

    public String getConstIdentifier() {
        return constIdentifier;
    }

    public void setConstIdentifier(String constIdentifier) {
        this.constIdentifier=constIdentifier;
    }

    public Boolean getConstVal() {
        return constVal;
    }

    public void setConstVal(Boolean constVal) {
        this.constVal=constVal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
       // if(constVal!=null) constVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
      //  if(constVal!=null) constVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
      //  if(constVal!=null) constVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclBool(\n");

        buffer.append(" "+tab+constIdentifier);
        buffer.append("\n");

        /*if(constVal!=null)
          //  buffer.append(constVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");*/

        buffer.append(tab);
        buffer.append(") [ConstDeclBool]");
        return buffer.toString();
    }
}
