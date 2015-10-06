package com.appfolio.test.player;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
/*
*  NaiveComputerPlayer -- Makes random moves.
* */
public class NaiveComputerPlayer extends AbstractComputerPlayer {

    private Random random = new Random();

    @Override
    public int nextMove(Set<Integer> availableSpots) {
        return findRandomSpot(availableSpots);
    }

    private int findRandomSpot(Set<Integer> availableSpots) {
        int index = random.nextInt(availableSpots.size());
        List<Integer> spots = new ArrayList<Integer>(availableSpots);
        return spots.get(index);
    }


}
