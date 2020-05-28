package ladder.domain.ladder;

import ladder.domain.init.LadderInitInfo;
import ladder.domain.ladder.footstep.FootStepCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static ladder.util.Static.FALSE_RETURN_STRATEGY;
import static ladder.util.Static.TRUE_RETURN_STRATEGY;
import static org.assertj.core.api.Assertions.*;

@DisplayName("발판 테스트")
class FootStepTest {

    @ParameterizedTest
    @ValueSource(strings = {"LEFT", "RIGHT", "NONE"}) //ciw"Ctrl+r"
    @DisplayName("발판은 없거나 기둥을 기준으로 좌, 우로 나뉜다")
    void type(final String type) {
        assertThatCode(() -> FootStep.valueOf(type)).doesNotThrowAnyException();
        assertThat(FootStep.valueOf(type)).isNotNull();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("첫기둥의 발판은 NONE이거나 RIGHT밖에 안된다.")
    void init(final FootStepCreateStrategy footStepCreateStrategy, final FootStep expected) {
        assertThat(FootStep.init(footStepCreateStrategy)).isEqualTo(expected);
    }

    private static Stream<Arguments> init() {
        return Stream.of(
                Arguments.of(TRUE_RETURN_STRATEGY, FootStep.RIGHT),
                Arguments.of(FALSE_RETURN_STRATEGY, FootStep.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("다음 기둥의 발판은 현재 기준으로 정해진다")
    void next(final FootStep curFootStep, final FootStepCreateStrategy footStepCreateStrategy, final FootStep expected) {
        assertThat(curFootStep.next(footStepCreateStrategy)).isEqualTo(expected);
    }

    private static Stream<Arguments> next() {
        return Stream.of(
                Arguments.of(FootStep.RIGHT, TRUE_RETURN_STRATEGY, FootStep.LEFT),
                Arguments.of(FootStep.RIGHT, FALSE_RETURN_STRATEGY, FootStep.LEFT),
                Arguments.of(FootStep.LEFT, TRUE_RETURN_STRATEGY, FootStep.RIGHT),
                Arguments.of(FootStep.LEFT, FALSE_RETURN_STRATEGY, FootStep.NONE),
                Arguments.of(FootStep.NONE, TRUE_RETURN_STRATEGY, FootStep.RIGHT),
                Arguments.of(FootStep.NONE, FALSE_RETURN_STRATEGY, FootStep.NONE)
        );
    }

    @Test
    @DisplayName("발판 생성 전략이 null일 경우 예외 발생")
    void initException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> FootStep.init(null));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("next 발판 생성 전략이 null일 경우 예외 발생")
    void nextException(final FootStep footStep) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> footStep.next(null));
    }

    private static Stream<Arguments> nextException() {
        return Stream.of(
                Arguments.of(FootStep.LEFT),
                Arguments.of(FootStep.NONE)
                //RIGHT는 없어도 생성가능.
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("마지막 발판 생성 테스트")
    void last(final FootStep footStep, final FootStep expected) {
        assertThat(footStep.last()).isEqualTo(expected);
    }

    private static Stream<Arguments> last() {
        return Stream.of(
                Arguments.of(FootStep.LEFT, FootStep.NONE),
                Arguments.of(FootStep.RIGHT, FootStep.LEFT),
                Arguments.of(FootStep.NONE, FootStep.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("컬럼을 기준으로 오른쪽 발판이 있는지 테스트")
    void toFootSteps(final LadderInitInfo ladderInitInfo, final List<Boolean> expected) {
        assertThat(Step.init(ladderInitInfo).toFootSteps()).isEqualTo(expected);
    }

    private static Stream<Arguments> toFootSteps() {
        return Stream.of(
                Arguments.of(LadderInitInfo.init(1, 5, () -> true), Arrays.asList(true, false, true, false, false)),
                Arguments.of(LadderInitInfo.init(1, 5, () -> false), Arrays.asList(false, false, false, false, false))
        );
    }

}