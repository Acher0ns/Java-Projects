package parser;

public abstract class Unary implements Expression{
    protected final Expression expression;

    public Unary(Expression expression) {
        this.expression = expression;
    }
}
