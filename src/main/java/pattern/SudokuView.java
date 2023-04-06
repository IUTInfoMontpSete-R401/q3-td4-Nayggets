package pattern;

public class SudokuView {

    public void update(int row, int col, int value) {
        System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
    }


    public void displayVictoryMessage() {
        System.out.println("Congratulations, you won the game!");
    }

}
