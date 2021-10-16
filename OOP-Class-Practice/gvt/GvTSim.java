package gvt;

public class GvTSim {
    public static void main(String[] args) {
        Mage mage1 = new Mage("mage-1");
        Mage mage2 = new Mage("mage-2");

        Fighter fighter1 = new Fighter("fighter-1");
        Fighter fighter2 = new Fighter("fighter-1");

        System.out.println(mage1);
        System.out.println(mage2);
        System.out.println(fighter1);
        System.out.println(fighter2);
        Attack m1Attack = mage1.attack();
        mage2.takeDamage(m1Attack);
        mage2.takeDamage(m1Attack);
        mage2.takeDamage(m1Attack);
        mage2.takeDamage(m1Attack);
        mage2.takeDamage(m1Attack);
        mage2.takeDamage(m1Attack);
        fighter1.takeDamage(fighter2.attack());
        fighter1.takeDamage(fighter2.attack());
        fighter1.takeDamage(fighter2.attack());
        fighter1.takeDamage(fighter2.attack());
        fighter1.takeDamage(fighter2.attack());
        fighter1.takeDamage(fighter2.attack());
        fighter1.takeDamage(fighter2.attack());
        fighter1.takeDamage(fighter2.attack());
        fighter1.takeDamage(fighter2.attack());
        fighter1.takeDamage(fighter2.attack());
        fighter1.takeDamage(fighter2.attack());
        fighter1.takeDamage(fighter2.attack());
        
        fighter2.takeDamage(fighter1.attack());
        mage1.takeDamage(mage2.attack());
        Attack f1Attack = fighter1.attack();
        mage2.takeDamage(f1Attack);
        System.out.println(mage1);
        System.out.println(mage2);
        System.out.println(fighter1);
        System.out.println(fighter2);


        // Goat goat1 = new Goat("Goat1", 10);
        // System.out.println(goat1);
        // goat1.takeDamage(f1Attack);
        // System.out.println(goat1);
        // System.out.println(goat1.isConscious());
        // Attack ga = goat1.attack();
        // fighter1.takeDamage(ga);
        // System.out.println(fighter1);

        // Trolling mage1 = new Trolling("Trolling-1");
        // Trollzord fighter1 = new Trollzord("Trollzord-1");

        // System.out.println(mage1);
        // System.out.println(fighter1);
        // fighter1.takeDamage(mage1.attack());
        // mage1.takeDamage(fighter1.attack());
        // mage1.takeDamage(fighter1.attack());
        // fighter1.takeDamage(mage1.attack());
        // System.out.println(mage1);
        // System.out.println(fighter1);
        // System.out.println(mage1.isVanquished());
    }
}
