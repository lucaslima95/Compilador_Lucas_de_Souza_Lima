package AST.Visitor;

import AST.And;
import AST.ArrayAssign;
import AST.ArrayLength;
import AST.ArrayLookup;
import AST.Assign;
import AST.Block;
import AST.BooleanType;
import AST.Call;
import AST.ClassDecl;
import AST.ClassDeclExtends;
import AST.ClassDeclList;
import AST.ClassDeclSimple;
import AST.Exp;
import AST.ExpList;
import AST.False;
import AST.Formal;
import AST.FormalList;
import AST.Identifier;
import AST.IdentifierExp;
import AST.IdentifierType;
import AST.If;
import AST.IntArrayType;
import AST.IntegerLiteral;
import AST.IntegerType;
import AST.LessThan;
import AST.MainClass;
import AST.MethodDecl;
import AST.MethodDeclList;
import AST.Minus;
import AST.NewArray;
import AST.NewObject;
import AST.Not;
import AST.Plus;
import AST.Print;
import AST.Program;
import AST.Return;
import AST.Statement;
import AST.StatementList;
import AST.This;
import AST.Times;
import AST.True;
import AST.Type;
import AST.VarDecl;
import AST.VarDeclList;
import AST.Visitor.Visitor;
import Tables.Classes;
import Tables.Methods;
import Tables.Variables;
import AST.While;

import java.io.PrintStream;
import java.util.Map;

public class PrettyPrintVisitor
implements Visitor {
    @Override
    public void visit(Return n, Map mapa, int nivel, int level) {
        n.e.accept(this, mapa, level, nivel);
    }

    @Override
    public void visit(Program n, Map mapa, int nivel, int level) {
        n.m.accept(this, mapa, level, nivel + 1);
        int i = 0;
        while (i < n.cl.size()) {
            n.cl.elementAt(i).accept(this, mapa, level, nivel + 1);
            ++i;
        }
    }

    @Override
    public void visit(MainClass n, Map mapa, int nivel, int level) {
        Classes a = new Classes(true);
        a.linha = n.i1.line_number;
        if (mapa.containsKey(n.i1.toString())) {
            System.out.println("Classe definida duplamente: ( class " + n.i1.toString() + " ) em " + (n.line_number + 1));
            while (mapa.containsKey(a.id)) {
                a.id = String.valueOf(a.id) + "@";
            }
        }
        a.id = n.i1.toString();
        n.i1.accept(this, mapa, level, nivel + 1);
        Variables v = new Variables();
        v.type = "String []";
        v.id = n.i2.toString();
        v.linha = n.i2.line_number;
        n.i2.accept(this, mapa, level, nivel + 1);
        Methods m = new Methods();
        m.type = "void";
        m.id = "main";
        m.arg.put(v.id, v);
        m.linha = n.i2.line_number;
        n.s.accept(this, m.variavel, m.nivel + 1, nivel + 1);
        mapa.put(a.id, a);
    }

    @Override
    public void visit(ClassDeclSimple n, Map mapa, int nivel, int level) {
        Classes a = new Classes(false);
        a.linha = n.line_number;
        if (mapa.containsKey(n.i.toString())) {
            System.out.println("Classe definida duplamente: ( class " + n.i.toString() + " ) em " + (n.line_number + 1));
            while (mapa.containsKey(a.id)) {
                a.id = String.valueOf(a.id) + "@";
            }
        }
        a.id = n.i.toString();
        n.i.accept(this, mapa, level, nivel + 1);
        int i = 0;
        while (i < n.vl.size()) {
            n.vl.elementAt(i).accept(this, a.variavel, a.nivel + 1, nivel + 1);
            n.vl.size();
            ++i;
        }
        i = 0;
        while (i < n.ml.size()) {
            n.ml.elementAt(i).accept(this, a.metodo, a.nivel + 1, nivel + 1);
            ++i;
        }
        mapa.put(a.id, a);
    }

    @Override
    public void visit(ClassDeclExtends n, Map mapa, int nivel, int level) {
        Classes a = new Classes(false);
        a.linha = n.line_number;
        if (mapa.containsKey(n.i.toString())) {
            System.out.println("Classe definida duplamente: ( class " + n.i.toString() + " ) em " + (n.line_number + 1));
            while (mapa.containsKey(a.id)) {
                a.id = String.valueOf(a.id) + "@";
            }
        }
        a.id = n.i.toString();
        n.i.accept(this, mapa, level, nivel + 1);
        a.extendida = new String();
        a.extendida = n.j.s.toString();
        n.j.accept(this, mapa, level, nivel + 1);
        int i = 0;
        while (i < n.vl.size()) {
            n.vl.elementAt(i).accept(this, a.variavel, a.nivel + 1, nivel + 1);
            n.vl.size();
            ++i;
        }
        i = 0;
        while (i < n.ml.size()) {
            n.ml.elementAt(i).accept(this, a.metodo, a.nivel + 1, nivel + 1);
            ++i;
        }
        mapa.put(a.id, a);
    }

    @Override
    public void visit(VarDecl n, Map mapa, int nivel, int level) {
        Variables a = new Variables();
        a.type = n.t.toString();
        a.id = n.i.toString();
        a.linha = n.line_number;
        if (mapa.containsKey(a.id)) {
            System.out.println("Vari\u00e1vel duplamente definida: ( " + a.type + " " + a.id + " ) em " + (n.line_number + 1));
            while (mapa.containsKey(a.id)) {
                a.id = String.valueOf(a.id) + "@";
            }
        }
        mapa.put(a.id, a);
        n.t.accept(this, mapa, level, nivel + 1);
        n.i.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(MethodDecl n, Map mapa, int nivel, int level) {
        Methods a = new Methods();
        a.type = n.t.toString();
        a.id = n.i.toString();
        a.linha = n.line_number;
        if (mapa.containsKey(a.id)) {
            System.out.println("M\u00e9todo duplamente definido: ( " + a.type + " " + a.id + "() ) em " + (n.line_number + 1));
            while (mapa.containsKey(a.id)) {
                a.id = String.valueOf(a.id) + "@";
            }
        }
        n.t.accept(this, mapa, level, nivel + 1);
        n.i.accept(this, mapa, level, nivel + 1);
        int i = 0;
        while (i < n.fl.size()) {
            n.fl.elementAt(i).accept(this, a.arg, level, nivel);
            n.fl.size();
            ++i;
        }
        i = 0;
        while (i < n.vl.size()) {
            n.vl.elementAt(i).accept(this, a.variavel, a.nivel + 1, nivel);
            ++i;
        }
        i = 0;
        while (i < n.sl.size()) {
            n.sl.elementAt(i).accept(this, a.variavel, a.nivel + 1, nivel);
            n.sl.size();
            ++i;
        }
        n.e.accept(this, mapa, level, nivel + 1);
        mapa.put(a.id, a);
    }

    @Override
    public void visit(Formal n, Map mapa, int nivel, int level) {
        Variables a = new Variables();
        a.type = n.t.toString();
        a.id = n.i.toString();
        a.linha = n.line_number;
        if (mapa.containsKey(a.id)) {
            System.out.println("Argumento duplamente definido: ( " + a.type + a.id + " ) em " + (n.line_number + 1));
            while (mapa.containsKey(a.id)) {
                a.id = String.valueOf(a.id) + "@";
            }
        }
        mapa.put(a.id, a);
        n.t.accept(this, mapa, level, nivel + 1);
        n.i.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(IntArrayType n, Map mapa, int nivel, int level) {
    }

    @Override
    public void visit(BooleanType n, Map mapa, int nivel, int level) {
    }

    @Override
    public void visit(IntegerType n, Map mapa, int nivel, int level) {
    }

    @Override
    public void visit(IdentifierType n, Map mapa, int nivel, int level) {
    }

    @Override
    public void visit(Block n, Map mapa, int nivel, int level) {
        int i = 0;
        while (i < n.sl.size()) {
            n.sl.elementAt(i).accept(this, mapa, level, nivel);
            ++i;
        }
    }

    @Override
    public void visit(If n, Map mapa, int nivel, int level) {
        n.e.accept(this, mapa, level, nivel + 1);
        n.s1.accept(this, mapa, level, nivel + 1);
        n.s2.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(While n, Map mapa, int nivel, int level) {
        n.e.accept(this, mapa, level, nivel + 1);
        n.s.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(Print n, Map mapa, int nivel, int level) {
        n.e.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(Assign n, Map mapa, int nivel, int level) {
        n.i.accept(this, mapa, level, nivel + 1);
        n.e.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(ArrayAssign n, Map mapa, int nivel, int level) {
        n.i.accept(this, mapa, level, nivel + 2);
        n.e1.accept(this, mapa, level, nivel + 2);
        n.e2.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(And n, Map mapa, int nivel, int level) {
        n.e1.accept(this, mapa, level, nivel);
        n.e2.accept(this, mapa, level, nivel);
    }

    @Override
    public void visit(LessThan n, Map mapa, int nivel, int level) {
        n.e1.accept(this, mapa, level, nivel + 1);
        n.e2.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(Plus n, Map mapa, int nivel, int level) {
        n.e1.accept(this, mapa, level, nivel + 1);
        n.e2.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(Minus n, Map mapa, int nivel, int level) {
        n.e1.accept(this, mapa, level, nivel + 1);
        n.e2.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(Times n, Map mapa, int nivel, int level) {
        n.e1.accept(this, mapa, level, nivel + 1);
        n.e2.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(ArrayLookup n, Map mapa, int nivel, int level) {
        n.e1.accept(this, mapa, level, nivel + 1);
        n.e2.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(ArrayLength n, Map mapa, int nivel, int level) {
        n.e.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(Call n, Map mapa, int nivel, int level) {
        n.e.accept(this, mapa, level, nivel + 1);
        n.i.accept(this, mapa, level, nivel + 1);
        int i = 0;
        while (i < n.el.size()) {
            n.el.elementAt(i).accept(this, mapa, level, nivel + 1);
            n.el.size();
            ++i;
        }
    }

    @Override
    public void visit(IntegerLiteral n, Map mapa, int nivel, int level) {
    }

    @Override
    public void visit(True n, Map mapa, int nivel, int level) {
    }

    @Override
    public void visit(False n, Map mapa, int nivel, int level) {
    }

    @Override
    public void visit(IdentifierExp n, Map mapa, int nivel, int level) {
    }

    @Override
    public void visit(This n, Map mapa, int nivel, int level) {
    }

    @Override
    public void visit(NewArray n, Map mapa, int nivel, int level) {
        n.e.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(NewObject n, Map mapa, int nivel, int level) {
        n.i.accept(this, mapa, level, nivel + 1);
    }

    @Override
    public void visit(Not n, Map mapa, int nivel, int level) {
        n.e.accept(this, mapa, level, nivel);
    }

    @Override
    public void visit(Identifier n, Map mapa, int nivel, int level) {
    }
}

