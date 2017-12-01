
package AST;

import AST.Exp;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class This
extends Exp {
    public This(int ln) {
        super(ln);
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

