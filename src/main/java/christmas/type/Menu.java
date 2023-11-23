package christmas.type;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static christmas.type.ErrorCode.INVALID_ORDER;
import static christmas.type.MenuType.APPETIZER;
import static christmas.type.MenuType.DESSERT;
import static christmas.type.MenuType.DRINK;
import static christmas.type.MenuType.MAIN;

public enum Menu {

    MUSHROOM_SOUP("양송이수프", APPETIZER, 6000),
    TAPAS("타파스", APPETIZER, 5500),
    CAESER_SALAD("시저샐러드", APPETIZER, 8000),
    T_BONE_STEAK("티본스테이크", MAIN, 55000),
    BBQ_RIB("바비큐립", MAIN, 54000),
    SEAFOOD_PASTA("해산물파스타", MAIN, 35000),
    CHRISTMAS_PASTA("크리스마스파스타", MAIN, 25000),
    CHOCO_CAKE("초코케이크", DESSERT, 15000),
    ICECREAM("아이스크림", DESSERT, 5000),
    ZERO_COLA("제로콜라", DRINK, 3000),
    REDWINE("레드와인", DRINK, 60000),
    CHAMPAGNE("샴페인", DRINK, 25000),
    NONE("없음", MenuType.NONE, 0);

    private final String name;
    private final MenuType menuType;
    private final int price;

    private static final Map<String, Menu> MENU_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Menu::getName, Function.identity())));

    Menu(String name, MenuType menuType, int price) {
        this.name = name;
        this.menuType = menuType;
        this.price = price;
    }

    public static Menu of(String name) {
        if (MENU_MAP.containsKey(name)) {
            return MENU_MAP.get(name);
        }
        throw new IllegalArgumentException(INVALID_ORDER.getMessage());
    }

    public static List<Menu> getMenusByMenuType(MenuType menuType) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.menuType.equals(menuType))
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuType getMenuType() {
        return menuType;
    }

}

