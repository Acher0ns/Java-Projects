package parser;

public class Addition implements Expression {
    private final Expression expressionA;
    private final Expression expressionB;

    public Addition(Expression expressionA, Expression expressionB) {
        this.expressionA = expressionA;
        this.expressionB = expressionB;
    }

    @Override
    public double evaluate() {
        return expressionA.evaluate() + expressionB.evaluate();
    }
}
