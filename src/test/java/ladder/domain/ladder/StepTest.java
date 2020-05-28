package ladder.domain.ladder;

import ladder.domain.init.LadderInitInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 한 스텝(한 단) 테스트")
class StepTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("초기화")
    void init(final LadderInitInfo ladderInitInfo, final int expectedWidth) {
        assertThatCode(() -> Step.init(ladderInitInfo)).doesNotThrowAnyException();
        assertThat(Step.init(ladderInitInfo).toFootSteps()).hasSize(expectedWidth);
    }

    private static Stream<Arguments> init() {
        int height = 1;
        return Stream.of(
                Arguments.of(LadderInitInfo.init(height, 1), 1),
                Arguments.of(LadderInitInfo.init(height, 2), 2),
                Arguments.of(LadderInitInfo.init(height, 3), 3),
                Arguments.of(LadderInitInfo.init(height, 4), 4)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("초기화 실패 : 높이나 너비 값이 비정상적 일때 실패")
    void initFail(final LadderInitInfo ladderInitInfo) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Step.init(ladderInitInfo));
    }

    private static Stream<LadderInitInfo> initFail() {
        return Stream.of(
                LadderInitInfo.init(1, 0),
                LadderInitInfo.init(1, -1)
        );
    }

    @Test
    @DisplayName("초기화 : 너비가 1인 경우에는 foot step 은 항상 NONE")
    void initWidthLengthIsOne() {
        assertThat(Step.init(LadderInitInfo.init(1, 1)).toFootSteps())
                .isEqualTo(Collections.singletonList(false));
    }

    @Test
    @DisplayName("초기화 : 너비가 2인 경우 마지막 foot step 은 항상 NONE 이므로 foot step 은 false")
    void initWidthLengthIsTwo() {
        List<Boolean> footSteps = Step.init(LadderInitInfo.init(1, 2)).toFootSteps();

        assertThat(footSteps.get(1)).isFalse();
    }
}