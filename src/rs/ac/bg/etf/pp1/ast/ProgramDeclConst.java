// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclConst extends ProgramDeclList {

    private ProgramDeclList ProgramDeclList;
    private ConstDeclList ConstDeclList;

    public ProgramDeclConst (ProgramDeclList ProgramDeclList, ConstDeclList ConstDeclList) {
        this.ProgramDeclList=ProgramDeclList;
        if(ProgramDeclList!=null) ProgramDeclList.setParent(this);
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
    }

    public ProgramDeclList getProgramDeclList() {
        return ProgramDeclList;
    }

    public void setProgramDeclList(ProgramDeclList ProgramDeclList) {
        this.ProgramDeclList=ProgramDeclList;
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramDeclList!=null) ProgramDeclList.accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramDeclList!=null) ProgramDeclList.traverseTopDown(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramDeclList!=null) ProgramDeclList.traverseBottomUp(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclConst(\n");

        if(ProgramDeclList!=null)
            buffer.append(ProgramDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclConst]");
        return buffer.toString();
    }
}
