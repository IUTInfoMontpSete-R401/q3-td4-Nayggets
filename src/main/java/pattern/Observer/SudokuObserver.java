package pattern.Observer;

public interface SudokuObserver {
    public void update(int row, int col, int value);
}
