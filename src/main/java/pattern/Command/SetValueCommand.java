package pattern.Command;

import pattern.Model.SudokuModel;

public class SetValueCommand implements SudokuCommand{

    private int col;
    private int row;
    private SudokuModel sudokuModel;
    private int oldValue;
    private int newValue;

    @Override
    public void execute() {
        oldValue = sudokuModel.getValueAt(row,col);
        sudokuModel.setValueAt(row,col,newValue);
    }

    @Override
    public void undo() {
        sudokuModel.setValueAt(row,col,oldValue);
    }


    public SetValueCommand(int col, int row, SudokuModel sudokuModel, int newValue) {
        this.col = col;
        this.row = row;
        this.sudokuModel = sudokuModel;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
}

