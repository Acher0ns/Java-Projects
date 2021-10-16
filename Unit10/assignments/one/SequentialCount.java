package assignments.one;

import java.util.Scanner;
//import java.util.stream.IntStream; Used for verifying my code worked every time

public class SequentialCount implements Runnable {
    //public static int[] nums; Used for verifying my code worked every time
    private int currentNum;
    
    public SequentialCount(int num) {
        this.currentNum = num;
    }

    @Override
    public void run() {
        System.out.println(currentNum);

        /**
         * Used for verifying my code worked every time
         */
        //nums[currentNum - 1] = currentNum;
    }

    public static boolean assertIntArrayEquals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!(a[i] == b[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = input.nextInt();
        input.close();

        for (int i = 1; i <= n; i++){
            Thread printIThread = new Thread(new SequentialCount(i));
            printIThread.start();
            try {
                printIThread.join();
            } catch (InterruptedException e) {}
        }

        /**
         * Used for verifying my code worked every time
         */
        // for (int i = 1; i < 1000; i++) {
        //     nums = new int[i]; 
        //     for (int j = 1; j <= i; j++){
        //         Thread printIThread = new Thread(new SequentialCount(j));
        //         printIThread.start();
        //         try {
        //             printIThread.join();
        //         } catch (InterruptedException e) {}
        //     }
        //     System.out.println(assertIntArrayEquals(nums, IntStream.rangeClosed(1, i).toArray()));
        // }
    }
}
