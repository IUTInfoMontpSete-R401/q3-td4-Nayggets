package pattern.Observer;

import pattern.Observer.SudokuObserver;

public class SudokuCellView implements SudokuObserver {
    @Override
    public void update(int[][] board) {
            System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
            display();
    }

    public void display() {
        for (int row = 0; row < this.getBoardSize(); row++) {
            if (row % this.getBlockSize() == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < this.getBoardSize(); col++) {
                if (col % this.getBlockSize() == 0) {
                    System.out.print("| ");
                }
                int value = this.getValueAt(row, col);
                if (value == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }
}
