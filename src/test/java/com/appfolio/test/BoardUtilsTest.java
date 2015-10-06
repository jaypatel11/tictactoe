package com.appfolio.test;

import com.appfolio.test.game.BoardIndex;
import com.appfolio.test.utils.BoardUtils;
import junit.framework.Assert;
import org.junit.Test;


public class BoardUtilsTest {

    @Test
    public void testBoardIndexToSpot(){

        int spot = BoardUtils.boardIndexToSpot(new BoardIndex(0, 0));
        Assert.assertEquals(spot, 1);

        spot = BoardUtils.boardIndexToSpot(new BoardIndex(0, 1));
        Assert.assertEquals(spot, 2);

        spot = BoardUtils.boardIndexToSpot(new BoardIndex(0, 2));
        Assert.assertEquals(spot, 3);

        spot = BoardUtils.boardIndexToSpot(new BoardIndex(1, 0));
        Assert.assertEquals(spot, 4);

        spot = BoardUtils.boardIndexToSpot(new BoardIndex(1, 1));
        Assert.assertEquals(spot, 5);

        spot = BoardUtils.boardIndexToSpot(new BoardIndex(1, 2));
        Assert.assertEquals(spot, 6);

        spot = BoardUtils.boardIndexToSpot(new BoardIndex(2, 0));
        Assert.assertEquals(spot, 7);

        spot = BoardUtils.boardIndexToSpot(new BoardIndex(2, 1));
        Assert.assertEquals(spot, 8);

        spot = BoardUtils.boardIndexToSpot(new BoardIndex(2, 2));
        Assert.assertEquals(spot, 9);


    }

    @Test
    public void testGetColumnFromSpot(){
        int col =  BoardUtils.getColumnFromSpot(1);
        Assert.assertEquals(col, 0);

        col =  BoardUtils.getColumnFromSpot(5);
        Assert.assertEquals(col, 1);

        col =  BoardUtils.getColumnFromSpot(9);
        Assert.assertEquals(col, 2);

        col =  BoardUtils.getColumnFromSpot(4);
        Assert.assertEquals(col, 0);

    }

    @Test
    public void testRowFromSpot(){
        int row =  BoardUtils.getRowFromSpot(1);
        Assert.assertEquals(row, 0);

        row =  BoardUtils.getRowFromSpot(5);
        Assert.assertEquals(row, 1);

        row =  BoardUtils.getRowFromSpot(9);
        Assert.assertEquals(row, 2);

        row =  BoardUtils.getRowFromSpot(7);
        Assert.assertEquals(row, 2);

    }

    @Test
    public void testIsAlongDiagonal(){

        boolean isAlongDiagonal = BoardUtils.isAlongDiagonal(0,0);
        Assert.assertEquals(isAlongDiagonal, true);

        isAlongDiagonal = BoardUtils.isAlongDiagonal(1,1);
        Assert.assertEquals(isAlongDiagonal, true);

        isAlongDiagonal = BoardUtils.isAlongDiagonal(2,1);
        Assert.assertEquals(isAlongDiagonal, false);

        isAlongDiagonal = BoardUtils.isAlongDiagonal(0,2);
        Assert.assertEquals(isAlongDiagonal, true);
    }
}
