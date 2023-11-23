package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;
import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class WeekdayEventTest {

    public static final OrderMenus ORDER_MENUS_CONTAIN_3_DESERT = new OrderMenus(Map.of(Menu.ICECREAM, 3));
    public static final December WEEKDAY = December.FOURTH;
    public static final December WEEKEND = December.FIRST;

    @DisplayName("방문 날짜가 평일이면 디저트 메뉴를 1개당 2023원 할인 받는다.")
    @Test
    public void WeekDayEventAtWeekDay() {
        // given
        WeekdayEvent weekdayEvent = new WeekdayEvent();

        // when
        weekdayEvent.apply(ORDER_MENUS_CONTAIN_3_DESERT, WEEKDAY);

        // then
        Assertions.assertThat(weekdayEvent.isApplied()).isTrue();
        Assertions.assertThat(weekdayEvent.getDiscountAmount()).isEqualTo(3 * 2023);
    }

    @DisplayName("방문 날짜가 평일이 아니면 디저트 메뉴를 할인받지 않는다.")
    @Test
    public void WeekDayEventAtWeekend() {
        // given
        WeekdayEvent weekdayEvent = new WeekdayEvent();

        // when
        weekdayEvent.apply(ORDER_MENUS_CONTAIN_3_DESERT, WEEKEND);

        // when, then
        Assertions.assertThat(weekdayEvent.isApplied()).isFalse();
        Assertions.assertThat(weekdayEvent.getDiscountAmount()).isEqualTo(0);
    }

    @DisplayName("평일 이벤트 할인금액을 출력한다.")
    @Test
    public void WeekdayEvent_toString() {
        // given
        WeekdayEvent weekdayEvent = new WeekdayEvent();

        // when
        weekdayEvent.apply(ORDER_MENUS_CONTAIN_3_DESERT, WEEKDAY);

        // then
        Assertions.assertThat(weekdayEvent.toString()).isEqualTo("평일 할인: -6,069원\n");
    }

    @DisplayName("평일 이벤트 할인 이벤트가 적용되지 않으면 할인금액을 출력하지 않는다.")
    @Test
    public void WeekdayEvent_toString_NotApplied() {
        // given
        WeekdayEvent weekdayEvent = new WeekdayEvent();

        // when
        weekdayEvent.apply(ORDER_MENUS_CONTAIN_3_DESERT, WEEKEND);

        // then
        Assertions.assertThat(weekdayEvent.toString()).isEqualTo("");
    }

}