package christmas.type;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static christmas.type.ErrorCode.THERE_IS_NO_SUCH_DATE;

public enum December {
    FIRST(1, true),
    SECOND(2, true),
    THIRD(3, false),
    FOURTH(4, false),
    FIFTH(5, false),
    SIXTH(6, false),
    SEVENTH(7, false),
    EIGHTH(8, true),
    NINTH(9, true),
    TENTH(10, false),
    ELEVENTH(11, false),
    TWELFTH(12, false),
    THIRTEENTH(13, false),
    FOURTEENTH(14, false),
    FIFTEENTH(15, true),
    SIXTEENTH(16, true),
    SEVENTEENTH(17, false),
    EIGHTEENTH(18, false),
    NINETEENTH(19, false),
    TWENTIETH(20, false),
    TWENTY_FIRST(21, false),
    TWENTY_SECOND(22, true),
    TWENTY_THIRD(23, true),
    TWENTY_FOURTH(24, false),
    TWENTY_FIFTH(25, false),
    TWENTY_SIXTH(26, false),
    TWENTY_SEVENTH(27, false),
    TWENTY_EIGHTH(28, false),
    TWENTY_NINTH(29, true),
    THIRTIETH(30, true),
    THIRTY_FIRST(31, false);

    private static final Map<Integer, December> DECEMBER_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                            .collect(Collectors.toMap(December::getDate, Function.identity())));

    private final int date;
    private final boolean isWeekend;

    December(int date, boolean isWeekend) {
        this.date = date;
        this.isWeekend = isWeekend;
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

}