package parser;

public class Subtraction implements Expression {
    private final Expression expressionA;
    private final Expression expressionB;

    public Subtraction(Expression expressionA, Expression expressionB) {
        this.expressionA = expressionA;
        this.expressionB = expressionB;
    }

    @Override
    public double evaluate() {
        return expressionA.evaluate() - expressionB.evaluate();
    }
}
