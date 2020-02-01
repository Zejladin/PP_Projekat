// generated with ast extension for cup
// version 0.8
// 1/1/2020 17:39:39


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclBool extends ConstDeclCore {

    private String constIdentifier;

    public ConstDeclBool (String constIdentifier) {
        this.constIdentifier=constIdentifier;
    }

    public String getConstIdentifier() {
        return constIdentifier;
    }

    public void setConstIdentifier(String constIdentifier) {
        this.constIdentifier=constIdentifier;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclBool(\n");

        buffer.append(" "+tab+constIdentifier);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclBool]");
        return buffer.toString();
    }
}
