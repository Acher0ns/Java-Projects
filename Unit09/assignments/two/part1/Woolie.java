package assignments.two.part1;

import java.util.LinkedList;
import java.util.List;

public class Woolie implements Runnable {
    public enum City {
        MERCTRAN, 
        SICSTINE,
        MORDOR
    }

    private String name;
    private int crossingTime;
    private City destination;

    public Woolie(String name, int crossingTime, City destination) {
        this.name = name;
        this.crossingTime = crossingTime;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.println(this.name + " has arrived at the bridge.");
        
        try {
            Thread.sleep(5);
            System.out.println(this.name + " is starting to cross.");

            for (int i = 1; i <= crossingTime; i++) {
                Thread.sleep(1000);
                System.out.println("    " + this.name + " " + i + " seconds.");
            }
        }
        catch (InterruptedException e) {
            System.out.println(this.name + " was interrupted while crossing the bridge.");
            return;
        }

        System.out.println(this.name + " leaves at " + this.destination);
    }

    public static void main(String[] args) {
        Woolie falco = new Woolie("Falco", 4, City.MERCTRAN);
        Woolie marly = new Woolie("Marly", 3, City.SICSTINE);
        Woolie deirdre = new Woolie("Deirdre", 5, City.MERCTRAN);
        Woolie frodo = new Woolie("Frodo", 7, City.MORDOR);
        List<Woolie> woolies = new LinkedList<>();
        woolies.add(falco);
        woolies.add(marly);
        woolies.add(deirdre);
        woolies.add(frodo);

        for (Woolie woolie : woolies) {
            Thread thread = new Thread(woolie);
            thread.start();
        }
    }
}
