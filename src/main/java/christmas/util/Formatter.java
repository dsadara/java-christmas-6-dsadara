package christmas.util;

import java.text.DecimalFormat;

public class Formatter {

    private static final DecimalFormat moneyFormatter = new DecimalFormat("###,###,###,###");

    public static String formatMoney(int money) {
        return moneyFormatter.format(money);
    }

}
