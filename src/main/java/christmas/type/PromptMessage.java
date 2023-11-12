package christmas.type;

public enum PromptMessage {

    INTRO("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    READ_VISITING_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

    private final String content;

    PromptMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
