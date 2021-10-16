package peggame;

import java.util.Scanner;

/**
 * Promts user for a file containing a PegGame and allows the user to play it through command line until completion
 * @author Jack Audino
 */
public class Project3Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        String line = s.nextLine();
        PegGame game = TriPegFileReader.makeGame(line);
        CommandLine.playGame(game);
        s.close();
    }
}
