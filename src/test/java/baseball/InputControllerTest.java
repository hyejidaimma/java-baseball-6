package baseball;

import baseball.Controller.Input.InputController;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class InputControllerTest {

    @Test
    void 정상_실행_확인() {
        String input = "123";
        ArrayList<Integer> result = InputController.inputBallValidation(input);

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void 문자_입력_시_예외_발생() {
        String input = "abc";
        assertThatThrownBy(() -> InputController.inputBallValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수를 입력하시오.");
    }

    @Test
    void 중복_포함_시_예외_발생() {
        String input = "112";
        assertThatThrownBy(() -> InputController.inputBallValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복 없이 입력하시오.");
    }
    @Test
    void 세자리_벗어나면_예외_발생() {
        String input = "1234";
        assertThatThrownBy(() -> InputController.inputBallValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 3자리 정수를 입력하시오.");
    }

}