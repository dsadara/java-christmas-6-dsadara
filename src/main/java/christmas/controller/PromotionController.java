package christmas.controller;

import christmas.model.OrderMenus;
import christmas.type.PromptMessage;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;

public class PromotionController {

    public static void Run() {
        OutputView.print(PromptMessage.INTRO);
        OutputView.print(PromptMessage.READ_VISITING_DATE);
        int date = InputView.readVisitingDate();
        OrderMenus orderMenus = new OrderMenus(new ArrayList<>());
    }

}
