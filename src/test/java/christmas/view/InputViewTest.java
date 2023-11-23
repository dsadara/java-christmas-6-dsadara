package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

class InputViewTest{

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

    @DisplayName("주문할 메뉴와 개수를 입력하면 메뉴 리스트를 반환한다.")
    @Test
    public void readOrderMenusReturnMenuList() {
        // given
        System.setIn(createUserInput("해산물파스타-2,레드와인-1,초코케이크-1"));

        // when
        Map<Menu, Integer> menus = InputView.readOrderMenus();

        // then
        Assertions.assertThat(menus.get(Menu.SEAFOOD_PASTA)).isEqualTo(2);
        Assertions.assertThat(menus.get(Menu.REDWINE)).isEqualTo(1);
        Assertions.assertThat(menus.get(Menu.CHOCO_CAKE)).isEqualTo(1);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}