// generated with ast extension for cup
// version 0.8
// 1/1/2020 21:41:16


package rs.ac.bg.etf.pp1.ast;

public class ProgramHeaderAbstractClassDecl extends ProgramHeaderDeclList {

    private ProgramHeaderDeclList ProgramHeaderDeclList;
    private AbstractClassDecl AbstractClassDecl;

    public ProgramHeaderAbstractClassDecl (ProgramHeaderDeclList ProgramHeaderDeclList, AbstractClassDecl AbstractClassDecl) {
        this.ProgramHeaderDeclList=ProgramHeaderDeclList;
        if(ProgramHeaderDeclList!=null) ProgramHeaderDeclList.setParent(this);
        this.AbstractClassDecl=AbstractClassDecl;
        if(AbstractClassDecl!=null) AbstractClassDecl.setParent(this);
    }

    public ProgramHeaderDeclList getProgramHeaderDeclList() {
        return ProgramHeaderDeclList;
    }

    public void setProgramHeaderDeclList(ProgramHeaderDeclList ProgramHeaderDeclList) {
        this.ProgramHeaderDeclList=ProgramHeaderDeclList;
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
        if(ProgramHeaderDeclList!=null) ProgramHeaderDeclList.accept(visitor);
        if(AbstractClassDecl!=null) AbstractClassDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramHeaderDeclList!=null) ProgramHeaderDeclList.traverseTopDown(visitor);
        if(AbstractClassDecl!=null) AbstractClassDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramHeaderDeclList!=null) ProgramHeaderDeclList.traverseBottomUp(visitor);
        if(AbstractClassDecl!=null) AbstractClassDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramHeaderAbstractClassDecl(\n");

        if(ProgramHeaderDeclList!=null)
            buffer.append(ProgramHeaderDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AbstractClassDecl!=null)
            buffer.append(AbstractClassDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramHeaderAbstractClassDecl]");
        return buffer.toString();
    }
}
