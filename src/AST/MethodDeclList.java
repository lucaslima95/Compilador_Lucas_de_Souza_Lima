
package AST;

import AST.ASTNode;
import AST.MethodDecl;
import java.util.Vector;

public class MethodDeclList
extends ASTNode {
    private Vector list = new Vector();

    public MethodDeclList(int ln) {
        super(ln);
    }

    public void addElement(MethodDecl n) {
        this.list.addElement(n);
    }

    public MethodDecl elementAt(int i) {
        return (MethodDecl)this.list.elementAt(i);
    }

    public int size() {
        return this.list.size();
    }
}

