package christmas.type;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static christmas.type.ErrorCode.THERE_IS_NO_SUCH_DATE;

public enum December {
    FIRST(1, true, false),
    SECOND(2, true, false),
    THIRD(3, false, true),
    FOURTH(4, false, false),
    FIFTH(5, false, false),
    SIXTH(6, false, false),
    SEVENTH(7, false, false),
    EIGHTH(8, true, false),
    NINTH(9, true, false),
    TENTH(10, false, true),
    ELEVENTH(11, false, false),
    TWELFTH(12, false, false),
    THIRTEENTH(13, false, false),
    FOURTEENTH(14, false, false),
    FIFTEENTH(15, true, false),
    SIXTEENTH(16, true, false),
    SEVENTEENTH(17, false, true),
    EIGHTEENTH(18, false, false),
    NINETEENTH(19, false, false),
    TWENTIETH(20, false, false),
    TWENTY_FIRST(21, false, false),
    TWENTY_SECOND(22, true, false),
    TWENTY_THIRD(23, true, false),
    TWENTY_FOURTH(24, false, true),
    TWENTY_FIFTH(25, false, true),
    TWENTY_SIXTH(26, false, false),
    TWENTY_SEVENTH(27, false, false),
    TWENTY_EIGHTH(28, false, false),
    TWENTY_NINTH(29, true, false),
    THIRTIETH(30, true, false),
    THIRTY_FIRST(31, false, true);

    private static final Map<Integer, December> DECEMBER_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                            .collect(Collectors.toMap(December::getDate, Function.identity())));

    private final int date;
    private final boolean isWeekend;
    private final boolean isStar;

    December(int date, boolean isWeekend, boolean isStar) {
        this.date = date;
        this.isWeekend = isWeekend;
        this.isStar = isStar;
    }

    public static December of(int date) {
        if (DECEMBER_MAP.containsKey(date)) {
            return DECEMBER_MAP.get(date);
        }
        throw new IllegalArgumentException(THERE_IS_NO_SUCH_DATE.getMessage());
    }

    public int getDate() {
        return date;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public boolean isStar() {
        return isStar;
    }

}