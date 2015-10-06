package com.appfolio.test.player;

import com.appfolio.test.enums.PlayerEnum;
import com.appfolio.test.enums.MarkTypeEnum;

import java.util.Set;

/*
* A given tictactoe player can make a move, has a mark X or 0 and can be of type human or computer
* */
public interface TicTacToePlayer {

    public int nextMove(Set<Integer> availableSpots);

    public PlayerEnum playerType();

    public MarkTypeEnum markType();

}
