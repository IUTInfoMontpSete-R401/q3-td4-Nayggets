package pattern;

import pattern.Controller.SudokuController;
import pattern.Model.SudokuModel;
import pattern.Strategy.BacktrackingSolver;
import pattern.View.SudokuView;

public class Main {
    public static void main(String[] args) {
        SudokuModel sudokuModel = new SudokuModel(3);
        SudokuView sudokuView = new SudokuView(3);
        SudokuController sudokuController = new SudokuController(sudokuView,sudokuModel);
        sudokuController.startGame();


    }
}
