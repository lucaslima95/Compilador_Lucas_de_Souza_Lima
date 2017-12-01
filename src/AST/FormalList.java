
package AST;

import AST.ASTNode;
import AST.Formal;
import java.util.Vector;

public class FormalList
extends ASTNode {
    private Vector list = new Vector();

    public FormalList(int ln) {
        super(ln);
    }

    public void addElement(Formal n) {
        this.list.addElement(n);
    }

    public Formal elementAt(int i) {
        return (Formal)this.list.elementAt(i);
    }

    public int size() {
        return this.list.size();
    }
}

