package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.type.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static christmas.type.ErrorCode.INVALID_DATE;
import static christmas.type.ErrorCode.INVALID_ORDER;

public class InputView {

    public static int readVisitingDate() {
        int date;
        while (true) {
            try {
                String input = Console.readLine();
                validateNumeric(input);
                date = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_DATE.getMessage());
            }
        }
        return date;
    }

    public static Map<Menu, Integer> readOrderMenus() {
        Map<Menu, Integer> menus;
        while (true) {
            try {
                String input = Console.readLine();
                List<String> commaSeparatedItems = splitByComma(input);
                validateHyphen(commaSeparatedItems);
                menus = getMenuMap(commaSeparatedItems);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_ORDER.getMessage());
            }
        }
        return menus;
    }

    private static void validateHyphen(List<String> commaSeparatedItems) {
        for (String item : commaSeparatedItems) {
            if (!item.contains("-")) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static List<String> splitByComma(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static Map<Menu, Integer> getMenuMap(List<String> commaSeparatedItems) throws IllegalArgumentException {
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

    private static void validateNumeric(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException();
        }
    }

}
