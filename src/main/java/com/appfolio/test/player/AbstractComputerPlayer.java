package com.appfolio.test.player;

import com.appfolio.test.enums.MarkTypeEnum;
import com.appfolio.test.enums.PlayerEnum;

public abstract class AbstractComputerPlayer implements TicTacToePlayer {

    @Override
    public PlayerEnum playerType() {
        return PlayerEnum.COMPUTER;
    }

    @Override
    public MarkTypeEnum markType() {
        return MarkTypeEnum.CROSS;
    }
}
