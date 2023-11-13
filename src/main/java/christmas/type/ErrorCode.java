package christmas.type;

public enum ErrorCode {
    INPUT_IS_NOT_NUMBER("문자가 아닌 숫자를 입력해 주세요."),

    THERE_IS_NO_SUCH_DATE("유효하지 않은 날짜입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
