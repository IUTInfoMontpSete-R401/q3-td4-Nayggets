package pattern;

import pattern.Model.SudokuModel;
import pattern.View.SudokuView;

public class Main {
    public static void main(String[] args) {
        int[][] board = new int[9][];
        board[0] = new int[]{1, 2, 0,0,0,0,0,0,0};
        board[1] = new int[]{0, 0, 0,0,0,0,0,0,0};
        board[2] = new int[]{0, 0, 0,0,0,0,0,0,0};
        board[3] = new int[]{0, 0, 0,0,0,0,0,0,0};
        board[4] = new int[]{0, 0, 0,0,0,0,0,0,0};
        board[5] = new int[]{0, 0, 0,0,0,0,0,0,0};
        board[6] = new int[]{0, 0, 0,0,0,0,0,0,0};
        board[7] = new int[]{0, 0, 0,0,0,0,0,0,0};
        board[8] = new int[]{0, 0, 0,0,0,0,0,0,0};
        SudokuModel sudokuModel = new SudokuModel(board);
        SudokuView sudokuView = new SudokuView(sudokuModel);
        sudokuView.display();

    }
}
