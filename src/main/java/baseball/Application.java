package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Inspection inspection = new Inspection();
        Game game = new Game();
        boolean gameWon = false, restart = false;
        //컴퓨터 패 생성
        List<Integer> comList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        comList.forEach(element -> System.out.println(element));

        while (!gameWon || !restart) {
            //사용자 패 생성
            List<Integer> userList = inspection.userInputToList();
            userList.forEach(element -> System.out.println(element));
            game.play(comList, userList);
            if (game.getflag() == true) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                comList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
                comList.forEach(element -> System.out.println(element));
                gameWon = true;
                if (inspection.RestartInput() == 2) {
                    restart = true;
                }

            }


        }


    }
}

