package activities;

public class Euclid {
    public static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(1871, 462));
        System.out.println(gcd(30, 12));
    }
}