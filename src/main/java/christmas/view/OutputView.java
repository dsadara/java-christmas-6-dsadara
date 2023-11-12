package christmas.view;

import christmas.type.Message;

public class OutputView {

    public static void print(Message message) {
        System.out.println(message.getContent());
    }

}
