// generated with ast extension for cup
// version 0.8
// 25/0/2020 23:25:49


package rs.ac.bg.etf.pp1.ast;

public class NoFormPars extends FormParsOption {

    public NoFormPars () {
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
        buffer.append("NoFormPars(\n");

        buffer.append(tab);
        buffer.append(") [NoFormPars]");
        return buffer.toString();
    }
}
