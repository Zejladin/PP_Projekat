// generated with ast extension for cup
// version 0.8
// 30/0/2020 0:7:23


package rs.ac.bg.etf.pp1.ast;

public class NoActualParams extends ActualParamsChoice {

    public NoActualParams () {
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
        buffer.append("NoActualParams(\n");

        buffer.append(tab);
        buffer.append(") [NoActualParams]");
        return buffer.toString();
    }
}
