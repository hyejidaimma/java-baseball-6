package baseball;

import baseball.Controller.Input.InputController;
import baseball.View.ExceptionMessage;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class InputControllerTest {

    @Test
    void BALL_정상_실행_확인() {
        String input = "123";
        ArrayList<Integer> result = InputController.validateInputBall(input);

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void BALL_문자_입력_시_예외_발생() {
        String input = "abc";
        assertThatThrownBy(() -> InputController.validateInputBall(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_INTEGER_EXCEPTION);
    }

    @Test
    void BALL_중복_포함_시_예외_발생() {
        String input = "112";
        assertThatThrownBy(() -> InputController.validateInputBall(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.HAS_DEPLICATE_EXCEPTION);
    }
    @Test
    void BALL_세자리_벗어나면_예외_발생() {
        String input = "1234";
        assertThatThrownBy(() -> InputController.validateInputBall(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LENGTH_EXCEPTION);
    }
    @Test
    void RESTART_문자_입력시_예외_발생() {
        String input = "a";
        assertThatThrownBy(() -> InputController.ValidateInputRestart(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_INTEGER_EXCEPTION);
    }

    @Test
    void RESTART_길이_예외_발생() {
        String input = "11";
        assertThatThrownBy(() -> InputController.ValidateInputRestart(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LENGTH_EXCEPTION);
    }

    @Test
    void RESTART_1_2_외에_예외_발생() {
        String input = "3";
        assertThatThrownBy(() -> InputController.ValidateInputRestart(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.RESTART_FLAG_EXCEPTION);
    }


}