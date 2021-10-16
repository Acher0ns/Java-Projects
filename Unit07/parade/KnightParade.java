package parade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import backtracker.Backtracker;
import backtracker.Configuration;

public class KnightParade implements Configuration {
    private Chessboard chessboard;
    private int row;
    private int col;
    private boolean valid; //maybe

    public KnightParade(Chessboard chessboard, int row, int col) {
        this.row = row;
        this.col = col;
        this.chessboard = chessboard;
        valid = chessboard.makeMove(row, col);
    }

    @Override
    public String toString() {
        return chessboard.toString();
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>();

        int row = this.row; 
        int col = this.col; 

        int dx[] = { 2, 2, 1, 1, -1, -1, -2, -2 }; 
        int dy[] = { 1, -1, 2, -2, 2, -2, 1, -1 };
  
        for (int i = 0; i < 8; i++) { 
            Chessboard board = new Chessboard(chessboard);
            int mRow = row + dy[i]; 
            int mCol = col + dx[i]; 
  
            KnightParade newConfig = new KnightParade(board, mRow, mCol);
            successors.add(newConfig);
        }
        return successors;
    }

    @Override
    public boolean isGoal() {
        return valid && chessboard.isFull();
    }

    @Override
    public boolean isValid() {
        return valid && (getSuccessors() != null || chessboard.isFull());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int boardSize = Integer.parseInt(sc.nextLine());

        System.out.print("Enter starting position: ");
        String[] initPosStrA = sc.nextLine().split(" ");
        int[] initPos = new int[] {Integer.parseInt(initPosStrA[0]), Integer.parseInt(initPosStrA[1])};

        Chessboard board = new Chessboard(boardSize);
        KnightParade kp = new KnightParade(board, initPos[0], initPos[1]);

        Backtracker backtracker = new Backtracker(false);
        Configuration solution = backtracker.solve(kp);

        if (solution != null) {
            System.out.println(solution);
        } else {
            System.out.println("No solution.");
        }
        sc.close();
    }
}
