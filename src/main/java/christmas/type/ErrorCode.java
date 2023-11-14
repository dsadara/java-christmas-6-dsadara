package christmas.type;

public enum ErrorCode {
    INPUT_IS_NOT_NUMBER("[ERROR] 문자가 아닌 숫자를 입력해 주세요. 다시 입력해 주세요."),
    THERE_IS_NO_SUCH_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    CANNOT_ORDER_ONLY_DRINKS("[ERROR] 음료만 주문 시, 주문할 수 없습니다."),
    ORDER_MENU_NUMBER_LIMIT_IS_20("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}