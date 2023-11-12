package christmas.model;

public class Order {

    private final OrderMenus orderMenus;

    public Order(OrderMenus orderMenus) {
        this.orderMenus = orderMenus;
    }

    public boolean isEventApplicable() {
        return orderMenus.getPriceSum() >= 10000;
    }

}