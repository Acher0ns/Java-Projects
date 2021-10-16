package backtracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NQueens implements Configuration {
    private final Queen[] queens;
    private final int n;

    public NQueens(int n, Queen[] queens) {
        this.n = n;
        this.queens = queens != null ? queens : new Queen[0];
    }

    public NQueens (int n) {
        this(n, new Queen[0]);
    }

    @Override
    public String toString() {
        String[][] board = new String[n][n];
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                board[row][col] = "[ ]";
            }
        }

        for(Queen q : queens) {
            board[q.getRow()][q.getCol()] = "[Q]";
        }

        StringBuilder builder = new StringBuilder();
        for(String[] row : board) {
            for(String col : row) {
                builder.append(col);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>();
        int length = queens.length;
        int row = length > 0 ? queens[length - 1].getRow() + 1 : 0;
        if (row < n) {
            for (int col = 0; col < n; col++) {
                Queen[] copy = Arrays.copyOf(queens, length + 1);
                copy[length] = new Queen(row, col);
                successors.add(new NQueens(n, copy));
            }
        }
        return successors;
    }

    @Override
    public boolean isGoal() {
        return isValid() && queens.length == n;
    }

    @Override
    public boolean isValid() {
        int length = queens.length;
        if (length < 2) {
            return true;
        }

        Queen lastQueen = queens[length - 1];

        for (Queen queen : queens) {
            if (!queen.equals(lastQueen) && queen.canAttack(lastQueen)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // NQueens config = new NQueens(4);
        // System.out.println(config);
        // System.out.println(config.isValid());
        // System.out.println(config.isGoal());
        // Collection<Configuration> successors = config.getSuccessors();

        // for (Configuration successor : successors) {
        //     System.out.println(successor);
        //     System.out.println(successor.isValid());
        //     System.out.println(successor.isGoal());
        // }
        Backtracker backtracker = new Backtracker(false);
        NQueens nQueens = new NQueens(20);
        Configuration solution = backtracker.solve(nQueens);
        System.out.println(solution);
    }
}
