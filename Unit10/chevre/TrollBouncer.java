package chevre;

public class TrollBouncer implements Runnable {
    private final ClubChevre club;

    public TrollBouncer(ClubChevre club) {
        this.club = club;
    }

    @Override
    public void run() {
        synchronized(club) {
            if (club.numberOfGoatsInLine() == 0) {
                try {
                    club.wait();
                } catch (InterruptedException e) {}
            }

            while(club.numberOfGoatsInLine() > 0 || club.numberOfDancingGoats() > 0) {
                while(!club.isAtCapacity() && club.numberOfGoatsInLine() > 0) {
                    Goat goat = club.getGoatAtPosition(0);
                    club.removeGoatFromLine(goat);
                    club.startDancing(goat);
                    System.out.println("Troll Bouncer lets " + goat.getName() + " into the club. Dance Floor Capacity: " + club.numberOfDancingGoats());
                    synchronized(goat) {
                        goat.notify();
                    }
                }
                try {
                    club.wait();
                } catch (InterruptedException e) {}
            }
        }
    }
}
