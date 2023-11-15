package christmas.model;

import christmas.type.Menu;
import christmas.type.MenuType;

import java.util.List;
import java.util.Map;

import static christmas.type.ErrorCode.CANNOT_ORDER_ONLY_DRINKS;
import static christmas.type.ErrorCode.INVALID_ORDER;
import static christmas.type.ErrorCode.ORDER_MENU_NUMBER_LIMIT_IS_20;

public class OrderMenus {

    private static final int NUMBER_OF_MENUS_LIMIT = 20;

    private final Map<Menu, Integer> menus;

    public OrderMenus(Map<Menu, Integer> menus) {
        validateNumber(menus);
        validateMenu(menus);
        this.menus = menus;
    }

    public int getTotalAmount() {
        return menus.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    private void validateMenu(Map<Menu, Integer> menus) {
        if (isOnlyOrderDrink(menus)) {
            throw new IllegalArgumentException(CANNOT_ORDER_ONLY_DRINKS.getMessage());
        }
    }

    private boolean isOnlyOrderDrink(Map<Menu, Integer> menus) {
        return menus.keySet().stream()
                .allMatch(menu -> menu.getMenuType().equals(MenuType.DRINK));
    }

    private void validateNumber(Map<Menu, Integer> menus) {
        int numberOfMenus = getNumberOf(menus);

        if (numberOfMenus < 1) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }

        if (numberOfMenus > NUMBER_OF_MENUS_LIMIT) {
            throw new IllegalArgumentException(ORDER_MENU_NUMBER_LIMIT_IS_20.getMessage());
        }
    }

    private int getNumberOf(Map<Menu, Integer> menus) {
        return menus.values().stream()
                .mapToInt(Integer::intValue).sum();
    }

    public int getNumberByMenuType(MenuType menuType) {
        return menus.entrySet().stream()
                .filter(entry -> entry.getKey().getMenuType().equals(menuType))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    @Override
    public String toString() {
        List<String> menuAndNumberFormatted = menus.entrySet().stream()
                .map(entry -> entry.getKey().getName() + " " + entry.getValue() + "개").toList();
        return String.join("\n", menuAndNumberFormatted);
    }

}