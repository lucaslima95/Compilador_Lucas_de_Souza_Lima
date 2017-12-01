
package AST;

import AST.Type;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class BooleanType
extends Type {
    public BooleanType(int ln) {
        super(ln);
    }

    @Override
    public void accept(Visitor v, Map mapa, int level, int nivel) {
        v.visit(this, mapa, level, nivel);
    }

    public String getType() {
        return "boolean";
    }

    public String toString() {
        return "boolean";
    }

    @Override
    public void accept2(SecVisitor v, Map mapa, int nivel, Classes cl, Methods mt) {
        v.visit(this, mapa, nivel, cl, mt);
    }
}

