package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;
import christmas.type.MenuType;

public class WeekdayEvent implements Event{

    private boolean isApplied;
    private int discount;

    public WeekdayEvent() {
        this.isApplied = false;
        this.discount = 0;
    }

    @Override
    public void apply(OrderMenus orderMenus, December visitingDate) {
        if (visitingDate.isWeekend()) {
            return;
        }
        isApplied = true;
        discount = orderMenus.getNumberByMenuType(MenuType.DESSERT) * 2023;
    }

    @Override
    public boolean isApplied() {
        return isApplied;
    }

    @Override
    public int getDiscountAmount() {
        return discount;
    }

}
