package backtracker;

public class Queen {
    private final int row;
    private final int col;

    public Queen (int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Queen {row=<" + row + ">, col=<" + col + ">}";
    }

    public boolean canAttack(Queen enemy) {
        int rowDelta = this.row - enemy.row;
        int colDelta = this.col - enemy.col;

        return rowDelta == 0 || colDelta == 0 || rowDelta == colDelta || rowDelta == -colDelta;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public static void main(String[] args) {
        System.out.println(new Queen(2, 4));
        
        Queen queen1 = new Queen(1, 1);
        Queen queen2 = new Queen(3, 3);

        System.out.println(queen1.canAttack(queen2));
    }
}