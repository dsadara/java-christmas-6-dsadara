package christmas.model;

import christmas.type.December;
import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;


class EventTest {

    public static final OrderMenus ORDER_MENUS_SAMPLE = new OrderMenus(Map.of(Menu.T_BONE_STEAK, 3));
    public static final December WEEKDAY = December.FOURTH;
    public static final OrderMenus ORDER_MENUS_CONTAIN_3_DESERT = new OrderMenus(Map.of(Menu.ICECREAM, 3));
    public static final December WEEKEND = December.FIRST;

    @DisplayName("크리스마스(25일)에는 3400원을 할인 받을 수 있다.")
    @Test
    public void applyChristmasDiscountAtChristmasDay() {
        // given
        Event event = new Event(ORDER_MENUS_SAMPLE, December.TWENTY_FIFTH);

        // when, then
        Assertions.assertThat(event.applyChristmasDiscount()).isEqualTo(3400);
    }

    @DisplayName("크리스마스(25일)가 지나면 크리스마스 디데이 할인을 받을 수 없다.")
    @Test
    public void applyChristmasDiscountAfterChristmasDay() {
        // given
        Event event = new Event(ORDER_MENUS_SAMPLE, December.TWENTY_SIXTH);

        // when, then
        Assertions.assertThat(event.applyChristmasDiscount()).isEqualTo(0);
    }

    @DisplayName("방문 날짜가 평일이면 디저트 메뉴를 1개당 2023원 할인 받는다.")
    @Test
    public void applyWeekDayDiscountAtWeekDay() {
        // given
        Event event = new Event(ORDER_MENUS_CONTAIN_3_DESERT, WEEKDAY);

        // when, then
        Assertions.assertThat(event.applyWeekDayDiscount()).isEqualTo(3 * 2023);
    }

    @DisplayName("방문 날짜가 평일이 아니면 디저트 메뉴를 할인받지 않는다.")
    @Test
    public void applyWeekDayDiscountAtWeekend() {
        // given
        Event event = new Event(ORDER_MENUS_CONTAIN_3_DESERT, WEEKEND);

        // when, then
        Assertions.assertThat(event.applyWeekDayDiscount()).isEqualTo(0);
    }

}