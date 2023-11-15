package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;

import java.util.List;

public interface Event {
    void apply(OrderMenus orderMenus, December visitingDate);
    boolean isApplied();
    int getDiscountAmount();

    static List<Event> getDecemberEvents() {
        return List.of(new ChristmasEvent(), new WeekdayEvent(), new WeekendEvent(),
                new FreegiftEvent(), new SpecialEvent());
    }
}
