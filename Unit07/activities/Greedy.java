package activities;

import java.util.ArrayList;
import java.util.List;

public class Greedy {
    public static List<Currency> makeChange(double price, double payment) {
        List<Currency> change = new ArrayList<>();
        double difference = payment - price;

        difference = countChange(difference, Currency.DOLLAR, change);
        difference = countChange(difference, Currency.QUARTER, change);
        difference = countChange(difference, Currency.DIME, change);
        difference = countChange(difference, Currency.NICKEL, change);
        difference = countChange(difference, Currency.PENNY, change);

        return change;
    }

    private static double countChange(double amount, Currency currency, List<Currency> change) {
        while (amount >= currency.getValue()) {
            change.add(currency);
            amount -= currency.getValue();
        }
        return amount;
    }

    public static void main(String[] args) {
        System.out.println(makeChange(3.56f, 5.00f));
        System.out.println(makeChange(4.95f, 5.00f));
    }
}
