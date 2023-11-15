package christmas.model;

import christmas.dto.EventResult;
import christmas.model.event.Event;
import christmas.model.event.FreegiftEvent;
import christmas.type.Badge;
import christmas.type.December;
import christmas.util.Formatter;

import java.util.List;

public class Events {

    private final OrderMenus orderMenus;
    private final December visitingDate;
    private boolean isEventApplicable = true;
    private final List<Event> events;

    public Events(OrderMenus orderMenus, December visitingDate, List<Event> events) {
        checkEventApplicable(orderMenus);
        this.orderMenus = orderMenus;
        this.visitingDate = visitingDate;
        this.events = events;
        applyEvents();
    }

    private void checkEventApplicable(OrderMenus orderMenus) {
        if (orderMenus.getTotalAmount() < 10000) {
            this.isEventApplicable = false;
        }
    }

    private void applyEvents() {
        if (isEventApplicable) {
            events.forEach(event -> event.apply(orderMenus, visitingDate));
        }
    }

    public String getBenefitFormatted() {
        String benefits = "";
        for (Event event : events) {
            benefits += event.toString();
        }
        if (benefits.equals("")) {
            return "없음\n";
        }
        return benefits;
    }

    public int getTotalDiscount() {
        int discount = 0;
        for (Event event : events) {
            discount += event.getDiscountAmount();
        }
        return discount;
    }

    public Badge offerBadge() {
        if (20000 < getTotalDiscount()) {
            return Badge.SANTA;
        }
        if (10000 < getTotalDiscount()) {
            return Badge.TREE;
        }
        if (5000 < getTotalDiscount()) {
            return Badge.STAR;
        }
        return Badge.NONE;
    }

    public String generateEventMessage() {
        return String.format("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", visitingDate.getDate());
    }

    public EventResult getEventResult() {
        FreegiftEvent freeGiftEvent = (FreegiftEvent) Event.getEventByName(events, "증정 이벤트");
        int totalAmountBefore = orderMenus.getTotalAmount();
        int amountToPay = totalAmountBefore - getTotalDiscount() + freeGiftEvent.getDiscountAmount();
        Badge badge = offerBadge();
        return new EventResult(
                generateEventMessage(),
                orderMenus.toString(),
                Formatter.formatMoney(orderMenus.getTotalAmount()),
                freeGiftEvent.getMenuAndNumberFormatted(),
                getBenefitFormatted(),
                Formatter.formatMoneyMinus(getTotalDiscount()),
                Formatter.formatMoney(amountToPay),
                badge.getName()
        );
    }

}

