package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("플레이어 테스트")
class PlayerTest {

    @Test
    @DisplayName("플레이어 초기화")
    void init() {
        assertThatCode(() -> Player.init("name")).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("플레이어 초기화 실패")
    void initException(final String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Player.init(name));
    }

    private static Stream<String> initException() {
        return Stream.of(
                "",
                null,
                "123456"
        );
    }
}