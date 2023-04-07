package pattern.Strategy;

import antipattern.Sudoku;

public class BacktrackingSolver implements StrategySolver{
    public boolean solve(Sudoku sudoku) {
        return solveCell(0,0,sudoku);
    }


    private boolean solveCell(int row, int column, Sudoku sudoku) {
        if (row == sudoku.getBoardSize()) {
            return true;
        } else {
            int nextRow = column == sudoku.getBoardSize() - 1 ? row + 1 : row;
            int nextColumn = (column + 1) % sudoku.getBoardSize();
            if (sudoku.getValueAt(row, column) != 0) {
                return this.solveCell(nextRow, nextColumn, sudoku);
            } else {
                for(int value = 1; value <= sudoku.getBoardSize(); ++value) {
                    if (sudoku.isValueValid(row, column, value)) {
                        sudoku.setValueAt(row, column, value);
                        if (this.solveCell(nextRow, nextColumn, sudoku)) {
                            return true;
                        }

                        sudoku.setValueAt(row, column, 0);
                    }
                }

                return false;
            }
        }
    }
}
