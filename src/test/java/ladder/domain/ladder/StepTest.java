package ladder.domain.ladder;

import ladder.domain.init.LadderInitInfo;
import ladder.domain.init.LadderSize;
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
                Arguments.of(LadderInitInfo.init(LadderSize.init(1, height)), 1),
                Arguments.of(LadderInitInfo.init(LadderSize.init(2, height)), 2),
                Arguments.of(LadderInitInfo.init(LadderSize.init(3, height)), 3),
                Arguments.of(LadderInitInfo.init(LadderSize.init(4, height)), 4)
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
                LadderInitInfo.init(LadderSize.init(0, 1)),
                LadderInitInfo.init(LadderSize.init(-1, 1))
        );
    }

    @Test
    @DisplayName("초기화 : 너비가 1인 경우에는 foot step 은 항상 NONE")
    void initWidthLengthIsOne() {
        assertThat(Step.init(LadderInitInfo.init(LadderSize.init(1, 1))).toFootSteps())
                .isEqualTo(Collections.singletonList(false));
    }

    @Test
    @DisplayName("초기화 : 너비가 2인 경우 마지막 foot step 은 항상 NONE 이므로 foot step 은 false")
    void initWidthLengthIsTwo() {
        List<Boolean> footSteps =
                Step.init(LadderInitInfo.init(LadderSize.init(2, 1))).toFootSteps();

        assertThat(footSteps.get(1)).isFalse();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("사다리 한칸에 대한 사다리 타기 테스트")
    void takeALadder(final Step step, final int curPosition, final int expected) {
        assertThat(step.takeLadder(curPosition)).isEqualTo(expected);
    }

    private static Stream<Arguments> takeALadder() {
        Step ladderWithEvenIdxHasFooStep =
                Step.init(LadderInitInfo.init(LadderSize.init(5, 1), () -> true));
        Step ladderWithoutFootStep =
                Step.init(LadderInitInfo.init(LadderSize.init(5, 1), () -> false));

        return Stream.of(
                Arguments.of(ladderWithEvenIdxHasFooStep, 0, 1),
                Arguments.of(ladderWithEvenIdxHasFooStep, 1, 0),
                Arguments.of(ladderWithEvenIdxHasFooStep, 2, 3),
                Arguments.of(ladderWithEvenIdxHasFooStep, 3, 2),
                Arguments.of(ladderWithEvenIdxHasFooStep, 4, 4),

                Arguments.of(ladderWithoutFootStep, 0, 0),
                Arguments.of(ladderWithoutFootStep, 1, 1),
                Arguments.of(ladderWithoutFootStep, 2, 2),
                Arguments.of(ladderWithoutFootStep, 3, 3),
                Arguments.of(ladderWithoutFootStep, 4, 4)
        );
    }
}
