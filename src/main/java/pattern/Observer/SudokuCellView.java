package pattern.Observer;

import pattern.Model.SudokuModel;
import pattern.Observer.SudokuObserver;

public class SudokuCellView implements SudokuObserver {
    private SudokuModel sudokuModel;
    private int row;
    private int col;

    public SudokuCellView(SudokuModel sudokuModel, int row, int col) {
        this.sudokuModel = sudokuModel;
        this.row=row;
        this.col=col;
    }

    @Override
    public void update(int row, int col, int value) {
        if(row==this.row && col==this.col){
            System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
            sudokuModel.setValueAt(row,col,value);
        }
    }
}