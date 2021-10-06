package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;

public class BaseballModel {

    private String baseballNumber;
    private String gameState;

    public BaseballModel(){}

    public String getBaseballNumber() {
        return baseballNumber;
    }

    public void setBaseballNumber(String madeThreeNumber){
        this.baseballNumber = madeThreeNumber;
    }

    public String getGameState(){ return gameState; }

    public void setGameState(String gameState){
        this.gameState = gameState;
    }



}
