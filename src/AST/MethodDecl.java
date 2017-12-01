
package AST;

import AST.ASTNode;
import AST.Exp;
import AST.FormalList;
import AST.Identifier;
import AST.StatementList;
import AST.Type;
import AST.VarDeclList;
import AST.Visitor.SecVisitor;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;

import java.util.Map;

public class MethodDecl
extends ASTNode {
    public Type t;
    public Identifier i;
    public FormalList fl;
    public VarDeclList vl;
    public StatementList sl;
    public Exp e;

    public MethodDecl(Type at, Identifier ai, FormalList afl, VarDeclList avl, StatementList asl, Exp ae, int ln) {
        super(ln);
        this.t = at;
        this.i = ai;
        this.fl = afl;
        this.vl = avl;
        this.sl = asl;
        this.e = ae;
    }

    public void accept(Visitor v, Map mapa, int level, int nivel) {
        v.visit(this, mapa, level, nivel);
    }

    public void accept2(SecVisitor v, Map mapa, int nivel, Classes cl, Methods mt) {
        v.visit(this, mapa, nivel, cl, mt);
    }
}

