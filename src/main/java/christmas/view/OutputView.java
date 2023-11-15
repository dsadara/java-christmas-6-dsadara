package christmas.view;

import christmas.dto.EventResult;
import christmas.type.PromptMessage;

public class OutputView {

    public static void print(PromptMessage promptMessage) {
        System.out.println(promptMessage.getContent());
    }

    public static void print(EventResult eventResult) {
        System.out.println(eventResult.toString());
    }

}
