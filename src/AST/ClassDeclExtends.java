
package AST;

import AST.ClassDecl;
import AST.Identifier;
import AST.MethodDeclList;
import AST.VarDeclList;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class ClassDeclExtends
extends ClassDecl {
    public Identifier j;

    public ClassDeclExtends(Identifier ai, Identifier aj, VarDeclList avl, MethodDeclList aml, int ln) {
        super(ln);
        this.i = ai;
        this.j = aj;
        this.vl = avl;
        this.ml = aml;
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

