package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;
import christmas.util.Formatter;

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

    @Override
    public String toString() {
        if (isApplied) {
            return String.format("특별 할인: -%s원", Formatter.formatMoney(discount));
        }
        return "";
    }

}
