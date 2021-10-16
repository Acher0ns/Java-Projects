package parser;

public class Main {
    public static void main(String[] args) {
        Constant one = new Constant(1);
        System.out.println(one.evaluate());

        Increment onePlusOne = new Increment(one);
        System.out.println(onePlusOne.evaluate());

        Decrement oneMinusOne = new Decrement(one);
        System.out.println(oneMinusOne.evaluate());

        Addition onePlusOnePlusOne = new Addition(one, onePlusOne);
        System.out.println(onePlusOnePlusOne.evaluate());

        Subtraction oneMinusOnePlusOne = new Subtraction(one, onePlusOne);
        System.out.println(oneMinusOnePlusOne.evaluate());

        Square sqr = new Square(onePlusOnePlusOne);
        System.out.println(sqr.evaluate());
    }
}
