package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.type.Menu;

import java.util.List;
import java.util.Map;

import static christmas.type.ErrorCode.INVALID_DATE;
import static christmas.type.ErrorCode.INVALID_ORDER;
import static christmas.util.InputParser.getMenuMap;
import static christmas.util.InputParser.splitByComma;
import static christmas.util.InputParser.validateHyphen;
import static christmas.util.InputParser.validateNumeric;

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

}
