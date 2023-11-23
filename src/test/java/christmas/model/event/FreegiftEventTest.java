package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;
import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class FreegiftEventTest {

    public static final OrderMenus ORDER_MENUS_TOTAL_AMOUNT_IS_MORE_THAN_120_000 = new OrderMenus(Map.of(Menu.T_BONE_STEAK, 3));
    public static final OrderMenus ORDER_MENUS_TOTAL_AMOUNT_IS_LESS_THAN_120_000 = new OrderMenus(Map.of(Menu.T_BONE_STEAK, 2));
    public static final December NORMAL_DAY = December.FOURTH;

    @DisplayName("할인 전 총주문 금액이 12만 원 이상일 때 샴페인 1개를 증정한다.")
    @Test
    public void FreegiftEventOffered() {
        // given
        FreegiftEvent freegiftEvent = new FreegiftEvent();

        // when
        freegiftEvent.apply(ORDER_MENUS_TOTAL_AMOUNT_IS_MORE_THAN_120_000, NORMAL_DAY);

        // then
        Assertions.assertThat(freegiftEvent.isApplied()).isTrue();
        Assertions.assertThat(freegiftEvent.getFreeGift()).isEqualTo(Menu.CHAMPAGNE);
        Assertions.assertThat(freegiftEvent.getDiscountAmount()).isEqualTo(Menu.CHAMPAGNE.getPrice());
    }

    @DisplayName("할인 전 총주문 금액이 12만 원 미만일 때 샴페인 1개를 증정하지 않는다.")
    @Test
    public void FreegiftEventNotOffered() {
        // given
        FreegiftEvent freegiftEvent = new FreegiftEvent();

        // when
        freegiftEvent.apply(ORDER_MENUS_TOTAL_AMOUNT_IS_LESS_THAN_120_000, NORMAL_DAY);

        // then
        Assertions.assertThat(freegiftEvent.isApplied()).isFalse();
        Assertions.assertThat(freegiftEvent.getFreeGift()).isEqualTo(Menu.NONE);
        Assertions.assertThat(freegiftEvent.getDiscountAmount()).isEqualTo(0);
    }

    @DisplayName("증정 이벤트 할인금액을 출력한다.")
    @Test
    public void FreegiftEvent_toString() {
        // given
        FreegiftEvent freegiftEvent = new FreegiftEvent();

        // when
        freegiftEvent.apply(ORDER_MENUS_TOTAL_AMOUNT_IS_MORE_THAN_120_000, NORMAL_DAY);

        // then
        Assertions.assertThat(freegiftEvent.toString()).isEqualTo("증정 이벤트: -25,000원\n");
    }

    @DisplayName("증정 이벤트 할인 이벤트가 적용되지 않으면 할인금액을 출력하지 않는다.")
    @Test
    public void FreegiftEvent_toString_NotApplied() {
        // given
        FreegiftEvent freegiftEvent = new FreegiftEvent();

        // when
        freegiftEvent.apply(ORDER_MENUS_TOTAL_AMOUNT_IS_LESS_THAN_120_000, NORMAL_DAY);

        // then
        Assertions.assertThat(freegiftEvent.toString()).isEqualTo("");
    }

}