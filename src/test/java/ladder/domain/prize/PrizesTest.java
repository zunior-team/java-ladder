package ladder.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static ladder.util.Static.PRIZES_STRS;
import static org.assertj.core.api.Assertions.*;

@DisplayName("상품 목록 테스트")
class PrizesTest {
    private static final Prizes PRIZES = Prizes.init(PRIZES_STRS);

    @Test
    @DisplayName("초기화")
    void init() {
        assertThatCode(() -> Prizes.init(PRIZES_STRS))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("초기화 실패 : null 이거나 비어있거나")
    void initFail(final List<String> names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Prizes.init(names));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("상품 이름 가져오기")
    void getPlayerName(final int index, final String expected) {
        assertThat(PRIZES.getPrize(index)).isEqualTo(expected);
    }

    private static Stream<Arguments> getPlayerName() {
        return Stream.of(
                Arguments.of(0, "prize1"),
                Arguments.of(1, "prize2"),
                Arguments.of(2, "prize3"),
                Arguments.of(3, "prize4"),
                Arguments.of(4, "prize5")
        );
    }

    @Test
    @DisplayName("모든 상품 이름 가져오기")
    void getPlayersName() {
        assertThat(PRIZES.getPrizes()).isEqualTo(PRIZES_STRS);
    }

}