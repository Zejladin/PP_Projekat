// generated with ast extension for cup
// version 0.8
// 25/0/2020 23:25:49


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassMethodsMethod extends AbstractClassMethods {

    private AbstractClassMethods AbstractClassMethods;
    private MethodDecl MethodDecl;

    public AbstractClassMethodsMethod (AbstractClassMethods AbstractClassMethods, MethodDecl MethodDecl) {
        this.AbstractClassMethods=AbstractClassMethods;
        if(AbstractClassMethods!=null) AbstractClassMethods.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public AbstractClassMethods getAbstractClassMethods() {
        return AbstractClassMethods;
    }

    public void setAbstractClassMethods(AbstractClassMethods AbstractClassMethods) {
        this.AbstractClassMethods=AbstractClassMethods;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractClassMethods!=null) AbstractClassMethods.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractClassMethods!=null) AbstractClassMethods.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractClassMethods!=null) AbstractClassMethods.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassMethodsMethod(\n");

        if(AbstractClassMethods!=null)
            buffer.append(AbstractClassMethods.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassMethodsMethod]");
        return buffer.toString();
    }
}
