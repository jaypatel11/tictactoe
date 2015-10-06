package com.appfolio.test.utils;

import com.appfolio.test.game.BoardIndex;

public class BoardUtils {

    public final static int BOARD_SIZE = 3;

    public final static int TOTAL_SPOTS = BOARD_SIZE*BOARD_SIZE;


    /*
    * Convert boardIndex to a given spot
    * */
    public static int boardIndexToSpot(BoardIndex index){

        assert index.getRow() < BOARD_SIZE && index.getCol() < BOARD_SIZE;

        return 1 + (index.getRow()*BOARD_SIZE) + index.getCol();

    }

    /*
    *  Convert spot to boardIndex
    * */
    public static BoardIndex spotToBoardIndex(int spot){

        assert spot > 0 && spot <= TOTAL_SPOTS;

        int row = BoardUtils.getRowFromSpot(spot);
        int col = BoardUtils.getColumnFromSpot(spot);

        return new BoardIndex(row, col);
    }


    /*
    * Find column from a spot
    * */
    public static int getColumnFromSpot(int spot){

        int col = (spot-1) % BOARD_SIZE;

        return col;
    }


    /*
    * Find row from spot
    * */
    public static int getRowFromSpot(int spot){

        int row = (spot-1)/BOARD_SIZE;

        return row;
    }

    /*
    * Find if a given row, col is along diagonal
    * */
    public static boolean isAlongDiagonal(int row, int col){

        int spot = BoardUtils.boardIndexToSpot(new BoardIndex(row, col));
        return isAlongDiagonal(spot);
    }

    /*
    * Find if a given spot is along diagonal
    * */
    public static boolean isAlongDiagonal(int spot) {

        return isAlongLeftDiagonal(spot) || isAlongRightDiagonal(spot);
    }

    /*
    * Spots 1,5,9 rep. left diagonal
    * */
    public static boolean isAlongLeftDiagonal(int spot) {
        return spot == 1 || spot == 5 || spot == 9;
    }

    /*
    * Spots 3,5,7 rep. right diagonal
    * */
    public static boolean isAlongRightDiagonal(int spot) {

        return spot == 3 || spot  == 5 || spot == 7;
    }
}
