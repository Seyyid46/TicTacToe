import java.util.*;

/*
This Programm is a TicTacToe Game on your Terminal
 */

 
 public class Main{

    public static void main(String[] args) {

        //generating GameBoard in 2D Array
        char [][] gameboard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
            };

        printGameBoard(gameboard);//first Print

        //generate Input
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your Position (1-9)");
    }

    /*
    Method to print the Board
     */
    public static void printGameBoard(char[][] gameboard){
        for (char[] row:gameboard){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

}