package parser;

public class Increment extends Unary {
    public Increment(Expression expression) {
        super(expression);
    }

    @Override
    public double evaluate() {
        return expression.evaluate() + 1.0;
    }
}
