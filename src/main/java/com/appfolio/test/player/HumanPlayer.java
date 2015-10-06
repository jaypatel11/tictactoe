package com.appfolio.test.player;

import java.util.Scanner;
import java.util.Set;
/*
* Human gives input to make a move
* */
public class HumanPlayer extends AbstractHumanPlayer {

    private static Scanner INPUT = new Scanner(System.in);
    @Override
    public int nextMove(Set<Integer> availableSpots) {

        System.out.println("Enter move 1-9:");

        System.out.println("Available spots"+availableSpots);
        int move = INPUT.nextInt();

        return move;
    }


}
