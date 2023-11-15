package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;

public class SpecialEvent implements Event{

    private boolean isApplied;
    private int discount;

    public SpecialEvent() {
        this.isApplied = false;
        this.discount = 0;
    }

    @Override
    public void apply(OrderMenus orderMenus, December visitingDate) {
        if (!visitingDate.isStar()) {
            return;
        }
        isApplied = true;
        discount = 1000;
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
