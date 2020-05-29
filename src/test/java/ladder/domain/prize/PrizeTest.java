package ladder.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("상품 테스트")
class PrizeTest {

    @Test
    @DisplayName("초기화")
    void init() {
        assertThatCode(() -> Prize.init("prize"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("초기화 실패 : null 이거나 빈값이거나")
    void initFail(final String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Prize.init(name));
    }

}