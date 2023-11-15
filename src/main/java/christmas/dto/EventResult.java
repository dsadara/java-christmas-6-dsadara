package christmas.dto;

import christmas.model.OrderMenus;
import christmas.type.Badge;
import christmas.type.December;
import christmas.type.Menu;

import static christmas.util.Formatter.formatMoney;

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
    private final December visitingDate;

    public EventResult(OrderMenus menus, int totalAmountBefore, int totalAmountAfter,
                       int christmasDiscount, int weekdayDiscount, int weekendDiscount,
                       int specialDiscount, int totalDiscount, Menu freeGift, Badge badge, December visitingDate) {
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
        this.visitingDate = visitingDate;
    }

    public static EventResult of(OrderMenus menus, int totalAmountBefore, int christmasDiscount,
                                 int weekDayDiscount, int weekendDiscount, int specialDiscount,
                                 Menu freeGift, December visitingDate) {
        int totalDiscount = christmasDiscount + weekDayDiscount + weekendDiscount + specialDiscount + freeGift.getPrice();
        int totalAmountAfter = totalAmountBefore - totalDiscount;
        Badge badge = Badge.offer(totalDiscount);

        return new EventResult(menus, totalAmountBefore, totalAmountAfter,
                christmasDiscount, weekDayDiscount, weekendDiscount,
                specialDiscount, totalDiscount, freeGift, badge, visitingDate);
    }

    private String getFormattedBenefit() {
        return "크리스마스 디데이 할인: -" + formatMoney(christmasDiscount) + "원\n" +
                "평일 할인: -" + formatMoney(weekdayDiscount) + "원\n" +
                "주말 할인: -" + formatMoney(weekendDiscount) + "원\n" +
                "특별 할인: -" + formatMoney(specialDiscount) + "원\n" +
                "증정 이벤트: -" + formatMoney(freeGift.getPrice()) + "원";
    }

    @Override
    public String toString() {
        return "12월 " + visitingDate.getDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" + "\n\n" +
                "<주문 메뉴>\n" + menus.toString() + "\n\n" +
                "<할인 전 총주문 금액>\n" + totalAmountBefore + "\n\n" +
                "<증정 메뉴>\n" + freeGift.getName() + " 1개\n\n" +
                "<혜택 내역>\n" + getFormattedBenefit() + "\n\n" +
                "<총혜택 금액>\n" + "-" + formatMoney(totalDiscount) + "\n\n" +
                "<할인 후 예상 결제 금액>\n" + formatMoney(totalAmountAfter) + "\n\n" +
                "<12월 이벤트 배지>\n" + badge.getName();
    }
}
