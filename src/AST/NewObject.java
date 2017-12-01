
package AST;

import AST.Exp;
import AST.Identifier;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class NewObject
extends Exp {
    public Identifier i;

    public NewObject(Identifier ai, int ln) {
        super(ln);
        this.i = ai;
    }

    @Override
    public void accept(Visitor v, Map mapa, int level, int nivel) {
        v.visit(this, mapa, level, nivel);
    }

    @Override
    public String accept2(SecVisitor v, Map mapa, int nivel, Classes cl, Methods mt) {
        return v.visit(this, mapa, nivel, cl, mt);
    }
}

