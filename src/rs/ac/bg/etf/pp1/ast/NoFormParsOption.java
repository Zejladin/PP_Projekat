// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class NoFormParsOption extends FormParsOption {

    private NoFormPars NoFormPars;

    public NoFormParsOption (NoFormPars NoFormPars) {
        this.NoFormPars=NoFormPars;
        if(NoFormPars!=null) NoFormPars.setParent(this);
    }

    public NoFormPars getNoFormPars() {
        return NoFormPars;
    }

    public void setNoFormPars(NoFormPars NoFormPars) {
        this.NoFormPars=NoFormPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NoFormPars!=null) NoFormPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NoFormPars!=null) NoFormPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NoFormPars!=null) NoFormPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoFormParsOption(\n");

        if(NoFormPars!=null)
            buffer.append(NoFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoFormParsOption]");
        return buffer.toString();
    }
}
