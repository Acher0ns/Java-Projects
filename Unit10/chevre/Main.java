package chevre;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClubChevre club = new ClubChevre();
        
        TrollBouncer troll = new TrollBouncer(club);
        Thread trollThread = new Thread(troll);
        trollThread.start();
        
        for (int i = 0; i < 1000; i++) {
            Goat goat = new Goat(club);
            Thread goatThread = new Thread(goat);
            goatThread.start();
        }
        
        trollThread.join();
        
        System.out.println("Club is closing for the night");
    }
}
