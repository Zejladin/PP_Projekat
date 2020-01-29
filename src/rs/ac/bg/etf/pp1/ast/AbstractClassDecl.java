// generated with ast extension for cup
// version 0.8
// 29/0/2020 18:20:51


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ClassDeclHeader ClassDeclHeader;
    private ClassExtendsChoice ClassExtendsChoice;
    private VarDeclChoice VarDeclChoice;
    private AbstractMethDeclChoice AbstractMethDeclChoice;

    public AbstractClassDecl (ClassDeclHeader ClassDeclHeader, ClassExtendsChoice ClassExtendsChoice, VarDeclChoice VarDeclChoice, AbstractMethDeclChoice AbstractMethDeclChoice) {
        this.ClassDeclHeader=ClassDeclHeader;
        if(ClassDeclHeader!=null) ClassDeclHeader.setParent(this);
        this.ClassExtendsChoice=ClassExtendsChoice;
        if(ClassExtendsChoice!=null) ClassExtendsChoice.setParent(this);
        this.VarDeclChoice=VarDeclChoice;
        if(VarDeclChoice!=null) VarDeclChoice.setParent(this);
        this.AbstractMethDeclChoice=AbstractMethDeclChoice;
        if(AbstractMethDeclChoice!=null) AbstractMethDeclChoice.setParent(this);
    }

    public ClassDeclHeader getClassDeclHeader() {
        return ClassDeclHeader;
    }

    public void setClassDeclHeader(ClassDeclHeader ClassDeclHeader) {
        this.ClassDeclHeader=ClassDeclHeader;
    }

    public ClassExtendsChoice getClassExtendsChoice() {
        return ClassExtendsChoice;
    }

    public void setClassExtendsChoice(ClassExtendsChoice ClassExtendsChoice) {
        this.ClassExtendsChoice=ClassExtendsChoice;
    }

    public VarDeclChoice getVarDeclChoice() {
        return VarDeclChoice;
    }

    public void setVarDeclChoice(VarDeclChoice VarDeclChoice) {
        this.VarDeclChoice=VarDeclChoice;
    }

    public AbstractMethDeclChoice getAbstractMethDeclChoice() {
        return AbstractMethDeclChoice;
    }

    public void setAbstractMethDeclChoice(AbstractMethDeclChoice AbstractMethDeclChoice) {
        this.AbstractMethDeclChoice=AbstractMethDeclChoice;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassDeclHeader!=null) ClassDeclHeader.accept(visitor);
        if(ClassExtendsChoice!=null) ClassExtendsChoice.accept(visitor);
        if(VarDeclChoice!=null) VarDeclChoice.accept(visitor);
        if(AbstractMethDeclChoice!=null) AbstractMethDeclChoice.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclHeader!=null) ClassDeclHeader.traverseTopDown(visitor);
        if(ClassExtendsChoice!=null) ClassExtendsChoice.traverseTopDown(visitor);
        if(VarDeclChoice!=null) VarDeclChoice.traverseTopDown(visitor);
        if(AbstractMethDeclChoice!=null) AbstractMethDeclChoice.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclHeader!=null) ClassDeclHeader.traverseBottomUp(visitor);
        if(ClassExtendsChoice!=null) ClassExtendsChoice.traverseBottomUp(visitor);
        if(VarDeclChoice!=null) VarDeclChoice.traverseBottomUp(visitor);
        if(AbstractMethDeclChoice!=null) AbstractMethDeclChoice.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDecl(\n");

        if(ClassDeclHeader!=null)
            buffer.append(ClassDeclHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassExtendsChoice!=null)
            buffer.append(ClassExtendsChoice.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclChoice!=null)
            buffer.append(VarDeclChoice.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AbstractMethDeclChoice!=null)
            buffer.append(AbstractMethDeclChoice.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDecl]");
        return buffer.toString();
    }
}
