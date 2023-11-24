package baseball.Controller.Input;

import baseball.View.ExceptionMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InputController {
    public static ArrayList<Integer> inputBallValidation(String input) {
        formatValidation(input);
        duplicateValidation(input);
        lengthValidation(input);
        return createDigitList(input);
    }

    public static void formatValidation(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER_EXCEPTION);
        }
    }

    // 중복된 숫자 판별 메서드
    private static void duplicateValidation(String input) {
        Set<Character> digitSet = new HashSet<>();
        for (char digit : input.toCharArray()) {
            if (!digitSet.add(digit)) {
                throw new IllegalArgumentException(ExceptionMessage.HAS_DEPLICATE_EXCEPTION);
            }
        }
    }

    private static void lengthValidation(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(ExceptionMessage.LENGTH_EXCEPTION);
        }
    }

    private static ArrayList<Integer> createDigitList(String input) {
        ArrayList<Integer> digitList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            digitList.add(digit);
        }
        return digitList;
    }

}
