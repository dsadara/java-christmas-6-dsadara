package christmas.type;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static christmas.type.ErrorCode.*;

public enum December {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    SIXTH(6),
    SEVENTH(7),
    EIGHTH(8),
    NINTH(9),
    TENTH(10),
    ELEVENTH(11),
    TWELFTH(12),
    THIRTEENTH(13),
    FOURTEENTH(14),
    FIFTEENTH(15),
    SIXTEENTH(16),
    SEVENTEENTH(17),
    EIGHTEENTH(18),
    NINETEENTH(19),
    TWENTIETH(20),
    TWENTY_FIRST(21),
    TWENTY_SECOND(22),
    TWENTY_THIRD(23),
    TWENTY_FOURTH(24),
    TWENTY_FIFTH(25),
    TWENTY_SIXTH(26),
    TWENTY_SEVENTH(27),
    TWENTY_EIGHTH(28),
    TWENTY_NINTH(29),
    THIRTIETH(30),
    THIRTY_FIRST(31);

    private static final Map<Integer, December> DECEMBER_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                            .collect(Collectors.toMap(December::getDate, Function.identity())));

    private final int date;

    December(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public static December of(int date) {
        if (DECEMBER_MAP.containsKey(date)) {
            return DECEMBER_MAP.get(date);
        }
        throw new IllegalArgumentException(THERE_IS_NO_SUCH_DATE.getMessage());
    }

}