package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.*;

public class BaseballController {
    private final BaseballView view;
    private final BaseballModel model;
    private final BaseballService service = new BaseballService();

    public final int BASEBALL_MIN_NUMBER = 1;
    public final int BASEBALL_MAX_NUMBER = 9;

    public final String RESULT_MSG = "result_msg";
    public final String ALL_MATCH_YN = "all_match_yn";

    private final String GAME_START_MODE = "S";
    private final String GAME_END_MODE = "E";

    Map<String, Object> matchResult = new HashMap<String, Object>();

    public BaseballController(BaseballView view, BaseballModel model) {
        this.view = view;
        this.model = model;
    }

    public void userNumberInput(String userInput){ matchNumber(userInput); }

    public void userStartInput(String userStartInputData){
        if("1".equals(userStartInputData)){
            this.gameStart();
        }
        if("2".equals(userStartInputData)){
            System.exit(0);
        }
    }

    public void gameStart(){
        this.setGameStates(GAME_START_MODE);
        this.setModelbaseballNumber();

        while(GAME_START_MODE.equals(this.getGameStates())){
            this.gameStartView();
            String checkData = Console.readLine();
            inputCheck(checkData);
        }

        if(GAME_END_MODE.equals(this.getGameStates())){
            this.gameEndView();
            this.userStartInput(Console.readLine());
        }
    }

    public void gameStartView(){
        view.gameStart();
    }

    public void gameEndView(){
        view.gameEnd();
    }

    public void errorView(){
        view.errorMsg();
    }

    public void setModelbaseballNumber(){ model.setBaseballNumber(madeThreeNumber()); }

    public void setGameStates(String states){
        model.setGameState(states);
    }

    public String getGameStates(){
        return model.getGameState();
    }

    public void matchNumber(String inputNumber){
        matchResult = service.matchBaseballNumber(inputNumber, model.getBaseballNumber());
        System.out.println(matchResult.get(RESULT_MSG).toString());
        this.setGameStates(GAME_START_MODE);
        if( "Y".equals(matchResult.get(ALL_MATCH_YN))){
            this.setGameStates("E");
        }
    }

    public String madeThreeNumber(){
        StringBuilder returnNumber = new StringBuilder();
        List<Integer> nums = new ArrayList<Integer>();

        while(nums.size() < 3 ){
            nums.add(Randoms.pickNumberInRange(BASEBALL_MIN_NUMBER, BASEBALL_MAX_NUMBER));
        }

        ArrayList<Integer> baseballTargetNumber = new ArrayList<>(nums);

        for(int i=0; i<3; i++){
            returnNumber.append(baseballTargetNumber.get(i).toString());
        }

        return returnNumber.toString();
    }

    public void inputCheck(String inputData){
        if(inputData.length() != 3){
            this.errorView();
        }
        if(inputData.length() == 3){
            this.userNumberInput(inputData);
        }
    }

}
