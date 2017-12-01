
package AST;

import AST.ASTNode;
import AST.Exp;
import java.util.Vector;

public class ExpList
extends ASTNode {
    private Vector list = new Vector();

    public ExpList(int ln) {
        super(ln);
    }

    public void addElement(Exp n) {
        this.list.addElement(n);
    }

    public Exp elementAt(int i) {
        return (Exp)this.list.elementAt(i);
    }

    public int size() {
        return this.list.size();
    }
}

