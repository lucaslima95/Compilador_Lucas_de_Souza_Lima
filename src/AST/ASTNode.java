
package AST;

public abstract class ASTNode {
    public int line_number;

    public ASTNode(int ln) {
        this.line_number = ln;
    }
}

