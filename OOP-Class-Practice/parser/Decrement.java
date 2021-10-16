package parser;

public class Decrement extends Unary {
    public Decrement(Expression expression) {
        super(expression);
    }

    @Override
    public double evaluate() {
        return expression.evaluate() - 1.0;
    }
}