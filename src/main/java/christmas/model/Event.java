package christmas.model;

import christmas.type.December;
import christmas.type.Menu;
import christmas.type.MenuType;

public class Event {

    private final OrderMenus orderMenus;
    private final December visitingDate;
    private boolean isEventApplicable = true;

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

    public int applyWeekDayDiscount() {
        if (visitingDate.isWeekend()) {
            return 0;
        }
        return orderMenus.getNumberByMenuType(MenuType.DESSERT) * 2023;
    }

    public int applyWeekendDiscount() {
        if (!visitingDate.isWeekend()) {
            return 0;
        }
        return orderMenus.getNumberByMenuType(MenuType.MAIN) * 2023;
    }

    public int applySpecialDiscount() {
        if (!visitingDate.isStar()) {
            return 0;
        }
        return 1000;
    }

    public Menu offerFreeGift() {
        if (120_000 <= orderMenus.getTotalAmount()) {
            return Menu.CHAMPAGNE;
        }
        return Menu.NONE;
    }

}
