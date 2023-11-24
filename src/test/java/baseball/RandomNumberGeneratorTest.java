package baseball;

import baseball.Model.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    public void 컴퓨터_패_유효성_검사() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        ArrayList<Integer> computer = randomNumberGenerator.computerInit();
        // 테스트: 생성된 숫자 리스트의 크기는 3이어야 함
        assertThat(computer).hasSize(3);
        // 테스트: 생성된 숫자는 1부터 9까지의 숫자여야 함
        for (int number : computer) {
            assertThat(number).isBetween(1, 9);
        }
        // 테스트: 생성된 숫자는 중복이 없어야 함
        assertThat(computer).doesNotHaveDuplicates();
    }
}
