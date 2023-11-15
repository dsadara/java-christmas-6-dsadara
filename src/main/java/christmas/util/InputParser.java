package christmas.util;

import christmas.type.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser {

    public static void validateNumeric(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> splitByComma(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static void validateHyphen(List<String> commaSeparatedItems) {
        for (String item : commaSeparatedItems) {
            if (!item.contains("-")) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static Map<Menu, Integer> getMenuMap(List<String> commaSeparatedItems) throws IllegalArgumentException {
        Map<Menu, Integer> menus = new HashMap<>();
        for (String item : commaSeparatedItems) {
            String[] hyphenSeparatedItems = item.split("-");
            Menu menu = Menu.of(hyphenSeparatedItems[0]);
            int number = Integer.parseInt(hyphenSeparatedItems[1]);
            // 중복 메뉴를 입력했는지 검증
            if (menus.containsKey(menu)) {
                throw new IllegalArgumentException();
            }
            menus.put(menu, number);
        }
        return menus;
    }

}
