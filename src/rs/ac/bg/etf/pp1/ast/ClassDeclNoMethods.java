// generated with ast extension for cup
// version 0.8
// 26/0/2020 17:40:36


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclNoMethods extends ClassDecl {

    private String className;
    private ExtendsOption ExtendsOption;
    private MethodVarListOption MethodVarListOption;

    public ClassDeclNoMethods (String className, ExtendsOption ExtendsOption, MethodVarListOption MethodVarListOption) {
        this.className=className;
        this.ExtendsOption=ExtendsOption;
        if(ExtendsOption!=null) ExtendsOption.setParent(this);
        this.MethodVarListOption=MethodVarListOption;
        if(MethodVarListOption!=null) MethodVarListOption.setParent(this);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public ExtendsOption getExtendsOption() {
        return ExtendsOption;
    }

    public void setExtendsOption(ExtendsOption ExtendsOption) {
        this.ExtendsOption=ExtendsOption;
    }

    public MethodVarListOption getMethodVarListOption() {
        return MethodVarListOption;
    }

    public void setMethodVarListOption(MethodVarListOption MethodVarListOption) {
        this.MethodVarListOption=MethodVarListOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendsOption!=null) ExtendsOption.accept(visitor);
        if(MethodVarListOption!=null) MethodVarListOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsOption!=null) ExtendsOption.traverseTopDown(visitor);
        if(MethodVarListOption!=null) MethodVarListOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsOption!=null) ExtendsOption.traverseBottomUp(visitor);
        if(MethodVarListOption!=null) MethodVarListOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclNoMethods(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        if(ExtendsOption!=null)
            buffer.append(ExtendsOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodVarListOption!=null)
            buffer.append(MethodVarListOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclNoMethods]");
        return buffer.toString();
    }
}
