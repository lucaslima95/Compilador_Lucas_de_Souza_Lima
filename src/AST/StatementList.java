
package AST;

import AST.ASTNode;
import AST.Statement;
import java.util.Vector;

public class StatementList
extends ASTNode {
    private Vector list = new Vector();

    public StatementList(int ln) {
        super(ln);
    }

    public void addElement(Statement n) {
        this.list.addElement(n);
    }

    public Statement elementAt(int i) {
        return (Statement)this.list.elementAt(i);
    }

    public int size() {
        return this.list.size();
    }
}

