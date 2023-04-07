package pattern.Controller;

import pattern.Command.SetValueCommand;
import pattern.Composite.Cellule;
import pattern.Composite.Composite;
import pattern.Model.SudokuModel;
import pattern.Observer.SudokuCellView;
import pattern.Observer.SudokuObserver;
import pattern.View.SudokuView;

import java.util.Scanner;

public class SudokuController {

    SudokuView sudokuView;
    SudokuModel sudokuModel;

    public SudokuController(SudokuView sudokuView,SudokuModel sudokuModel){
        this.sudokuModel = sudokuModel;
        this.sudokuView = sudokuView;
        Composite[][] composites= sudokuView.getBoard();
        /*int i = 0;
        int j = 0;
        int nbLigne = 0;
        int departI = 0;
        for (Composite[] composite: composites){
            for(Composite composite1 : composite){
                setObserveur(new SudokuCellView(composite1,i,j));
                j++;
                if(j >= composites.length*composites.length){
                    i++;
                }
            }
            nbLigne++;
            if(nbLigne >= composites.length){
                departI += composites.length;
            }
            i = departI;

        }
        */
        for(int i = 0 ; i < composites.length*composites.length ; i++){
            for(int j = 0 ; j < composites.length*composites.length ; j++){
                sudokuModel.registerObserver(new SudokuCellView(sudoku[i][j/sudoku[0].length].getCells()[j%sudoku[0].length],i,j));
            }
        }

    }
    public void startGame(){
        while(!sudokuModel.isGameFinished()){
            handleUserInput();
            sudokuView.display();
        }
        sudokuView.displayVictoryMessage();
    }

    public void handleUserInput(){
        int[] coords = askUserForCoords();
        int value = askUserForValue();

        if(sudokuModel.isValueValid(coords[0],coords[1],value)){
            sudokuModel.setValueAt(coords[0],coords[1],value);
        }
    }

    public void setObserveur(SudokuObserver observer){
        sudokuModel.registerObserver(observer);
    }


    public int askUserForValue() {
        System.out.print("Enter value (1-9): ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        return value;
    }


    public int[] askUserForCoords() {
        Scanner scanner = new Scanner(System.in);
        int[] coords = new int[2];
        System.out.println("Enter row number (1-9):");
        coords[0] = scanner.nextInt() - 1; // Convert to 0-based indexing
        System.out.println("Enter column number (1-9):");
        coords[1] = scanner.nextInt() - 1; // Convert to 0-based indexing
        return coords;
    }
}

