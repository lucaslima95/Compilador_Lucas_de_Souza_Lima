
package AST;

import AST.Exp;
import AST.Identifier;
import AST.Statement;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class ArrayAssign
extends Statement {
    public Identifier i;
    public Exp e1;
    public Exp e2;

    public ArrayAssign(Identifier ai, Exp ae1, Exp ae2, int ln) {
        super(ln);
        this.i = ai;
        this.e1 = ae1;
        this.e2 = ae2;
    }

    @Override
    public void accept(Visitor v, Map mapa, int level, int nivel) {
        v.visit(this, mapa, level, nivel);
    }

    @Override
    public void accept2(SecVisitor v, Map mapa, int nivel, Classes cl, Methods mt) {
        v.visit(this, mapa, nivel, cl, mt);
    }
}

