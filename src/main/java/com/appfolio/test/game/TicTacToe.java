package com.appfolio.test.game;

import com.appfolio.test.enums.PlayerEnum;
import com.appfolio.test.enums.MarkTypeEnum;
import com.appfolio.test.player.HumanPlayer;
import com.appfolio.test.player.NaiveComputerPlayer;
import com.appfolio.test.player.TicTacToePlayer;
import com.appfolio.test.utils.BoardUtils;
import com.sun.istack.internal.NotNull;

public class TicTacToe {

    private PlayerEnum startPlayer;
    private TicTacToePlayer humanPlayer;
    private TicTacToePlayer computerPlayer;
    private TicTacToePlayer winner;
    private TicTacToePlayer currPlayer;
    private Board board;

    public TicTacToe( @NotNull PlayerEnum startPlayer){

        this.board = new Board();
        this.startPlayer = startPlayer;
        this.humanPlayer = new HumanPlayer();
        this.computerPlayer = new NaiveComputerPlayer();
    }

    public Board getBoard(){
        return board;
    }

    public void start() {

        if(startPlayer == PlayerEnum.COMPUTER){
            currPlayer = computerPlayer;
        }
        else{
            currPlayer = humanPlayer;
        }

        int spot;
        while (true){

            /*
            * Keep getting nextMove until it's not an occupied spot
            * */
            while (true){
                spot = currPlayer.nextMove(board.getAvailableSpots());
                //If spot not taken
                if(board.getAvailableSpots().contains(spot))
                    break;
            }
            //Update the board with the move
            board.setMark(spot, currPlayer.markType());

            board.prettyPrintBoard();

            if(isGameOver(spot))
                break;

            //Switch player
            if(currPlayer.playerType() == PlayerEnum.COMPUTER){
                currPlayer = humanPlayer;
            }
            else{
                currPlayer = computerPlayer;
            }
        }
    }



    /*
    * This method is called every time a player makes a move to check for game over condition
    * Game is over if a player has won or there are no more moves left
    * */
    private boolean isGameOver(int spot){


        //It takes more than 4 movements to decide a winner
        if(board.getAvailableSpots().size() >= 5 )
            return false;

        MarkTypeEnum markToCheck = board.getMark(spot);

        return checkForHorizontalWin(spot, markToCheck) || checkVerticalWin(spot, markToCheck) || checkForDiagonalWin(spot, markToCheck) || board.getAvailableSpots().isEmpty();


    }

    private boolean checkForDiagonalWin(int spot, MarkTypeEnum markToCheck) {

        int leftCount = 0, rightCount = 0;

        //Check along the left diagonal for win
        if(BoardUtils.isAlongLeftDiagonal(spot)){
            for(int  i = 0; i < board.rowLength(); i++){
                if(board.getMark(i, i) != markToCheck)
                    break;
                leftCount++;
            }

        }

        //Check along the right diagonal for win
        if(BoardUtils.isAlongRightDiagonal(spot)){

            int r = 0;
            int c = board.colLength()-1;

            while(r < board.rowLength() && c >= 0){

                if(board.getMark(r, c) != markToCheck)
                    break;
                rightCount++;
                r++;
                c--;
            }

        }

       return hasWon(leftCount) || hasWon(rightCount);


    }



    private boolean checkForHorizontalWin(int spot, MarkTypeEnum markToCheck) {
        int count = 0;

        int row = board.getRow(spot);

        //Check along the row for win
        for(int c = 0; c < board.colLength(); c++){
            if(board.getMark(row, c) != markToCheck)
                break;
            count++;
        }

        return hasWon(count);
    }

    private boolean checkVerticalWin(int spot, MarkTypeEnum markToCheck) {
        int count = 0;

        int col = getBoard().getCol(spot);

        for(int r = 0; r < getBoard().rowLength(); r++){
            if(getBoard().getMark(r, col) != markToCheck)
                break;
            count++;
        }

       return hasWon(count);
    }

    /*
    * Condition for win. Update the winner if won
    * */
    private boolean hasWon(int count){
        if(count == BoardUtils.BOARD_SIZE){
            updateWinner();
            return true;
        }

        return false;
    }

    private void updateWinner() {
        winner = currPlayer;
    }

    public String printWinner(){
        if(winner == null)
            return "DRAW";

        return winner.playerType().value()+ " WINS!!!!!!!!!";
    }
}
