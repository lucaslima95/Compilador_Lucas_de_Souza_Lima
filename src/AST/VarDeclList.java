
package AST;

import AST.ASTNode;
import AST.VarDecl;
import java.util.Vector;

public class VarDeclList
extends ASTNode {
    private Vector list = new Vector();

    public VarDeclList(int ln) {
        super(ln);
    }

    public void addElement(VarDecl n) {
        this.list.addElement(n);
    }

    public VarDecl elementAt(int i) {
        return (VarDecl)this.list.elementAt(i);
    }

    public int size() {
        return this.list.size();
    }
}

