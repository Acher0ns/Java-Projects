package chevre;

public class Goat implements Runnable {
    private static final int MIN_COOL = 1;
    private static final int MAX_COOL = 100;

    private static final int MIN_STAMINA = 5;
    private static final int MAX_STAMINA = 10;

    private final String name;
    private final int coolness;
    private final int stamina;

    private final ClubChevre club;

    public Goat(ClubChevre club) {
        this.club = club;

        this.name = Utils.makeGoatName();
        this.coolness = Utils.getRandomNumber(MIN_COOL, MAX_COOL);
        this.stamina = Utils.getRandomNumber(MIN_STAMINA, MAX_STAMINA);
    }

    @Override
    public String toString() {
        return name + "{Cool = <" + this.coolness + "/" + MAX_COOL + ">, Stamina = <" + this.stamina + "/" + MAX_STAMINA + ">}";
    }

    @Override
    public void run() {
        synchronized(this) {
            synchronized(club) {
                System.out.println(name + " gets into line behind " + club.numberOfGoatsInLine() + " other goats.");
                club.getInLine(this);
                club.notify();
            }

            // Wait to get selected by the troll
            try {
                this.wait();
            } catch (InterruptedException e) {}

            System.out.println(this.getName() + " is dancing.");
            
            synchronized(club) {
                club.stopDancing(this);
                System.out.println(this.getName() + " has left the club.");
                club.notify();
            }
        }
    }
    
    public String getName() {
        return name;
    }

    public int getCoolness() {
        return coolness;
    }

    public int getStamina() {
        return stamina;
    }

    public static void main(String[] args) {
        ClubChevre club = new ClubChevre();
        Goat goat = new Goat(club);
        Thread thread = new Thread(goat);
        thread.start();
    }
}
