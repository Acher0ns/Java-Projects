package peggame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Provides a way of creating a PegBoard with a file where the first line contains the number of rows,
 * the rest containing the actual rows on the PegGame board
 * @author Jack Audino
 */
public class RectPegFileReader {
    /**
     * Creates a Rectangular PegGame from the file
     * @param filename file containing PegBoard layout
     * @return PegGame created from given file or null if file cannot be found
     */
    public static PegGame makeGame(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int rows = Integer.parseInt(br.readLine());
            int cols = rows;
            Location[][] pegs = new Location[rows][rows];
            
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                for (int col = 0; col < cols; col++) {
                    if (line.charAt(col) == '.') {
                        pegs[lineNumber][col] = new Location(lineNumber, col);
                    } else {
                        pegs[lineNumber][col] = new Location(lineNumber, col, true);
                    }
                }
                lineNumber++;
            }

            PegGame game = new RectPegGame(rows, rows, pegs);
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
        System.out.println(makeGame("C:/Users/jacka/SoftDevII/Project/project-team-5/data/3_3.txt"));
    }
}
