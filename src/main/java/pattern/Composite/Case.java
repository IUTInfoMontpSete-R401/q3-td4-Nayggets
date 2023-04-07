package pattern.Composite;

public class Case implements Composite{
    private int value;

    public Case(int value){
        this.value = value;
    }




    @Override
    public int getValue(int row, int col) {
        return value;
    }

    @Override
    public void setValue(int row, int col, int value) {
        this.value = value;
    }

    @Override
    public int length() {
        return 1;
    }


}
