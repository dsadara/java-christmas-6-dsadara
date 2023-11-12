package christmas.view;

import christmas.type.PromptMessage;

public class OutputView {

    public static void print(PromptMessage promptMessage) {
        System.out.println(promptMessage.getContent());
    }

}
