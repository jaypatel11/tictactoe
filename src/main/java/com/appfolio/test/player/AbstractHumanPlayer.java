package com.appfolio.test.player;

import com.appfolio.test.enums.MarkTypeEnum;
import com.appfolio.test.enums.PlayerEnum;

public abstract class AbstractHumanPlayer implements TicTacToePlayer {

    @Override
    public PlayerEnum playerType() {
        return PlayerEnum.HUMAN;
    }

    @Override
    public MarkTypeEnum markType() {
        return MarkTypeEnum.ZERO;
    }
}
