package baseball;

import nextstep.utils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        BaseballView baseballView = new BaseballView();
        BaseballModel baseballModel = new BaseballModel();
        BaseballController baseballController = new BaseballController(baseballView, baseballModel);

        baseballController.gameStart();

    }
}
