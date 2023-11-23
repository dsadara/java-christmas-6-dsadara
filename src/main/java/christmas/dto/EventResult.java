package christmas.dto;

public class EventResult {
    String eventMessage;
    String orderMenus;
    String totalAmountBefore;
    String freeGift;
    String benefits;
    String totalBenefit;
    String amountToPay;
    String badgeName;

    public EventResult(String eventMessage, String orderMenus, String totalAmountBefore,
                       String freeGift, String benefits,
                       String totalBenefit, String amountToPay, String badge) {
        this.eventMessage = eventMessage;
        this.orderMenus = orderMenus;
        this.totalAmountBefore = totalAmountBefore;
        this.freeGift = freeGift;
        this.benefits = benefits;
        this.totalBenefit = totalBenefit;
        this.amountToPay = amountToPay;
        this.badgeName = badge;
    }

    @Override
    public String toString() {
        return eventMessage + "\n\n" +
                "<주문 메뉴>" + "\n" +
                orderMenus + "\n\n" +
                "<할인 전 총주문 금액>" + "\n" +
                totalAmountBefore + "\n\n" +
                "<증정 메뉴>" + "\n" +
                freeGift + "\n\n" +
                "<혜택 내역>" + "\n" +
                benefits + "\n" +
                "<총혜택 금액>" + "\n" +
                totalBenefit + "\n\n" +
                "<할인 후 예상 결제 금액>" + "\n" +
                amountToPay + "\n\n" +
                "<12월 이벤트 배지>" + "\n" +
                badgeName;
    }

}
