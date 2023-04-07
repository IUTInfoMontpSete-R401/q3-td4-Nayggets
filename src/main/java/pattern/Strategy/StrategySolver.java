package pattern.Strategy;

import antipattern.Sudoku;
import pattern.Model.SudokuModel;

public interface StrategySolver {
    public boolean solve(SudokuModel sudoku);

}
