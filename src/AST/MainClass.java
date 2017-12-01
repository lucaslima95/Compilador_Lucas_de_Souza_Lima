
package AST;

import AST.ASTNode;
import AST.Identifier;
import AST.Statement;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class MainClass
extends ASTNode {
    public Identifier i1;
    public Identifier i2;
    public Statement s;

    public MainClass(Identifier ai1, Identifier ai2, Statement as, int ln) {
        super(ln);
        this.i1 = ai1;
        this.i2 = ai2;
        this.s = as;
    }

    public void accept(Visitor v, Map mapa, int level, int nivel) {
        v.visit(this, mapa, level, nivel);
    }

    public void accept2(SecVisitor v, Map mapa, int nivel, Classes cl, Methods mt) {
        v.visit(this, mapa, nivel, cl, mt);
    }
}

