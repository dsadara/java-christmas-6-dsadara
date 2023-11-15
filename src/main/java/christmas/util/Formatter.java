package christmas.util;

import java.text.DecimalFormat;

public class Formatter {

    private static final DecimalFormat moneyFormatter = new DecimalFormat("###,###,###,###");

    public static String formatMoney(int money) {
        return moneyFormatter.format(money) + "원";
    }

    public static String formatMoneyMinus(int money) {
        if (money == 0) {
            return moneyFormatter.format(money) + "원";
        }
        return "-" + moneyFormatter.format(money) + "원";
    }

}
