// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class YesAbstractClassMethodsOption extends AbstractClassMethodsOption {

    private AbstractClassMethods AbstractClassMethods;

    public YesAbstractClassMethodsOption (AbstractClassMethods AbstractClassMethods) {
        this.AbstractClassMethods=AbstractClassMethods;
        if(AbstractClassMethods!=null) AbstractClassMethods.setParent(this);
    }

    public AbstractClassMethods getAbstractClassMethods() {
        return AbstractClassMethods;
    }

    public void setAbstractClassMethods(AbstractClassMethods AbstractClassMethods) {
        this.AbstractClassMethods=AbstractClassMethods;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractClassMethods!=null) AbstractClassMethods.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractClassMethods!=null) AbstractClassMethods.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractClassMethods!=null) AbstractClassMethods.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesAbstractClassMethodsOption(\n");

        if(AbstractClassMethods!=null)
            buffer.append(AbstractClassMethods.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesAbstractClassMethodsOption]");
        return buffer.toString();
    }
}
