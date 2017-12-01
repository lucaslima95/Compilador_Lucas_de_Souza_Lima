package Parser;

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
import AST.Statement;
import AST.StatementList;
import AST.This;
import AST.Times;
import AST.True;
import AST.Type;
import AST.VarDecl;
import AST.VarDeclList;
import AST.While;
import Parser.parser;
import java.util.Stack;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
import java_cup.runtime.lr_parser;

class parser_actions {
    private final parser parser;

    parser_actions(parser parser2) {
        this.parser = parser2;
    }

    public final Symbol CUP$parser$do_action(int CUP$parser$act_num, lr_parser CUP$parser$parser, Stack CUP$parser$stack, int CUP$parser$top) throws Exception {
        switch (CUP$parser$act_num) {
            case 52: {
                ExpList el;
                ExpList RESULT = null;
                RESULT = el = new ExpList(0);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("ExpList", 13, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 51: {
                ExpList RESULT = null;
                int eleft = ((Symbol)CUP$parser$stack.peek()).left;
                int eright = ((Symbol)CUP$parser$stack.peek()).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.peek()).value;
                ExpList el = new ExpList(eleft);
                el.addElement(e);
                RESULT = el;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("ExpList", 13, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 50: {
                ExpList RESULT = null;
                int elleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int elright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                ExpList el = (ExpList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int eleft = ((Symbol)CUP$parser$stack.peek()).left;
                int eright = ((Symbol)CUP$parser$stack.peek()).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.peek()).value;
                el.addElement(e);
                RESULT = el;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("ExpList", 13, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 2), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 49: {
                Exp e;
                Exp RESULT = null;
                int eleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int eright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                RESULT = e = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 2), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 48: {
                Not RESULT = null;
                int eleft = ((Symbol)CUP$parser$stack.peek()).left;
                int eright = ((Symbol)CUP$parser$stack.peek()).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new Not(e, eleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 1), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 47: {
                NewObject RESULT = null;
                int ileft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int iright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                String i = (String)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                Identifier id = new Identifier(i, ileft);
                RESULT = new NewObject(id, ileft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 3), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 46: {
                NewArray RESULT = null;
                int eleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int eright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                RESULT = new NewArray(e, eleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 4), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 45: {
                This RESULT = null;
                int tleft = ((Symbol)CUP$parser$stack.peek()).left;
                int tright = ((Symbol)CUP$parser$stack.peek()).right;
                Object t = ((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new This(tleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 44: {
                IdentifierExp RESULT = null;
                int nameleft = ((Symbol)CUP$parser$stack.peek()).left;
                int nameright = ((Symbol)CUP$parser$stack.peek()).right;
                String name = (String)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new IdentifierExp(name, nameleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 43: {
                Exp RESULT = null;
                int bleft = ((Symbol)CUP$parser$stack.peek()).left;
                int bright = ((Symbol)CUP$parser$stack.peek()).right;
                Boolean b = (Boolean)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = b != false ? new True(bleft) : new False(bleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 42: {
                IntegerLiteral RESULT = null;
                int ileft = ((Symbol)CUP$parser$stack.peek()).left;
                int iright = ((Symbol)CUP$parser$stack.peek()).right;
                Integer i = (Integer)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new IntegerLiteral(i, ileft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 41: {
                Call RESULT = null;
                int eleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 5))).left;
                int eright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 5))).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 5))).value;
                int idleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 3))).left;
                int idright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 3))).right;
                String id = (String)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 3))).value;
                int epleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int epright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                ExpList ep = (ExpList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                Identifier i = new Identifier(id, idleft);
                RESULT = new Call(e, i, ep, eleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 5), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 40: {
                ArrayLength RESULT = null;
                int arg1left = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int arg1right = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Exp arg1 = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                RESULT = new ArrayLength(arg1, arg1left);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 2), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 39: {
                ArrayLookup RESULT = null;
                int arg1left = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 3))).left;
                int arg1right = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 3))).right;
                Exp arg1 = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 3))).value;
                int arg2left = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int arg2right = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                Exp arg2 = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                RESULT = new ArrayLookup(arg1, arg2, arg1left);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 3), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 38: {
                Times RESULT = null;
                int arg1left = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int arg1right = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Exp arg1 = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int arg2left = ((Symbol)CUP$parser$stack.peek()).left;
                int arg2right = ((Symbol)CUP$parser$stack.peek()).right;
                Exp arg2 = (Exp)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new Times(arg1, arg2, arg1left);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 2), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 37: {
                Minus RESULT = null;
                int arg1left = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int arg1right = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Exp arg1 = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int arg2left = ((Symbol)CUP$parser$stack.peek()).left;
                int arg2right = ((Symbol)CUP$parser$stack.peek()).right;
                Exp arg2 = (Exp)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new Minus(arg1, arg2, arg1left);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 2), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 36: {
                Plus RESULT = null;
                int arg1left = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int arg1right = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Exp arg1 = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int arg2left = ((Symbol)CUP$parser$stack.peek()).left;
                int arg2right = ((Symbol)CUP$parser$stack.peek()).right;
                Exp arg2 = (Exp)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new Plus(arg1, arg2, arg1left);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 2), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 35: {
                LessThan RESULT = null;
                int arg1left = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int arg1right = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Exp arg1 = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int arg2left = ((Symbol)CUP$parser$stack.peek()).left;
                int arg2right = ((Symbol)CUP$parser$stack.peek()).right;
                Exp arg2 = (Exp)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new LessThan(arg1, arg2, arg1left);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 2), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 34: {
                And RESULT = null;
                int arg1left = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int arg1right = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Exp arg1 = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int arg2left = ((Symbol)CUP$parser$stack.peek()).left;
                int arg2right = ((Symbol)CUP$parser$stack.peek()).right;
                Exp arg2 = (Exp)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new And(arg1, arg2, arg1left);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Exp", 12, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 2), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 33: {
                ArrayAssign RESULT = null;
                int ileft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 6))).left;
                int iright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 6))).right;
                String i = (String)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 6))).value;
                int ieleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).left;
                int ieright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).right;
                Exp ie = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).value;
                int eleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int eright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                Identifier id = new Identifier(i, ileft);
                RESULT = new ArrayAssign(id, ie, e, ileft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Statement", 10, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 6), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 32: {
                Assign RESULT = null;
                int ileft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 3))).left;
                int iright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 3))).right;
                String i = (String)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 3))).value;
                int eleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int eright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                Identifier id = new Identifier(i, ileft);
                RESULT = new Assign(id, e, ileft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Statement", 10, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 3), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 31: {
                Print RESULT = null;
                int eleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int eright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                RESULT = new Print(e, eleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Statement", 10, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 4), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 30: {
                While RESULT = null;
                int eleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int eright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int sleft = ((Symbol)CUP$parser$stack.peek()).left;
                int sright = ((Symbol)CUP$parser$stack.peek()).right;
                Statement s = (Statement)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new While(e, s, eleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Statement", 10, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 4), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 29: {
                If RESULT = null;
                int eleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).left;
                int eright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).value;
                int isleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int isright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Statement is = (Statement)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int esleft = ((Symbol)CUP$parser$stack.peek()).left;
                int esright = ((Symbol)CUP$parser$stack.peek()).right;
                Statement es = (Statement)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new If(e, is, es, eleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Statement", 10, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 6), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 28: {
                Block RESULT = null;
                int slleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int slright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                StatementList sl = (StatementList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                RESULT = new Block(sl, slleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Statement", 10, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 2), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 27: {
                Object RESULT = null;
                RESULT = null;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Statement", 10, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 1), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 26: {
                StatementList sl;
                StatementList RESULT = null;
                RESULT = sl = new StatementList(0);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("StatementList", 11, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 25: {
                StatementList RESULT = null;
                int sleft = ((Symbol)CUP$parser$stack.peek()).left;
                int sright = ((Symbol)CUP$parser$stack.peek()).right;
                Statement s = (Statement)((Symbol)CUP$parser$stack.peek()).value;
                StatementList sl = new StatementList(sleft);
                sl.addElement(s);
                RESULT = sl;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("StatementList", 11, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 24: {
                StatementList RESULT = null;
                int slleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int slright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                StatementList sl = (StatementList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                int sleft = ((Symbol)CUP$parser$stack.peek()).left;
                int sright = ((Symbol)CUP$parser$stack.peek()).right;
                Statement s = (Statement)((Symbol)CUP$parser$stack.peek()).value;
                sl.addElement(s);
                RESULT = sl;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("StatementList", 11, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 1), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 23: {
                FormalList fl;
                FormalList RESULT = null;
                RESULT = fl = new FormalList(0);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("FormalList", 9, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 22: {
                FormalList RESULT = null;
                int fleft = ((Symbol)CUP$parser$stack.peek()).left;
                int fright = ((Symbol)CUP$parser$stack.peek()).right;
                Formal f = (Formal)((Symbol)CUP$parser$stack.peek()).value;
                FormalList fl = new FormalList(fleft);
                fl.addElement(f);
                RESULT = fl;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("FormalList", 9, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 21: {
                FormalList RESULT = null;
                int flleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int flright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                FormalList fl = (FormalList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int fleft = ((Symbol)CUP$parser$stack.peek()).left;
                int fright = ((Symbol)CUP$parser$stack.peek()).right;
                Formal f = (Formal)((Symbol)CUP$parser$stack.peek()).value;
                fl.addElement(f);
                RESULT = fl;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("FormalList", 9, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 2), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 20: {
                Formal RESULT = null;
                int vdleft = ((Symbol)CUP$parser$stack.peek()).left;
                int vdright = ((Symbol)CUP$parser$stack.peek()).right;
                VarDecl vd = (VarDecl)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new Formal(vd.t, vd.i, vdleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Formal", 8, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 19: {
                MethodDeclList ml;
                MethodDeclList RESULT = null;
                RESULT = ml = new MethodDeclList(0);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("MethodDeclList", 7, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 18: {
                MethodDeclList RESULT = null;
                int mdleft = ((Symbol)CUP$parser$stack.peek()).left;
                int mdright = ((Symbol)CUP$parser$stack.peek()).right;
                MethodDecl md = (MethodDecl)((Symbol)CUP$parser$stack.peek()).value;
                MethodDeclList ml = new MethodDeclList(mdleft);
                ml.addElement(md);
                RESULT = ml;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("MethodDeclList", 7, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 17: {
                MethodDeclList RESULT = null;
                int mlleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int mlright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                MethodDeclList ml = (MethodDeclList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                int mdleft = ((Symbol)CUP$parser$stack.peek()).left;
                int mdright = ((Symbol)CUP$parser$stack.peek()).right;
                MethodDecl md = (MethodDecl)((Symbol)CUP$parser$stack.peek()).value;
                ml.addElement(md);
                RESULT = ml;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("MethodDeclList", 7, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 1), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 16: {
                MethodDecl RESULT = null;
                int vdleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 9))).left;
                int vdright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 9))).right;
                VarDecl vd = (VarDecl)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 9))).value;
                int flleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 7))).left;
                int flright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 7))).right;
                FormalList fl = (FormalList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 7))).value;
                int slleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).left;
                int slright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).right;
                StatementList sl = (StatementList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).value;
                int eleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int eright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                Type ti = vd.t;
                Identifier id = vd.i;
                VarDeclList vl = new VarDeclList(0);
                RESULT = new MethodDecl(ti, id, fl, vl, sl, e, vdleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("MethodDecl", 6, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 10), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 15: {
                MethodDecl RESULT = null;
                int vdleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 10))).left;
                int vdright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 10))).right;
                VarDecl vd = (VarDecl)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 10))).value;
                int flleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 8))).left;
                int flright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 8))).right;
                FormalList fl = (FormalList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 8))).value;
                int vlleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 5))).left;
                int vlright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 5))).right;
                VarDeclList vl = (VarDeclList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 5))).value;
                int slleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).left;
                int slright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).right;
                StatementList sl = (StatementList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).value;
                int eleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int eright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Exp e = (Exp)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                Type ti = vd.t;
                Identifier id = vd.i;
                RESULT = new MethodDecl(ti, id, fl, vl, sl, e, vdleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("MethodDecl", 6, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 11), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 14: {
                VarDeclList vl;
                VarDeclList RESULT = null;
                RESULT = vl = new VarDeclList(0);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("VarDeclList", 5, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 13: {
                VarDeclList RESULT = null;
                int vdleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int vdright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                VarDecl vd = (VarDecl)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                VarDeclList vl = new VarDeclList(vdleft);
                vl.addElement(vd);
                RESULT = vl;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("VarDeclList", 5, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 1), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 12: {
                VarDeclList RESULT = null;
                int vlleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int vlright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                VarDeclList vl = (VarDeclList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int vdleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int vdright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                VarDecl vd = (VarDecl)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                vl.addElement(vd);
                RESULT = vl;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("VarDeclList", 5, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 2), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 11: {
                VarDecl RESULT = null;
                int tleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int tright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                String t = (String)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                int idleft = ((Symbol)CUP$parser$stack.peek()).left;
                int idright = ((Symbol)CUP$parser$stack.peek()).right;
                String id = (String)((Symbol)CUP$parser$stack.peek()).value;
                IdentifierType tipo = new IdentifierType(t, idleft);
                Identifier i = new Identifier(id, idleft);
                RESULT = new VarDecl(tipo, i, idleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("VarDecl", 4, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 1), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 10: {
                VarDecl RESULT = null;
                int idleft = ((Symbol)CUP$parser$stack.peek()).left;
                int idright = ((Symbol)CUP$parser$stack.peek()).right;
                String id = (String)((Symbol)CUP$parser$stack.peek()).value;
                IntegerType integer = new IntegerType(idleft);
                Identifier i = new Identifier(id, idleft);
                RESULT = new VarDecl(integer, i, idleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("VarDecl", 4, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 1), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 9: {
                VarDecl RESULT = null;
                int idleft = ((Symbol)CUP$parser$stack.peek()).left;
                int idright = ((Symbol)CUP$parser$stack.peek()).right;
                String id = (String)((Symbol)CUP$parser$stack.peek()).value;
                BooleanType boole = new BooleanType(idleft);
                Identifier i = new Identifier(id, idleft);
                RESULT = new VarDecl(boole, i, idleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("VarDecl", 4, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 1), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 8: {
                VarDecl RESULT = null;
                int idleft = ((Symbol)CUP$parser$stack.peek()).left;
                int idright = ((Symbol)CUP$parser$stack.peek()).right;
                String id = (String)((Symbol)CUP$parser$stack.peek()).value;
                IntArrayType array = new IntArrayType(idleft);
                Identifier i = new Identifier(id, idleft);
                RESULT = new VarDecl(array, i, idleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("VarDecl", 4, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 3), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 7: {
                ClassDeclSimple RESULT = null;
                int cnameleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).left;
                int cnameright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).right;
                String cname = (String)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).value;
                int avlleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int avlright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                VarDeclList avl = (VarDeclList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int amlleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int amlright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                MethodDeclList aml = (MethodDeclList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                Identifier idc = new Identifier(cname, cnameleft);
                RESULT = new ClassDeclSimple(idc, avl, aml, cnameleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("ClassDecl", 3, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 5), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 6: {
                ClassDeclExtends RESULT = null;
                int cnameleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 6))).left;
                int cnameright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 6))).right;
                String cname = (String)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 6))).value;
                int enameleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).left;
                int enameright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).right;
                String ename = (String)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 4))).value;
                int avlleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int avlright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                VarDeclList avl = (VarDeclList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                int amlleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int amlright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                MethodDeclList aml = (MethodDeclList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                Identifier idc = new Identifier(cname, cnameleft);
                Identifier ide = new Identifier(ename, enameleft);
                RESULT = new ClassDeclExtends(idc, ide, avl, aml, cnameleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("ClassDecl", 3, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 7), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 5: {
                ClassDeclList RESULT = null;
                int cdleft = ((Symbol)CUP$parser$stack.peek()).left;
                int cdright = ((Symbol)CUP$parser$stack.peek()).right;
                ClassDecl cd = (ClassDecl)((Symbol)CUP$parser$stack.peek()).value;
                ClassDeclList cl = new ClassDeclList(cdleft);
                cl.addElement(cd);
                RESULT = cl;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("ClassDeclList", 2, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 4: {
                ClassDeclList RESULT = null;
                int clleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int clright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                ClassDeclList cl = (ClassDeclList)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                int cdleft = ((Symbol)CUP$parser$stack.peek()).left;
                int cdright = ((Symbol)CUP$parser$stack.peek()).right;
                ClassDecl cd = (ClassDecl)((Symbol)CUP$parser$stack.peek()).value;
                cl.addElement(cd);
                RESULT = cl;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("ClassDeclList", 2, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 1), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 3: {
                MainClass RESULT = null;
                int cnameleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 15))).left;
                int cnameright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 15))).right;
                String cname = (String)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 15))).value;
                int pnameleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 5))).left;
                int pnameright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 5))).right;
                String pname = (String)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 5))).value;
                int sleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).left;
                int sright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).right;
                Statement s = (Statement)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 2))).value;
                Identifier idc = new Identifier(cname, cnameleft);
                Identifier idp = new Identifier(pname, pnameleft);
                RESULT = new MainClass(idc, idp, s, cnameleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("MainClass", 1, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 16), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 2: {
                Program RESULT = null;
                int mleft = ((Symbol)CUP$parser$stack.peek()).left;
                int mright = ((Symbol)CUP$parser$stack.peek()).right;
                MainClass m = (MainClass)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new Program(m, null, mleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Goal", 0, (Symbol)CUP$parser$stack.peek(), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
            case 1: {
                Program start_val;
                Program RESULT = null;
                int start_valleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int start_valright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                RESULT = start_val = (Program)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("$START", 0, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 1), (Symbol)CUP$parser$stack.peek(), RESULT);
                CUP$parser$parser.done_parsing();
                return CUP$parser$result;
            }
            case 0: {
                Program RESULT = null;
                int mleft = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).left;
                int mright = ((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).right;
                MainClass m = (MainClass)((Symbol)CUP$parser$stack.elementAt((int)(CUP$parser$top - 1))).value;
                int clleft = ((Symbol)CUP$parser$stack.peek()).left;
                int clright = ((Symbol)CUP$parser$stack.peek()).right;
                ClassDeclList cl = (ClassDeclList)((Symbol)CUP$parser$stack.peek()).value;
                RESULT = new Program(m, cl, mleft);
                Symbol CUP$parser$result = this.parser.getSymbolFactory().newSymbol("Goal", 0, (Symbol)CUP$parser$stack.elementAt(CUP$parser$top - 1), (Symbol)CUP$parser$stack.peek(), RESULT);
                return CUP$parser$result;
            }
        }
        throw new Exception("Invalid action number found in internal parse table");
    }
}

