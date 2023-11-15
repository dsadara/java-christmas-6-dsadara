package christmas.model;

import christmas.dto.EventResult;
import christmas.model.event.Event;
import christmas.type.December;

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
        events.forEach(event -> event.apply(orderMenus, visitingDate));
    }

    public EventResult getEventResult() {
        return null;
    }

}

