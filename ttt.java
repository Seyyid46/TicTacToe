import java.util.*;

/*
This Programm is a TicTacToe Game on your Terminal
 */

 
 public class ttt {
     static ArrayList<Integer> playerPositon = new ArrayList<>();
     static ArrayList<Integer> cpuPositon = new ArrayList<>();
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

        //get Player Position (Input)
        int playerPos = scan.nextInt();
        //check Position
        while(playerPositon.contains(playerPos)||cpuPositon.contains(playerPositon)){
            System.out.println("Position already taken! Choose another Position");
            playerPos = scan.nextInt();
        }
        System.out.println(playerPos); //print Input
        setPos(gameboard, playerPos, "player");

        //get Cpu Position(Random)
        Random r = new Random();
        int cpuPos = r.nextInt(9) + 1;
        //checkPosition
        while(playerPositon.contains(cpuPos)||cpuPositon.contains(cpuPos)){
            cpuPos = r.nextInt(9) + 1;
        }
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

     public static void setPos(char[][] gameboard,int pos,String user){

         char symbol = ' ';

         //Decide if user or cpu
         if (user.equals("player")){
             symbol = 'X';
             playerPositon.add(pos);
         } else if (user.equals("cpu")) {
             symbol = 'O';
             cpuPositon.add(pos);
         }

         //Place input on gameboard in case of symbol
         switch (pos){
             case 1:
                 gameboard [0][0] = symbol;
                 break;
             case 2:
                 gameboard [0][2] = symbol;
                 break;
             case 3:
                 gameboard [0][4] = symbol;
                 break;
             case 4:
                 gameboard [2][0] = symbol;
                 break;
             case 5:
                 gameboard [2][2] = symbol;
                 break;
             case 6:
                 gameboard [2][4] = symbol;
                 break;
             case 7:
                 gameboard [4][0] = symbol;
                 break;
             case 8:
                 gameboard [4][2] = symbol;
                 break;
             case 9:
                 gameboard [4][4] = symbol;
                 break;
         }
     }

}