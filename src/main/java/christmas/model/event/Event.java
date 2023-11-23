package christmas.model.event;

import christmas.model.OrderMenus;
import christmas.type.December;

import java.util.List;

public interface Event {

    void apply(OrderMenus orderMenus, December visitingDate);
    boolean isApplied();
    int getDiscountAmount();
    String getName();

    static List<Event> getDecemberEvents() {
        return List.of(new ChristmasEvent(), new WeekdayEvent(), new WeekendEvent(),
                new SpecialEvent(), new FreegiftEvent());
    }

    static Event getEventByName(List<Event> events, String name) {
        return events.stream()
                .filter(event -> event.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
