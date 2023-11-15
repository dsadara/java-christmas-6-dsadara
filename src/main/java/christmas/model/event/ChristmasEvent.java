package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;

public class ChristmasEvent implements Event{

    private boolean isApplied;
    private int discount;

    public ChristmasEvent() {
        this.isApplied = false;
        this.discount = 0;
    }

    @Override
    public void apply(OrderMenus orderMenus, December visitingDate) {
        if (25 < visitingDate.getDate()) {
            return;
        }
        discount = 1000 + 100 * (visitingDate.getDate() - 1);
        isApplied = true;
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
