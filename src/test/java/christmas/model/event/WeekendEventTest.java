package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;
import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class WeekendEventTest {

    public static final OrderMenus ORDER_MENUS_CONTAIN_3_MAIN_MENU = new OrderMenus(Map.of(Menu.T_BONE_STEAK, 3));
    public static final December WEEKDAY = December.FOURTH;
    public static final December WEEKEND = December.FIRST;

    @DisplayName("방문 날짜가 주말이면 메인 메뉴 1개당 2023원 할인 받는다.")
    @Test
    public void WeekendEventAtWeekEnd() {
        // given
        WeekendEvent weekendEvent = new WeekendEvent();

        // when
        weekendEvent.apply(ORDER_MENUS_CONTAIN_3_MAIN_MENU, WEEKEND);

        // then
        Assertions.assertThat(weekendEvent.isApplied()).isTrue();
        Assertions.assertThat(weekendEvent.getDiscountAmount()).isEqualTo(3 * 2023);
    }

    @DisplayName("방문 날짜가 주말이 아니면 메인 메뉴를 할인받지 않는다.")
    @Test
    public void WeekendEventAtWeekDay() {
        // given
        WeekendEvent weekendEvent = new WeekendEvent();

        // when
        weekendEvent.apply(ORDER_MENUS_CONTAIN_3_MAIN_MENU, WEEKDAY);

        // then
        Assertions.assertThat(weekendEvent.isApplied()).isFalse();
        Assertions.assertThat(weekendEvent.getDiscountAmount()).isEqualTo(0);
    }

}