package christmas.model;

import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class OrderMenusTest {

    public static final Map<Menu, Integer> MENUS_CONTAIN_ONLY_DRINKS = Map.ofEntries(
            Map.entry(Menu.ZERO_COLA, 1),
            Map.entry(Menu.CHAMPAGNE, 1),
            Map.entry(Menu.REDWINE, 1)
    );
    public static final Map<Menu, Integer> MENUS_CONTAIN_ONE_TAPAS_AND_ONE_ZEROCOLA = Map.ofEntries(
            Map.entry(Menu.ZERO_COLA, 1),
            Map.entry(Menu.TAPAS, 1)
    );
    public static final Map<Menu, Integer> MENUS_HAVE_SIZE_OVER_20 = Map.of(Menu.REDWINE, 21);

    @DisplayName("주문 메뉴 개수가 1개 미만이면 에러가 발생한다.")
    @Test
    public void createOrderMenusByNothing() {
        // when, then
        Assertions.assertThatThrownBy(() -> new OrderMenus(Map.of()))
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
        Map<Menu, Integer> menus = Map.of(Menu.MUSHROOM_SOUP, 3);
        OrderMenus orderMenus = new OrderMenus(menus);

        // when, then
        Assertions.assertThat(orderMenus.getTotalAmount()).isEqualTo(18000);
    }

    @DisplayName("주문 메뉴를 출력한다.")
    @Test
    public void OrderMenus_toString() {
        // given
        OrderMenus orderMenus = new OrderMenus(MENUS_CONTAIN_ONE_TAPAS_AND_ONE_ZEROCOLA);

        // when, then
        Assertions.assertThat(orderMenus.toString())
                .contains("제로콜라 1개", "타파스 1개");
    }
}