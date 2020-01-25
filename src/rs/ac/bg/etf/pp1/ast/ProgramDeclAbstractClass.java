// generated with ast extension for cup
// version 0.8
// 25/0/2020 23:25:49


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclAbstractClass extends ProgramDeclList {

    private ProgramDeclList ProgramDeclList;
    private AbstractClassDecl AbstractClassDecl;

    public ProgramDeclAbstractClass (ProgramDeclList ProgramDeclList, AbstractClassDecl AbstractClassDecl) {
        this.ProgramDeclList=ProgramDeclList;
        if(ProgramDeclList!=null) ProgramDeclList.setParent(this);
        this.AbstractClassDecl=AbstractClassDecl;
        if(AbstractClassDecl!=null) AbstractClassDecl.setParent(this);
    }

    public ProgramDeclList getProgramDeclList() {
        return ProgramDeclList;
    }

    public void setProgramDeclList(ProgramDeclList ProgramDeclList) {
        this.ProgramDeclList=ProgramDeclList;
    }

    public AbstractClassDecl getAbstractClassDecl() {
        return AbstractClassDecl;
    }

    public void setAbstractClassDecl(AbstractClassDecl AbstractClassDecl) {
        this.AbstractClassDecl=AbstractClassDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramDeclList!=null) ProgramDeclList.accept(visitor);
        if(AbstractClassDecl!=null) AbstractClassDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramDeclList!=null) ProgramDeclList.traverseTopDown(visitor);
        if(AbstractClassDecl!=null) AbstractClassDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramDeclList!=null) ProgramDeclList.traverseBottomUp(visitor);
        if(AbstractClassDecl!=null) AbstractClassDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclAbstractClass(\n");

        if(ProgramDeclList!=null)
            buffer.append(ProgramDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AbstractClassDecl!=null)
            buffer.append(AbstractClassDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclAbstractClass]");
        return buffer.toString();
    }
}
