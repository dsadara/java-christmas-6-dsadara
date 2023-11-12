package christmas.controller;

import christmas.model.Order;
import christmas.model.OrderMenus;

import java.util.ArrayList;

public class PromotionController {

    public static void Run() {
        OrderMenus orderMenus = new OrderMenus(new ArrayList<>());
        Order order = new Order(orderMenus);
    }

}
