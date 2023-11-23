package christmas.type;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeTest {

    public static final int TOTAL_BENEFIT_AMOUNT_5000 = 5000;
    public static final int TOTAL_BENEFIT_AMOUNT_10000 = 10000;
    public static final int TOTAL_BENEFIT_AMOUNT_20000 = 20000;
    public static final int TOTAL_BENEFIT_AMOUNT_LESS_THAN_5000 = 4999;


    @DisplayName("총 혜택금액이 5000원 이상이면 별 배지를 부여한다.")
    @Test
    public void offerStar() {
        // when, then
        Assertions.assertThat(Badge.offer(TOTAL_BENEFIT_AMOUNT_5000)).isEqualTo(Badge.STAR);
    }

    @DisplayName("총 혜택금액이 10000원 이상이면 트리 배지를 부여한다.")
    @Test
    public void offerTree() {
        // when, then
        Assertions.assertThat(Badge.offer(TOTAL_BENEFIT_AMOUNT_10000)).isEqualTo(Badge.TREE);
    }

    @DisplayName("총 혜택금액이 20000원 이상이면 산타 배지를 부여한다.")
    @Test
    public void offerSanta() {
        // when, then
        Assertions.assertThat(Badge.offer(TOTAL_BENEFIT_AMOUNT_20000)).isEqualTo(Badge.SANTA);
    }

    @DisplayName("총 혜택금액이 5000원 미만이면 배지를 부여하지 않는다.")
    @Test
    public void offerNone() {
        // when, then
        Assertions.assertThat(Badge.offer(TOTAL_BENEFIT_AMOUNT_LESS_THAN_5000)).isEqualTo(Badge.NONE);
    }

}