package assignments.two.part2;

import java.util.Random;

public class Bridge {
    private Random r = new Random();
    private boolean waiting = false;

    public void enterBridge() throws InterruptedException {
        while(this.waiting) {
            Thread.sleep((long)(r.nextInt(1250) + 500));
        }
        this.waiting = true;
    }

    public void leaveBridge() {
        this.waiting = false;
    }
}
