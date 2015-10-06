package com.appfolio.test;

import com.appfolio.test.enums.PlayerEnum;
import com.appfolio.test.game.TicTacToe;

import java.util.Scanner;

/*
* -tac-toe game where a human can play against the computer via command line interface. Here is an example,

%> ./tic-tac-toe

   |   |
--- --- ---
   |   |
--- --- ---
   |   |

move (1-9): 3 (human types 3)

   |   | X   <---- human move
--- --- ---
   |   |
--- --- ---
   |   | O   <----- computer move

move (1-9): 2 (human types 2)

   | X | X
--- --- ---
   | O |
--- --- ---
   |   | O

move (1-9): ...

and so on until either someone wins or draws. The above UI is just an example, you can choose to make your own. You can choose whether the computer or human goes first. You can choose how to handle errors (i.e. human inputs a number which already has an X or O in it). You can choose what tests to write.

The computer does not need to make smart moves ... in fact, you can make it play random moves. However, I'd like to be able to implement a different computer algorithm without changing any of your code (think object oriented design).

This version only needs to support the text based terminal.

Let me know if you have any questions and whether you can send me the solution in 24 hours.

Thanks!

*
* */
public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner in = new Scanner(System.in);
        System.out.println("Who goes first? H/C");


        char ch;
        while(true){
            System.out.println("Enter C or H");
            String input = in.next();

            if("H".equals(input) || "C".equals(input)){
                ch = input.charAt(0);
                break;
            }
        }

        //Find the start player
        PlayerEnum startPlayer;
        if(ch == 'H'){
            startPlayer = PlayerEnum.HUMAN;
        }
        else{
            startPlayer = PlayerEnum.COMPUTER;
        }

        TicTacToe ticTacToe = new TicTacToe(startPlayer);

        ticTacToe.start();

        System.out.println(ticTacToe.printWinner());


    }
}
