package com.appfolio.test.game;

import com.appfolio.test.enums.MarkTypeEnum;
import com.appfolio.test.utils.BoardUtils;

import java.util.HashSet;
import java.util.Set;

public class Board {

    private MarkTypeEnum[][] board;
    //Keep track of available spots
    private Set<Integer> availableSpots;

    public Board(){
        initBoard();
        initAvailableSpots();
    }


    private void initAvailableSpots() {

        availableSpots = new HashSet<Integer>();
        for(int i = 1; i <= BoardUtils.TOTAL_SPOTS; i++){
            availableSpots.add(i);
        }
    }

    public Set<Integer> getAvailableSpots(){
        return this.availableSpots;
    }


    /*
    * Initialize to blank/empty
    * */
    private void initBoard() {
        board = new MarkTypeEnum[BoardUtils.BOARD_SIZE][BoardUtils.BOARD_SIZE];

        for(int i = 0; i < BoardUtils.BOARD_SIZE; i++){

            for(int j =0; j < BoardUtils.BOARD_SIZE; j++){

                board[i][j] = MarkTypeEnum.EMPTY;
            }
        }
    }

    /*
    * Set a mark at a particular spot
    * */
    public void setMark(int spot, MarkTypeEnum markType) {
        BoardIndex index = BoardUtils.spotToBoardIndex(spot);
        board[index.getRow()][index.getCol()] = markType;
        availableSpots.remove(spot);
    }

    /*
    * print the board
    * */
    public void prettyPrintBoard(){

        for(int i = 0; i < board.length; i++){

            for(int j = 0; j < board[0].length; j++){


                System.out.print(board[i][j].value());
                if(j < board[0].length -1){
                    System.out.print("  |  ");
                }
            }

            System.out.println();
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    /*
    * Get the value X /0/ Empty at a given row, col
    * */
    public MarkTypeEnum getMark(int row, int col){
        return board[row][col];
    }

    /*
   * Get the value X /0/ Empty at a given spot
   * */
    public MarkTypeEnum getMark(int spot){
        BoardIndex index = BoardUtils.spotToBoardIndex(spot);
        return getMark(index.getRow(), index.getCol());
    }

    /*
    * Convert a spot to row/col index
    * */
    public BoardIndex spotToBoardIndex(int spot){
        return BoardUtils.spotToBoardIndex(spot);
    }

    /*
    * Find row no of a particular spot
    * */

    public int getRow(int spot){
        return BoardUtils.getRowFromSpot(spot);
    }

    /*
    * Find col no of a particular spot
    * */
    public int getCol(int spot){
        return BoardUtils.getColumnFromSpot(spot);
    }

    public int rowLength(){
        return board.length;
    }

    public int colLength(){
        return board[0].length;
    }


}
