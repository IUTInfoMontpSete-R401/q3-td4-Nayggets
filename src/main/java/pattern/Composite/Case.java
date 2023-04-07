package pattern.Composite;

import pattern.Observer.SudokuCellView;

public class Case implements Composite{
    private Composite[] composites;

    public Case(int taille){
        composites = new Composite[taille];
    }




    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void setValue(int value) {

    }

    @Override
    public Composite[] getCell() {
        return composites;
    }


}
