package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.type.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;


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

    @DisplayName("주문할 메뉴와 개수를 입력하면 메뉴 리스트를 반환한다.")
    @Test
    public void readOrderMenusReturnMenuList() {
        // given
        System.setIn(createUserInput("해산물파스타-2,레드와인-1,초코케이크-1"));

        // when
        List<Menu> menus = InputView.readOrderMenus();

        // then
        Assertions.assertThat(menus.get(0)).isEqualTo(Menu.SEAFOOD_PASTA);
        Assertions.assertThat(menus.get(1)).isEqualTo(Menu.SEAFOOD_PASTA);
        Assertions.assertThat(menus.get(2)).isEqualTo(Menu.REDWINE);
        Assertions.assertThat(menus.get(3)).isEqualTo(Menu.CHOCO_CAKE);
    }

    @DisplayName("없는 메뉴를 주문하면 에러가 발생한다.")
    @Test
    public void readOrderMenusByMenuNotExist() {
        // given
        System.setIn(createUserInput("없는메뉴-2"));

        // when, then
        Assertions.assertThatThrownBy(InputView::readOrderMenus)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 메뉴를 입력했는지 검증한다.")
    @Test
    public void readOrderMenusByDuplicateMenu() {
        //given
        System.setIn(createUserInput("시저샐러드-1,시저샐러드-1"));

        // when, then
        Assertions.assertThatThrownBy(InputView::readOrderMenus)
                .isInstanceOf(IllegalArgumentException.class);

    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}