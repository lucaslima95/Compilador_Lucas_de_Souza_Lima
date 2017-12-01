
package AST;

import AST.ASTNode;
import AST.ClassDecl;
import java.util.Vector;

public class ClassDeclList
extends ASTNode {
    private Vector list = new Vector();

    public ClassDeclList(int ln) {
        super(ln);
    }

    public void addElement(ClassDecl n) {
        this.list.addElement(n);
    }

    public ClassDecl elementAt(int i) {
        return (ClassDecl)this.list.elementAt(i);
    }

    public int size() {
        return this.list.size();
    }
}

