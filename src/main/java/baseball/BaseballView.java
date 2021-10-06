package baseball;

import nextstep.utils.Console;

public class BaseballView {

    public void gameStart(){
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public void gameEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void errorMsg(){
        System.out.println("[ERROR]");
    }

}
