package christmas.model;

import christmas.type.December;
import christmas.type.Menu;

public class Event {

    private final OrderMenus orderMenus;
    private final December visitingDate;
    private boolean isEventApplicable = true;
    private Menu freeGift;

    public Event(OrderMenus orderMenus, December visitingDate) {
        checkEventApplicable(orderMenus);
        this.orderMenus = orderMenus;
        this.visitingDate = visitingDate;
    }

    private void checkEventApplicable(OrderMenus orderMenus) {
        if (orderMenus.getTotalAmount() < 10000) {
            this.isEventApplicable = false;
        }
    }

    public int applyChristmasDiscount() {
        if (25 < visitingDate.getDate()) {
            return 0;
        }
        return 1000 + 100 * (visitingDate.getDate() - 1);
    }



}
