// generated with ast extension for cup
// version 0.8
// 29/0/2020 18:20:51


package rs.ac.bg.etf.pp1.ast;

public class ProgramHeaderConstDecl extends ProgramHeaderDeclList {

    private ProgramHeaderDeclList ProgramHeaderDeclList;
    private ConstDeclList ConstDeclList;

    public ProgramHeaderConstDecl (ProgramHeaderDeclList ProgramHeaderDeclList, ConstDeclList ConstDeclList) {
        this.ProgramHeaderDeclList=ProgramHeaderDeclList;
        if(ProgramHeaderDeclList!=null) ProgramHeaderDeclList.setParent(this);
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
    }

    public ProgramHeaderDeclList getProgramHeaderDeclList() {
        return ProgramHeaderDeclList;
    }

    public void setProgramHeaderDeclList(ProgramHeaderDeclList ProgramHeaderDeclList) {
        this.ProgramHeaderDeclList=ProgramHeaderDeclList;
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
        if(ProgramHeaderDeclList!=null) ProgramHeaderDeclList.accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramHeaderDeclList!=null) ProgramHeaderDeclList.traverseTopDown(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramHeaderDeclList!=null) ProgramHeaderDeclList.traverseBottomUp(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramHeaderConstDecl(\n");

        if(ProgramHeaderDeclList!=null)
            buffer.append(ProgramHeaderDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramHeaderConstDecl]");
        return buffer.toString();
    }
}
