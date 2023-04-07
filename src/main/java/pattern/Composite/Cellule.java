package pattern.Composite;

public class Cellule implements Composite {

    private int value;


    public Cellule() {
        value = 0;
    }


    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Composite[] getCell() {
        Composite[] composites = new Composite[1];
        composites[0] = this;
        return composites;
    }
}
