package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;
import christmas.type.Menu;

import static christmas.type.Menu.CHAMPAGNE;
import static christmas.type.Menu.NONE;

public class FreegiftEvent implements Event{

    private boolean isApplied;
    private Menu freeGift;
    private int numberOfGift;

    public FreegiftEvent() {
        this.isApplied = false;
        this.freeGift = NONE;
        this.numberOfGift = 0;
    }

    @Override
    public void apply(OrderMenus orderMenus, December visitingDate) {
        if (orderMenus.getTotalAmount() < 120_000) {
            return;
        }
        isApplied = true;
        freeGift = CHAMPAGNE;
        numberOfGift = 1;
    }

    @Override
    public boolean isApplied() {
        return isApplied;
    }

    @Override
    public int getDiscountAmount() {
        return freeGift.getPrice() * numberOfGift;
    }

    public Menu getFreeGift() {
        return freeGift;
    }

}
