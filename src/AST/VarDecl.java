
package AST;

import AST.ASTNode;
import AST.Identifier;
import AST.Type;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class VarDecl
extends ASTNode {
    public Type t;
    public Identifier i;

    public VarDecl(Type at, Identifier ai, int ln) {
        super(ln);
        this.t = at;
        this.i = ai;
    }

    public void accept(Visitor v, Map mapa, int level, int nivel) {
        v.visit(this, mapa, level, nivel);
    }

    public void accept2(SecVisitor v, Map mapa, int nivel, Classes cl, Methods mt) {
        v.visit(this, mapa, nivel, cl, mt);
    }
}

