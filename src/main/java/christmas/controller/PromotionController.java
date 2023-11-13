package christmas.controller;

import christmas.model.OrderMenus;
import christmas.type.December;
import christmas.type.PromptMessage;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionController {

    public static void Run() {
        OutputView.print(PromptMessage.INTRO);

        OutputView.print(PromptMessage.READ_VISITING_DATE);
        December visitingDate = December.of(InputView.readVisitingDate());

        OutputView.print(PromptMessage.READ_ORDER_MENUS);
        OrderMenus orderMenus = new OrderMenus(InputView.readOrderMenus());
    }

}
