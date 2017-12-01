
package AST;

import AST.Type;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class IntArrayType
extends Type {
    public IntArrayType(int ln) {
        super(ln);
    }

    @Override
    public void accept(Visitor v, Map mapa, int level, int nivel) {
        v.visit(this, mapa, level, nivel);
    }

    @Override
    public void accept2(SecVisitor v, Map mapa, int nivel, Classes cl, Methods mt) {
        v.visit(this, mapa, nivel, cl, mt);
    }

    public String toString() {
        return "int []";
    }

    public String getType() {
        return "int []";
    }
}

