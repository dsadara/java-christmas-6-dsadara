package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.type.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static christmas.type.ErrorCode.INPUT_IS_NOT_NUMBER;

public class InputView {

    public static int readVisitingDate() {
        String input = Console.readLine();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    public static List<Menu> readOrderMenus() {
        String input = Console.readLine();
        List<String> commaSeparatedItems = splitByComma(input);
        return getMenuList(commaSeparatedItems);
    }

    // Stream 사용해서 할 방법 찾기
    public static List<Menu> getMenuList(List<String> commaSeparatedItems) {
        List<Menu> menus = new ArrayList<>();
        for (String item : commaSeparatedItems) {
            String[] hyphenSeparatedItems = item.split("-");
            String menu = hyphenSeparatedItems[0];
            int number = Integer.parseInt(hyphenSeparatedItems[1]);
            for (int i = 0; i < number; i++) {
                menus.add(Menu.of(menu));
            }
        }
        return menus;
    }

    private static List<String> splitByComma(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validateNumeric(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER.getMessage());
        }
    }

}
