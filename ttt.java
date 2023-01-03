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
    }
}