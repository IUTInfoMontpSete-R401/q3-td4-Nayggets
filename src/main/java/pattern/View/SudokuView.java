package pattern.View;

import pattern.Composite.Case;
import pattern.Composite.Cellule;
import pattern.Composite.Composite;
import pattern.Model.SudokuModel;

import java.util.ArrayList;

public class SudokuView {

    Composite[][] board;



    public SudokuView(int taille){
        board = new Composite[taille][taille];
        for(int i = 0 ; i < taille;i++){
            for(int j = 0; j  < taille; j++){
                Case cased = new Case(taille*taille);
                for(int l = 0 ; l < taille*taille;l++){
                    cased.getCell()[l] = new Cellule();
                }
                board[i][j] = cased;

            }


        }
    }


    public Composite[][] getBoard() {
        return board;
    }

    public void displayVictoryMessage() {
        System.out.println("Congratulations, you won the game!");
    }

    public void display() {
        for (int row = 0; row < this.getBoardSize(); row++) {
            if (row % this.getBlockSize() == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < this.getBoardSize(); col++) {
                if (col % this.getBlockSize() == 0) {
                    System.out.print("| ");
                }
                int value = board[blockIForRowAndCol(row)][blockJForRowAndCol(col)].getCell()[caseInBlockForRowAndCol(row,col)].getValue();
                if (value == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }



    public int getBoardSize() {
        return board.length;
    }

    private int blockIForRowAndCol(int row){
        int real_row = (int) (row / getBoardSize());
        return real_row;

    }

    private int blockJForRowAndCol(int col){
        int real_col = (int) (col / getBoardSize());
        return col;

    }

    private int caseInBlockForRowAndCol(int row,int col){
        int real_col = col % getBoardSize();
        int real_row = row % getBoardSize();
        int nb = real_row * getBoardSize() + real_col;
        return nb;
    }




    public int getBlockSize() {
        return board[0][0].getCell().length;
    }


}
