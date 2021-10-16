package peggame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Provides a way of creating a PegBoard with a file where the first line contains the number of rows,
 * the rest containing the actual rows on the PegGame board
 */
public class TriPegFileReader {
    /**
     * Creates a Triangular PegGame from the file
     * @param filename file containing PegBoard layout
     * @return PegGame created from given file or null if file cannot be found
     */
    public static PegGame makeGame(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int rows = Integer.parseInt(br.readLine());
            Location[][] pegs = new Location[rows][];
            
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                pegs[lineNumber] = new Location[lineNumber + 1];
                for (int col = 0; col < pegs[lineNumber].length; col++) {
                    if (line.charAt(col) == '.') {
                        pegs[lineNumber][col] = new Location(lineNumber, col);
                    } else {
                        pegs[lineNumber][col] = new Location(lineNumber, col, true);
                    }
                }
                lineNumber++;
            }

            PegGame game = new TriPegGame(rows, pegs);
            br.close();
            fr.close();
            return game;
        } catch(IOException ioe) {
            System.out.println("Cannot find the specified file.");
            return null;
        }
    }

    /**
     * Manual test for makeGame, prints board made from file
     */
    public static void main(String[] args) {
        System.out.println(makeGame("C:/Users/Kamron Cole/Documents/GitHub/SoftDevII/Project01/data/3.txt"));
    }
}
