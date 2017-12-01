
package AST;

import AST.ASTNode;
import AST.Identifier;
import AST.MethodDeclList;
import AST.VarDeclList;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public abstract class ClassDecl
extends ASTNode {
    public Identifier i;
    public VarDeclList vl;
    public MethodDeclList ml;

    public ClassDecl(int ln) {
        super(ln);
    }

    public abstract void accept(Visitor var1, Map var2, int var3, int var4);

    public abstract void accept2(SecVisitor var1, Map var2, int var3, Classes var4, Methods var5);
}

