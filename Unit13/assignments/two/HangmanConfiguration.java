package assignments.two;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import backtracker.Backtracker;
import backtracker.Configuration;

import assignments.two.Hangman.*;

public class HangmanConfiguration implements Configuration {
    private Hangman game;

    public HangmanConfiguration(Hangman game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return game.getGuesses() + ", " + game.revealed();
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>();
        for (int guess = 'a'; guess <= 'z'; guess++) {
            if (game.getGuesses().contains(Character.toString((char)guess).toUpperCase())) {
                continue;
            }
            Hangman copyGame = new Hangman(game);
            copyGame.guess((char)guess);
            successors.add(new HangmanConfiguration(copyGame));
        }
        return successors;
    }

    @Override
    public boolean isGoal() {
        return game.getStatus() == Status.WON;
    }

    @Override
    public boolean isValid() {
        return game.getWrongGuesses() == 0 && game.getStatus() != Status.LOST;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a secret phrase: ");
        String phrase = in.nextLine();

        Hangman game = new Hangman(phrase);
        HangmanConfiguration config = new HangmanConfiguration(game);
        Backtracker backtracker = new Backtracker(true);
        System.out.println(backtracker.solve(config));
        in.close();
    }
}
