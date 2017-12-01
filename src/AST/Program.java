
package AST;

import AST.ASTNode;
import AST.ClassDeclList;
import AST.MainClass;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class Program
extends ASTNode {
    public MainClass m;
    public ClassDeclList cl;

    public Program(MainClass am, ClassDeclList acl, int ln) {
        super(ln);
        this.m = am;
        this.cl = acl;
    }

    public void accept(Visitor v, Map mapa, int level, int nivel) {
        v.visit(this, mapa, level, nivel);
    }

    public void accept2(SecVisitor v, Map mapa, int nivel, Classes cl, Methods mt) {
        v.visit(this, mapa, nivel, cl, mt);
    }
}

