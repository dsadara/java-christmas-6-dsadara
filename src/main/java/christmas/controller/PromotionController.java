package christmas.controller;

import christmas.model.Order;
import christmas.model.OrderMenus;
import christmas.type.Message;
import christmas.view.OutputView;

import java.util.ArrayList;

public class PromotionController {

    public static void Run() {
        OutputView.print(Message.PROMOTION_INTRO);
        OutputView.print(Message.READ_VISIT_DATE);
        OrderMenus orderMenus = new OrderMenus(new ArrayList<>());
        Order order = new Order(orderMenus);
    }

}
