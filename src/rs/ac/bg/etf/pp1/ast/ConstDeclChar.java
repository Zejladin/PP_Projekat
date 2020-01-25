// generated with ast extension for cup
// version 0.8
// 25/0/2020 23:25:49


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclChar extends ConstDeclNode {

    private String constName;
    private Character constVal;

    public ConstDeclChar (String constName, Character constVal) {
        this.constName=constName;
        this.constVal=constVal;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public Character getConstVal() {
        return constVal;
    }

    public void setConstVal(Character constVal) {
        this.constVal=constVal;
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
        buffer.append("ConstDeclChar(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        buffer.append(" "+tab+constVal);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclChar]");
        return buffer.toString();
    }
}
