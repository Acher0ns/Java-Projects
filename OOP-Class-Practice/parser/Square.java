package parser;

public class Square extends Unary {
    public Square(Expression expression) {
        super(expression);
    }

    @Override
    public double evaluate() {
        return expression.evaluate() * expression.evaluate();
    }
}
