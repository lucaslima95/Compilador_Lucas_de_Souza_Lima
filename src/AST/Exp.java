
package AST;

import AST.ASTNode;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public abstract class Exp
extends ASTNode {
    public Exp(int ln) {
        super(ln);
    }

    public abstract void accept(Visitor var1, Map var2, int var3, int var4);

    public abstract String accept2(SecVisitor var1, Map var2, int var3, Classes var4, Methods var5);
}

