package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static ladder.util.Static.NAMES;
import static org.assertj.core.api.Assertions.*;

@DisplayName("플레이어 집단 테스트")
class PlayersTest {
    private static final Players PLAYERS = Players.init(NAMES);

    @Test
    @DisplayName("초기화")
    void init() {
        assertThatCode(() -> Players.init(NAMES))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("초기화 실패 : null 이거나 비어있거나")
    void initFail(final List<String> names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Players.init(names));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("플레이어 이름 가져오기")
    void getPlayerName(final int index, final String expected) {
        assertThat(PLAYERS.getPlayerName(index)).isEqualTo(expected);
    }

    private static Stream<Arguments> getPlayerName() {
        return Stream.of(
                Arguments.of(0, "name1"),
                Arguments.of(1, "name2"),
                Arguments.of(2, "name3"),
                Arguments.of(3, "name4"),
                Arguments.of(4, "name5")
        );
    }

    @Test
    @DisplayName("모든 플레이어 이름 가져오기")
    void getPlayersName() {
        assertThat(PLAYERS.getPlayersName()).isEqualTo(NAMES);
    }

}
