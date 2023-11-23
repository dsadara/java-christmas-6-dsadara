package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;
import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class SpecialEventTest {

    public static final OrderMenus ORDER_MENUS_SAMPLE = new OrderMenus(Map.of(Menu.T_BONE_STEAK, 3));
    public static final December STAR_DAY = December.THIRD;
    public static final December NORMAL_DAY = December.FOURTH;


    @DisplayName("이벤트 달력에 별이 있으면 총 주문 금액에서 1000원을 할인 받는다.")
    @Test
    public void SpecialEventAtStarDay() {
        // given
        SpecialEvent specialEvent = new SpecialEvent();

        // when
        specialEvent.apply(ORDER_MENUS_SAMPLE, STAR_DAY);

        // then
        Assertions.assertThat(specialEvent.isApplied()).isTrue();
        Assertions.assertThat(specialEvent.getDiscountAmount()).isEqualTo(1000);
    }

    @DisplayName("이벤트 달력에 별이 없으면 총 주문 금액에서 1000원을 할인 받지 않는다.")
    @Test
    public void SpecialEventAtNormalDay() {
        // given
        SpecialEvent specialEvent = new SpecialEvent();

        // when
        specialEvent.apply(ORDER_MENUS_SAMPLE, NORMAL_DAY);

        // then
        Assertions.assertThat(specialEvent.isApplied()).isFalse();
        Assertions.assertThat(specialEvent.getDiscountAmount()).isEqualTo(0);
    }

    @DisplayName("특별 이벤트 할인금액을 출력한다.")
    @Test
    public void SpecialEvent_toString() {
        // given
        SpecialEvent specialEvent = new SpecialEvent();

        // when
        specialEvent.apply(ORDER_MENUS_SAMPLE, STAR_DAY);

        // then
        Assertions.assertThat(specialEvent.toString()).isEqualTo("특별 할인: -1,000원\n");
    }

    @DisplayName("특별 이벤트 할인 이벤트가 적용되지 않으면 할인금액을 출력하지 않는다.")
    @Test
    public void SpecialEvent_toString_NotApplied() {
        // given
        SpecialEvent specialEvent = new SpecialEvent();

        // when
        specialEvent.apply(ORDER_MENUS_SAMPLE, NORMAL_DAY);

        // then
        Assertions.assertThat(specialEvent.toString()).isEqualTo("");
    }

}