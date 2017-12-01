
package AST;

import AST.Exp;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class Times
extends Exp {
    public Exp e1;
    public Exp e2;

    public Times(Exp ae1, Exp ae2, int ln) {
        super(ln);
        this.e1 = ae1;
        this.e2 = ae2;
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

