package christmas.dto;

import christmas.model.OrderMenus;
import christmas.type.Badge;
import christmas.type.Menu;

public class EventResult {

    private final OrderMenus menus;
    private final int totalAmountBefore;
    private final int totalAmountAfter;
    private final int christmasDiscount;
    private final int weekdayDiscount;
    private final int weekendDiscount;
    private final int specialDiscount;
    private final int totalDiscount;
    private final Menu freeGift;
    private final Badge badge;

    public EventResult(OrderMenus menus, int totalAmountBefore, int totalAmountAfter,
                       int christmasDiscount, int weekdayDiscount, int weekendDiscount,
                       int specialDiscount, int totalDiscount, Menu freeGift, Badge badge) {
        this.menus = menus;
        this.totalAmountBefore = totalAmountBefore;
        this.totalAmountAfter = totalAmountAfter;
        this.christmasDiscount = christmasDiscount;
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
        this.specialDiscount = specialDiscount;
        this.totalDiscount = totalDiscount;
        this.freeGift = freeGift;
        this.badge = badge;
    }

    public static EventResult of(OrderMenus menus, int totalAmountBefore, int christmasDiscount,
                                 int weekDayDiscount, int weekendDiscount, int specialDiscount, Menu freeGift) {
        int totalDiscount = christmasDiscount + weekDayDiscount + weekendDiscount + specialDiscount + freeGift.getPrice();
        int totalAmountAfter = totalAmountBefore - totalDiscount;
        Badge badge = Badge.offer(totalDiscount);

        return new EventResult(menus, totalAmountBefore, totalAmountAfter,
                christmasDiscount, weekDayDiscount, weekendDiscount,
                specialDiscount, totalDiscount, freeGift, badge);
    }

}
