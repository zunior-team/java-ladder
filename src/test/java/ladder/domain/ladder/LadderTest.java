package ladder.domain.ladder;

import ladder.domain.init.LadderInitInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static ladder.util.Static.LADDER_INIT_INFO_WITH_TRUE_STRATEGY;
import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 객체 테스트")
class LadderTest {

    @Test
    @DisplayName("초기화 : 성공")
    void init() {
        assertThatCode(() -> Ladder.init(LADDER_INIT_INFO_WITH_TRUE_STRATEGY))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("초기화 : 성공후 사다리 높이가 정확한지")
    void height() {
        int height = 5;
        LadderInitInfo ladderInitInfo = LadderInitInfo.init(height, 1);
        Ladder ladder = Ladder.init(ladderInitInfo);

        assertThat(ladder.getSteps()).hasSize(height);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("초기화 실패 : null로 인한 초기화 실패")
    void initFail(final LadderInitInfo ladderInitInfo) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.init(ladderInitInfo));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("초기화 실패 : 사다리 높이가 음수")
    void initFailWithNegativeHeight(final int height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.init(LadderInitInfo.init(height, 1)));
    }
}