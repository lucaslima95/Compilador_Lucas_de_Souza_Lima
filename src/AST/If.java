
package AST;

import AST.Exp;
import AST.Statement;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class If
extends Statement {
    public Exp e;
    public Statement s1;
    public Statement s2;

    public If(Exp ae, Statement as1, Statement as2, int ln) {
        super(ln);
        this.e = ae;
        this.s1 = as1;
        this.s2 = as2;
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

