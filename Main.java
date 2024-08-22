import java.util.*;

/*
This Programm is a TicTacToe Game on your Terminal
 */

 
 public class Main {
     static ArrayList<Integer> playerPositon = new ArrayList<>();
     static ArrayList<Integer> cpuPositon = new ArrayList<>();
    public static void main(String[] args) {

        boolean game_finished = false;

        //generating GameBoard in 2D Array
        char [][] gameboard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
            };

        printGameBoard(gameboard);//first Print

        while (! game_finished) {
            //generate Input
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter your Position (1-9)");

            //get Player Position (Input)
            int playerPos = scan.nextInt();
            //check Position
            while (playerPositon.contains(playerPos) || cpuPositon.contains(playerPositon)) {
                System.out.println("Position already taken! Choose another Position");
                playerPos = scan.nextInt();
            }
            System.out.println(playerPos); //print Input
            setPos(gameboard, playerPos, "player");

            //get Cpu Position(Random)
            Random r = new Random();
            int cpuPos = r.nextInt(9) + 1;
            //checkPosition
            while (playerPositon.contains(cpuPos) || cpuPositon.contains(cpuPos)) {
                cpuPos = r.nextInt(9) + 1;
            }

            //Set Input to the Board
            setPos(gameboard, cpuPos, "cpu");
            //Print new Board with the Input
            printGameBoard(gameboard);

            //check if cpu or player Win
            String res = checkChickenDinner();
            System.out.println(res);

            if(! res.isEmpty())
                game_finished = true;
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

     //Method to check if player or cpu won.
     public static String checkChickenDinner(){
         //create win possibilities
         List topRow = Arrays.asList(1,2,3);
         List midRow = Arrays.asList(4,5,6);
         List botRow = Arrays.asList(7,8,9);
         List lefCol = Arrays.asList(1,4,7);
         List midCol = Arrays.asList(2,5,8);
         List rightcol= Arrays.asList(3,6,9);
         List leftDia = Arrays.asList(1,5,9);
         List rightDia = Arrays.asList(3,5,7);

         //add win possibilities
         List<List> winning = new ArrayList<List>();
         winning.add(topRow);
         winning.add(midRow);
         winning.add(botRow);
         winning.add(lefCol);
         winning.add(midCol);
         winning.add(rightcol);
         winning.add(leftDia);
         winning.add(rightDia);

         //check if player or cpu get one the possibilities
         for(List l: winning){
             if(playerPositon.containsAll(l)){
                 return "Winner Winner Chicken Dinner!!";
             }else if (cpuPositon.containsAll(l)){
                 return "Looser Looser Bad User";
             }else if (playerPositon.size() + cpuPositon.size() == 9) {
                 return "Men Im Dead! It's a Suddendeath";
             }
         }

         return "";
     }

}