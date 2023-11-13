package christmas.type;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DecemberTest {

    @DisplayName("방문날짜가 1이상 31이하가 아니면 에러가 발생한다.")
    @Test
    public void of_InvalidDate() {
        // given
        int invalidDate = 40;

        // when, then
        Assertions.assertThatThrownBy(() -> December.of(invalidDate))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문날짜가 1이상 31이하이면 에러가 발생하지 않는다.")
    @Test
    public void of_ValidDate() {
        // given
        int validDate = 31;

        // when, then
        Assertions.assertThat(December.of(validDate)).isEqualTo(December.THIRTY_FIRST);
    }

}