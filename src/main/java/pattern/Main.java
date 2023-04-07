package pattern;

import pattern.Controller.SudokuController;
import pattern.Model.SudokuModel;
import pattern.Strategy.BacktrackingSolver;
import pattern.View.SudokuView;

public class Main {
    public static void main(String[] args) {
        SudokuModel sudokuModel = new SudokuModel(9);
        SudokuView sudokuView = new SudokuView(9);
        SudokuController sudokuController = new SudokuController(sudokuView,sudokuModel);
        sudokuView.display();
        BacktrackingSolver backtrackingSolver = new BacktrackingSolver();
        sudokuController.startGame();
        sudokuView.display();


    }
}
