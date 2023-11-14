package christmas.model;

import christmas.type.December;
import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;


class EventTest {

    public static final OrderMenus ORDER_MENUS_SAMPLE = new OrderMenus(Map.of(Menu.T_BONE_STEAK, 3));
    public static final OrderMenus ORDER_MENUS_CONTAIN_3_DESERT = new OrderMenus(Map.of(Menu.ICECREAM, 3));
    public static final OrderMenus ORDER_MENUS_CONTAIN_3_MAIN_MENU = new OrderMenus(Map.of(Menu.T_BONE_STEAK, 3));
    public static final December WEEKEND = December.FIRST;
    public static final December WEEKDAY = December.FOURTH;
    public static final December STAR_DAY = December.THIRD;
    public static final December NORMAL_DAY = December.FOURTH;

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

    @DisplayName("방문 날짜가 주말이면 메인 메뉴 1개당 2023원 할인 받는다.")
    @Test
    public void applyWeekendDiscountAtWeekEnd() {
        // given
        Event event = new Event(ORDER_MENUS_CONTAIN_3_MAIN_MENU, WEEKEND);

        // when, then
        Assertions.assertThat(event.applyWeekendDiscount()).isEqualTo(3 * 2023);
    }

    @DisplayName("방문 날짜가 주말이 아니면 메인 메뉴를 할인받지 않는다.")
    @Test
    public void applyWeekendDiscountAtWeekDay() {
        // given
        Event event = new Event(ORDER_MENUS_CONTAIN_3_MAIN_MENU, WEEKDAY);

        // when, then
        Assertions.assertThat(event.applyWeekendDiscount()).isEqualTo(0);
    }

    @DisplayName("이벤트 달력에 별이 있으면 총 주문 금액에서 1000원을 할인 받는다.")
    @Test
    public void applySpecialDiscountAtStarDay() {
        // given
        Event event = new Event(ORDER_MENUS_SAMPLE, STAR_DAY);

        // when, then
        Assertions.assertThat(event.applySpecialDiscount()).isEqualTo(1000);
    }

    @DisplayName("이벤트 달력에 별이 없으면 총 주문 금액에서 1000원을 할인 받지 않는다.")
    @Test
    public void applySpecialDiscountAtNormalDay() {
        // given
        Event event = new Event(ORDER_MENUS_SAMPLE, NORMAL_DAY);

        // when, then
        Assertions.assertThat(event.applySpecialDiscount()).isEqualTo(0);
    }

}