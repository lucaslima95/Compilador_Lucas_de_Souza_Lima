
package AST;

import AST.Exp;
import AST.Statement;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class Return
extends Statement {
    public Exp e;

    public Return(Exp re, int ln) {
        super(ln);
        this.e = re;
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

