package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;
import christmas.util.Formatter;

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

    @Override
    public String getName() {
        return "크리스마스 디데이 할인";
    }

    @Override
    public String toString() {
        if (isApplied) {
            return String.format("크리스마스 디데이 할인: %s\n", Formatter.formatMoneyMinus(discount));
        }
        return "";
    }

}
