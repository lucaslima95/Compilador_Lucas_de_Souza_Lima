
package AST.Visitor;

import AST.And;
import AST.ArrayAssign;
import AST.ArrayLength;
import AST.ArrayLookup;
import AST.Assign;
import AST.Block;
import AST.BooleanType;
import AST.Call;
import AST.ClassDeclExtends;
import AST.ClassDeclSimple;
import AST.False;
import AST.Formal;
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
import AST.Minus;
import AST.NewArray;
import AST.NewObject;
import AST.Not;
import AST.Plus;
import AST.Print;
import AST.Program;
import AST.Return;
import AST.This;
import AST.Times;
import AST.True;
import AST.VarDecl;
import AST.While;
import java.util.Map;

public interface Visitor {
    public void visit(Return var1, Map var2, int var3, int var4);

    public void visit(Program var1, Map var2, int var3, int var4);

    public void visit(MainClass var1, Map var2, int var3, int var4);

    public void visit(ClassDeclSimple var1, Map var2, int var3, int var4);

    public void visit(ClassDeclExtends var1, Map var2, int var3, int var4);

    public void visit(VarDecl var1, Map var2, int var3, int var4);

    public void visit(MethodDecl var1, Map var2, int var3, int var4);

    public void visit(Formal var1, Map var2, int var3, int var4);

    public void visit(IntArrayType var1, Map var2, int var3, int var4);

    public void visit(BooleanType var1, Map var2, int var3, int var4);

    public void visit(IntegerType var1, Map var2, int var3, int var4);

    public void visit(IdentifierType var1, Map var2, int var3, int var4);

    public void visit(Block var1, Map var2, int var3, int var4);

    public void visit(If var1, Map var2, int var3, int var4);

    public void visit(While var1, Map var2, int var3, int var4);

    public void visit(Print var1, Map var2, int var3, int var4);

    public void visit(Assign var1, Map var2, int var3, int var4);

    public void visit(ArrayAssign var1, Map var2, int var3, int var4);

    public void visit(And var1, Map var2, int var3, int var4);

    public void visit(LessThan var1, Map var2, int var3, int var4);

    public void visit(Plus var1, Map var2, int var3, int var4);

    public void visit(Minus var1, Map var2, int var3, int var4);

    public void visit(Times var1, Map var2, int var3, int var4);

    public void visit(ArrayLookup var1, Map var2, int var3, int var4);

    public void visit(ArrayLength var1, Map var2, int var3, int var4);

    public void visit(Call var1, Map var2, int var3, int var4);

    public void visit(IntegerLiteral var1, Map var2, int var3, int var4);

    public void visit(True var1, Map var2, int var3, int var4);

    public void visit(False var1, Map var2, int var3, int var4);

    public void visit(IdentifierExp var1, Map var2, int var3, int var4);

    public void visit(This var1, Map var2, int var3, int var4);

    public void visit(NewArray var1, Map var2, int var3, int var4);

    public void visit(NewObject var1, Map var2, int var3, int var4);

    public void visit(Not var1, Map var2, int var3, int var4);

    public void visit(Identifier var1, Map var2, int var3, int var4);
}

