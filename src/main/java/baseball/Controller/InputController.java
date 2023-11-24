package baseball.Controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
    public static final String INPUT_MSG = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUM_MSG = "숫자를 입력해주세요 :";
    public static final String INPUT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static String inputBalls(){
        System.out.println(INPUT_MSG);
        System.out.println(INPUT_NUM_MSG);
        return Console.readLine();
    }

    public static String inputRestart(){
        System.out.println(INPUT_RESTART);
        return Console.readLine();
    }

}
