//go pieces ◯ ●

import java.util.Scanner;

public class Go {

    //Initializes our empty go board
    static String[][] goBoard = new String[9][9];

    //Initializes our boolean live checker, with boolean's set to false
    static boolean[][] lives = new boolean[9][9];

    //Creates recursive "isalive" function
    static void isalive(int x, int y){
        //Checks if piece has any surrounding breathing spaces
        if ((goBoard[x+1][y] == null) || (goBoard[x-1][y] == null) || (goBoard[x][y+1] == null) || (goBoard[x][y-1] == null)){
            System.out.println(goBoard[x][y] + " is alive!");
        }   
    }

    public static void main(String[] args) {

        Boolean cont = true, turn = true;
        int moveX, moveY;

        Scanner scn = new Scanner(System.in);

        int dimension = goBoard.length - 1;

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (lives[i][j] == false){
                    System.out.print("T ");
                }

                if (lives[i][j] == true){
                    System.out.print("F ");
                }
                
            }
            System.out.println();
        }

        while (cont) {

            //Constructs our empty go board
            System.out.println("  0 1 2 3 4 5 6 7 8");
            for (int i = 0; i < goBoard.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < goBoard[i].length; j++) {
                    if (goBoard[i][j] == null) {
                        if (j == 0)
                            System.out.print("|");
                        else
                            System.out.print("-|");

                    } else {
                        System.out.print(goBoard[i][j]);
                    }

                }
                System.out.println();
            }

            //Prompts user to move and asks which coordinate they would like to move to
            System.out.println("\n" + ((turn) ? "Black" : "White") + "'s turn to move!\n\n");

            System.out.println("Please enter the x coordinate where you'd like to place a "
                    + ((turn) ? "Black" : "White") + " piece");

            moveX = scn.nextInt();

            System.out.println("Please enter the y coordinate where you'd like to place a "
                    + ((turn) ? "Black" : "White") + " piece");

            moveY = scn.nextInt();

            //Checks if a piece is out of bounds
            if ((moveY > dimension || moveY < 0) || (moveX > dimension || moveX < 0)) {
                System.out.println(
                        "\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\nOut of Bounds!\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
                continue;
            } else {
                
                //Places piece on valid coordiante
                if (goBoard[moveY][moveX] == null) {
                    goBoard[moveY][moveX] = ((turn) ? "-@" : "-#");
                    //Changes for the case when our piece is on the left edge
                    if (moveX == 0){
                        goBoard[moveY][moveX] = ((turn) ? "@" : "#");
                    }
                
                //Checks for pieces already in selected spot
                } else {
                    System.out.println(
                            "\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\nThere is already a piece there!\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
                    continue;
                }

            isalive(3,3);


            }

            turn = !turn;
        }

        scn.close();

    }

}

// T put was herekjjjl