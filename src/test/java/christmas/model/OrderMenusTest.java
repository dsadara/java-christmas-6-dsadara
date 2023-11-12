package christmas.model;

import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OrderMenusTest {

    public static final List<Menu> MENUS_CONTAIN_ONLY_DRINKS = List.of(Menu.제로콜라, Menu.샴페인, Menu.레드와인);
    public static final ArrayList<Menu> MENUS_HAVE_SIZE_OVER_20 = new ArrayList<>(Collections.nCopies(21, Menu.양송이수프));

    @DisplayName("음식을 아무것도 주문하지 않으면 예외가 발생한다.")
    @Test
    public void createOrderMenusByNothing() {
        //when
        //then
        Assertions.assertThatThrownBy(() -> new OrderMenus(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문하면 예외가 발생한다.")
    @Test
    public void createOrderMenusByAllDrink() {
        //when
        //then
        Assertions.assertThatThrownBy(() -> new OrderMenus(MENUS_CONTAIN_ONLY_DRINKS))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 개수가 20개가 넘어가면 예외가 발생한다.")
    @Test
    public void createOrderMenusByOverSize() {
        //when
        //then
        Assertions.assertThatThrownBy(() -> new OrderMenus(MENUS_HAVE_SIZE_OVER_20))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("양송이수프 3개를 주문하면 18000원이다.")
    @Test
    public void getPriceSumOfFiveSoup() {
        //given
        OrderMenus orderMenus = new OrderMenus(List.of(Menu.양송이수프, Menu.양송이수프, Menu.양송이수프));
        //when
        //then
        Assertions.assertThat(orderMenus.getPriceSum()).isEqualTo(18000);
    }
}