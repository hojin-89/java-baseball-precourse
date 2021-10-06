package baseball;

import java.util.HashMap;
import java.util.Map;

public class BaseballService {

    Map<String,Object> returnValue = new HashMap<String,Object>();

    public Map<String,Object> matchBaseballNumber(String inputNumber, String matchTargetNumber){
        int strike = 0;
        int ball = 0;

        for(int i=0; i<3; i++){
            strike += matchStrike(inputNumber.charAt(i),matchTargetNumber.charAt(i));
            ball += matchBall(i, inputNumber.charAt(i),matchTargetNumber);
        }

        return resultReturn(strike, ball);
    }

    public Map<String,Object> resultReturn(int strike, int ball){
        String resultMsg = "";
        returnValue.put("all_match_yn","N");

        if(strike != 0){ resultMsg += strike+"스트라이크 "; }
        if(ball !=0){ resultMsg += ball+"볼"; }
        if(strike == 3){
            returnValue.put("result_msg","3스트라이크");
            returnValue.put("all_match_yn","Y");
        }
        if(strike == 0 && ball ==0){
            resultMsg+= "낫싱";
        }
        returnValue.put("result_msg",resultMsg);
        return returnValue;
    }

    public int matchBall(int targetSize, char target, String matchTargetNumber){
        int ballMatchCnt = 0;
        for(int i=0; i<3; i++){
            ballMatchCnt += ballCheck(targetSize, i, target, matchTargetNumber.charAt(i));
        }
        return ballMatchCnt;
    }

    public int matchStrike(char char1, char char2){
        if(char1 == char2){
            return 1;
        }
        return 0;
    }

    public int ballCheck(int targetSize, int size, char char1, char char2){
        if( targetSize !=  size && char1 == char2){
            return 1;
        }
        return 0;
    }

}
