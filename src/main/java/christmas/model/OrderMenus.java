package christmas.model;

import christmas.type.Menu;
import christmas.type.MenuType;

import java.util.List;

public class OrderMenus {

    private static final String ORDER_MENU_NUMBER_IS_MORE_THAN_0 = "음식을 1개 이상 주문해야 합니다.";
    private static final String CANNOT_ORDER_ONLY_DRINKS = "음료만 주문 시, 주문할 수 없습니다.";
    private static final String ORDER_MENU_NUMBER_LIMIT_IS_20 = "메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.";
    private static final int NUMBER_OF_MENUS_LIMIT = 20;

    private final List<Menu> menus;

    public OrderMenus(List<Menu> menus) {
        validateSize(menus);
        validateMenu(menus);
        this.menus = menus;
    }

    public int getPriceSum() {
        return menus.stream().mapToInt(Menu::getPrice).sum();
    }

    public void validateMenu(List<Menu> menus) {
        if (isOnlyOrderDrink(menus)) {
            throw new IllegalArgumentException(CANNOT_ORDER_ONLY_DRINKS);
        }
    }

    public void validateSize(List<Menu> menus) {
        if (menus.size() < 1) {
            throw new IllegalArgumentException(ORDER_MENU_NUMBER_IS_MORE_THAN_0);
        }

        if (menus.size() > NUMBER_OF_MENUS_LIMIT) {
            throw new IllegalArgumentException(ORDER_MENU_NUMBER_LIMIT_IS_20);
        }
    }

    private boolean isOnlyOrderDrink(List<Menu> menus) {
        return menus.stream()
                .allMatch(menu -> menu.getMenuType().equals(MenuType.DRINK));
    }

}