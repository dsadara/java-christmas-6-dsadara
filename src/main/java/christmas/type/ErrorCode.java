package christmas.type;

public enum ErrorCode {
    INPUT_IS_NOT_NUMBER("문자가 아닌 숫자를 입력해 주세요.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
