package christmas.model;

import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OrderMenusTest {

    public static final List<Menu> MENUS_CONTAIN_ONLY_DRINKS = List.of(Menu.ZERO_COLA, Menu.CHAMPAGNE, Menu.REDWINE);
    public static final ArrayList<Menu> MENUS_HAVE_SIZE_OVER_20 = new ArrayList<>(Collections.nCopies(21, Menu.MUSHROOM_SOUP));

    @DisplayName("주문 메뉴 개수가 1개 미만이면 에러가 발생한다.")
    @Test
    public void createOrderMenusByNothing() {
        // when, then
        Assertions.assertThatThrownBy(() -> new OrderMenus(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문하면 예외가 발생한다.")
    @Test
    public void createOrderMenusByAllDrink() {
        // when, then
        Assertions.assertThatThrownBy(() -> new OrderMenus(MENUS_CONTAIN_ONLY_DRINKS))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴 개수가 20개가 넘어가면 예외가 발생한다.")
    @Test
    public void createOrderMenusByOverSize() {
        // when, then
        Assertions.assertThatThrownBy(() -> new OrderMenus(MENUS_HAVE_SIZE_OVER_20))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("양송이수프 3개를 주문하면 18000원이다.")
    @Test
    public void getPriceSumOfFiveSoup() {
        // given
        OrderMenus orderMenus = new OrderMenus(List.of(Menu.MUSHROOM_SOUP, Menu.MUSHROOM_SOUP, Menu.MUSHROOM_SOUP));
        // when, then
        Assertions.assertThat(orderMenus.getPriceSum()).isEqualTo(18000);
    }
}