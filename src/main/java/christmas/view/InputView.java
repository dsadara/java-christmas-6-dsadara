package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.type.ErrorCode.INPUT_IS_NOT_NUMBER;

public class InputView {

    public static int readVisitingDate() {
        String input = Console.readLine();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    private static void validateNumeric(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER.getMessage());
        }
    }

}
