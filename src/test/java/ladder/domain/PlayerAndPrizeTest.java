package ladder.domain;

import ladder.domain.init.PlayerAndPrizeInitInfo;
import ladder.domain.ladder.LadderTakeResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static ladder.util.Static.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("플레이어와 상품간의 매치 테스트")
class PlayerAndPrizeTest {
    private static final PlayerAndPrizeInitInfo PLAYER_AND_PRIZE_INIT_INFO =
            PlayerAndPrizeInitInfo.init(NAMES, PRIZES_STRS);
    private static final PlayerAndPrize PLAYER_AND_PRIZE = PlayerAndPrize.init(PLAYER_AND_PRIZE_INIT_INFO);

    @Test
    @DisplayName("초기화")
    void init() {
        assertThatCode(() -> PlayerAndPrize.init(PLAYER_AND_PRIZE_INIT_INFO))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("초기화 실패 : null 일때")
    void initFailWithNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PlayerAndPrize.init(null));
    }

    @Test
    @DisplayName("플레이어 목록 가져오기")
    void getPlayers() {
        assertThat(PLAYER_AND_PRIZE.getPlayers()).isEqualTo(NAMES);
    }

    @Test
    @DisplayName("상품 목록 가져오기")
    void getPrizes() {
        assertThat(PLAYER_AND_PRIZE.getPrizes()).isEqualTo(PRIZES_STRS);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("사용자와 상품간의 매치 테스트")
    void match(final LadderTakeResult ladderTakeResult,
               final String playerName,
               final String expectedPrize) {
        Map<String, String> matchResult = PLAYER_AND_PRIZE.matchPlayerAndPrize(ladderTakeResult);

        assertThat(matchResult.get(playerName)).isEqualTo(expectedPrize);
    }

    private static Stream<Arguments> match() {
        LadderTakeResult ladderTakeResult = LadderTakeResult.init(Arrays.asList(4, 3, 2, 1, 0));

        return Stream.of(
                Arguments.of(ladderTakeResult, "name1", "prize5"),
                Arguments.of(ladderTakeResult, "name2", "prize4"),
                Arguments.of(ladderTakeResult, "name3", "prize3"),
                Arguments.of(ladderTakeResult, "name4", "prize2"),
                Arguments.of(ladderTakeResult, "name5", "prize1")
        );
    }
}
