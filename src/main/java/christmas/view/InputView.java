package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.type.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static christmas.type.ErrorCode.INPUT_IS_NOT_NUMBER;
import static christmas.type.ErrorCode.INVALID_ORDER;

public class InputView {

    public static int readVisitingDate() {
        String input = Console.readLine();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    public static Map<Menu, Integer> readOrderMenus() {
        String input = Console.readLine();
        List<String> commaSeparatedItems = splitByComma(input);
        return getMenuMap(commaSeparatedItems);
    }

    private static List<String> splitByComma(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static Map<Menu, Integer> getMenuMap(List<String> commaSeparatedItems) {
        Map<Menu, Integer> menus = new HashMap<>();
        for (String item : commaSeparatedItems) {
            String[] hyphenSeparatedItems = item.split("-");
            Menu menu = Menu.of(hyphenSeparatedItems[0]);
            int number = Integer.parseInt(hyphenSeparatedItems[1]);
            if (menus.containsKey(menu)) {
                throw new IllegalArgumentException(INVALID_ORDER.getMessage());
            }
            menus.put(menu, number);
        }
        return menus;
    }

    private static void validateNumeric(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER.getMessage());
        }
    }

}
