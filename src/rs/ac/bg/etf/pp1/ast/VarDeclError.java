// generated with ast extension for cup
// version 0.8
// 2/1/2020 0:4:59


package rs.ac.bg.etf.pp1.ast;

public class VarDeclError extends VarDeclList {

    public VarDeclError () {
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
        buffer.append("VarDeclError(\n");

        buffer.append(tab);
        buffer.append(") [VarDeclError]");
        return buffer.toString();
    }
}
