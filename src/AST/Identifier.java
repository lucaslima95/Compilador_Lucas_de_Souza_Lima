/*
 * Decompiled with CFR 0_115.
 */
package AST;

import AST.ASTNode;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class Identifier
extends ASTNode {
    public String s;

    public Identifier(String as, int ln) {
        super(ln);
        this.s = as;
    }

    public void accept(Visitor v, Map mapa, int level, int nivel) {
        v.visit(this, mapa, level, nivel);
    }

    public void accept2(SecVisitor v, Map mapa, int nivel, Classes cl, Methods mt) {
        v.visit(this, mapa, nivel, cl, mt);
    }

    public String toString() {
        return this.s;
    }

    public String getType() {
        return "null";
    }
}

