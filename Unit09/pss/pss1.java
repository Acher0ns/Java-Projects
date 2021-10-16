package pss;

import java.util.ArrayList;
import java.util.List;

public class pss1 {
    /**
     * Problem Solving 1
     */
    public class WoolieEx implements Runnable {
        private String name;
        private int crossingTime;
        private String destCity;

        public WoolieEx(String name, int crossingTime, String destCity) {
            this.name = name;
            this.crossingTime = crossingTime;
            this.destCity = destCity;
        }

        @Override
        public void run() {
            System.out.println(name + crossingTime + destCity); // redundent call to remove the blue squiggles :)
        }
    }



    /**
     * Problem Solving 2
     * 
     * Falco has arrived at the bridge
     * Marley has arrived at the bridge
     * Deirdre has arrived at the bridge
     *     Falco 1 seconds
     *     Marley 1 seconds
     *     Deirdre 1 seconds
     *     Falco 2 seconds
     *     Marley 2 seconds
     *     Deirdre 2 seconds
     *     Falco 3 seconds
     *     Marley 3 seconds
     * Marly leaves at DESTINATION
     *     Deirdre 3 seconds
     *     Falco 4 seconds
     * Falco leaves at DESTINATION
     *     Deirdre 4 seconds
     *     Deirdre 5 seconds
     * Deirdre leaves at DESTINATION
     */

    
    
    /**
     * Problem Solving 3
     */
    public enum City {
        MERCTRAN, 
        SICSTINE
    }

    public class Woolie implements Runnable {
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
    }

    

    /**
     * Problem Solving 4
     */
    public Woolie falco = new Woolie("Falco", 4, City.MERCTRAN);
    public Woolie marly = new Woolie("Marly", 3, City.SICSTINE);
    public Woolie deirdre = new Woolie("Deirdre", 5, City.MERCTRAN);

    public static void main(String[] args) {
        pss1 pss = new pss1();
        List<Woolie> woolies = new ArrayList<>();
        woolies.add(pss.falco);
        woolies.add(pss.marly);
        woolies.add(pss.deirdre);

        for (Woolie woolie : woolies) {
            Thread thread = new Thread(woolie);
            thread.start();
        }
    }
}
