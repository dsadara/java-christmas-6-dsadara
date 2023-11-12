package christmas.model;

import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class OrderTest {
    @DisplayName("총주문 금액 10,000원 미만이면 이벤트가 적용되지 않는다.")
    @Test
    public void isEventApplicableFalse() {
        //given
        OrderMenus orderMenus = new OrderMenus(List.of(Menu.아이스크림));
        Order order = new Order(orderMenus);
        //when
        //then
        Assertions.assertThat(order.isEventApplicable()).isFalse();
    }

    @DisplayName("총주문 금액 10,000원 이상이면 이벤트가 적용된다.")
    @Test
    public void isEventApplicableTrueEdgeCase() {
        //given
        OrderMenus orderMenus = new OrderMenus(List.of(Menu.아이스크림, Menu.아이스크림));
        Order order = new Order(orderMenus);
        //when
        //then
        Assertions.assertThat(order.isEventApplicable()).isTrue();
    }
}