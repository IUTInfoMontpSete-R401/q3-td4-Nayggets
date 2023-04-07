package pattern.Composite;

public class Cellule implements Composite{


    private Composite[][] composite;

    public Cellule(int[][] values){
        composite = new Composite[values.length][];
        for(int i = 0 ; i < values.length ;i++){
            for(int j = 0 ; j < values.length ;j++){
                composite[i][j] = new Case(values[i][j]);
            }
        }
    }

    public Cellule(Composite[][] composite){
        this.composite = new Composite[composite.length][];
        for(int i = 0 ; i < composite.length ; i++){
            for(int j = 0 ; j < composite[0].length ; j++){
                this.composite[i] = new Composite[composite[0].length];
                this.composite[i] = composite[i];
            }
        }
    }




    @Override
    public int getValue(int row, int col) {
        int sqrt = (int) Math.sqrt(composite.length);
        int real_row = row%sqrt;
        int real_col = col%sqrt;
        int definitive_col = (sqrt * real_row) + real_col ;
        return composite[definitive_col].getValue(row/sqrt,real_col);
    }

    @Override
    public void setValue(int row, int col,int value) {
        int sqrt = (int) Math.sqrt(composite.length);
        int real_row = row/sqrt;
        int real_col = col/sqrt;
        int definitive_col = real_row + real_col;
        composite[definitive_col].setValue(row%sqrt,real_col,value);
    }

    @Override
    public int length() {
        return composite.length;
    }


}
