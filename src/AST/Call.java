
package AST;

import AST.Exp;
import AST.ExpList;
import AST.Identifier;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class Call
extends Exp {
    public Exp e;
    public Identifier i;
    public ExpList el;

    public Call(Exp ae, Identifier ai, ExpList ael, int ln) {
        super(ln);
        this.e = ae;
        this.i = ai;
        this.el = ael;
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

