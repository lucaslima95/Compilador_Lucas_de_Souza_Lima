
package AST;

import AST.Type;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class IntegerType
extends Type {
    public IntegerType(int ln) {
        super(ln);
    }

    public String toString() {
        return "int";
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

