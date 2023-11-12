package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("방문 날짜 입력시 Integer를 반환한다.")
    @Test
    public void readVisitingDateReturnInteger() {
        // given
        System.setIn(createUserInput("20"));

        // when, then
        Assertions.assertThat(InputView.readVisitingDate())
                .isEqualTo(20);
    }

    @DisplayName("방문 날짜 입력시 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    public void readVisitingDateNotNumeric() {
        // given
        System.setIn(createUserInput("1A"));

        // when, then
        Assertions.assertThatThrownBy(InputView::readVisitingDate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}