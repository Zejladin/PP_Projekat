// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassMethodsAbstractMethod extends AbstractClassMethods {

    private AbstractClassMethods AbstractClassMethods;
    private AbstractMethodDecl AbstractMethodDecl;

    public AbstractClassMethodsAbstractMethod (AbstractClassMethods AbstractClassMethods, AbstractMethodDecl AbstractMethodDecl) {
        this.AbstractClassMethods=AbstractClassMethods;
        if(AbstractClassMethods!=null) AbstractClassMethods.setParent(this);
        this.AbstractMethodDecl=AbstractMethodDecl;
        if(AbstractMethodDecl!=null) AbstractMethodDecl.setParent(this);
    }

    public AbstractClassMethods getAbstractClassMethods() {
        return AbstractClassMethods;
    }

    public void setAbstractClassMethods(AbstractClassMethods AbstractClassMethods) {
        this.AbstractClassMethods=AbstractClassMethods;
    }

    public AbstractMethodDecl getAbstractMethodDecl() {
        return AbstractMethodDecl;
    }

    public void setAbstractMethodDecl(AbstractMethodDecl AbstractMethodDecl) {
        this.AbstractMethodDecl=AbstractMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractClassMethods!=null) AbstractClassMethods.accept(visitor);
        if(AbstractMethodDecl!=null) AbstractMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractClassMethods!=null) AbstractClassMethods.traverseTopDown(visitor);
        if(AbstractMethodDecl!=null) AbstractMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractClassMethods!=null) AbstractClassMethods.traverseBottomUp(visitor);
        if(AbstractMethodDecl!=null) AbstractMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassMethodsAbstractMethod(\n");

        if(AbstractClassMethods!=null)
            buffer.append(AbstractClassMethods.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AbstractMethodDecl!=null)
            buffer.append(AbstractMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassMethodsAbstractMethod]");
        return buffer.toString();
    }
}
