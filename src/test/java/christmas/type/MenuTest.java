package christmas.type;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("메뉴 타입에 해당하는 메뉴들을 찾아서 리스트로 반환한다.")
    @Test
    public void getMenusReturnValidMenus() {
        // when, then
        Assertions.assertThat(Menu.getMenusByMenuType(MenuType.DRINK))
                .containsExactlyInAnyOrder(Menu.CHAMPAGNE, Menu.REDWINE, Menu.ZERO_COLA);
    }

    @DisplayName("메뉴 타입에 해당하지 않는 메뉴들은 리스트로 반환하지 않는다.")
    @Test
    public void getMenusNotReturnInvalidMenus() {
        // when, then
        Assertions.assertThat(Menu.getMenusByMenuType(MenuType.DRINK))
                .doesNotContain(Menu.ICECREAM, Menu.BBQ_RIB);
    }

}