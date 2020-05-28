package ladder.domain.ladder;

import ladder.domain.dto.StepDto;
import ladder.domain.init.LadderInitInfo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    static final int MINIMUM_HEIGHT_OF_LADDER = 1;
    private final List<Step> steps;

    private Ladder(final LadderInitInfo ladderInitInfo) {
        validate(ladderInitInfo);

        steps = Stream.generate(() -> Step.init(ladderInitInfo))
                .limit(ladderInitInfo.getLadderHeight())
                .collect(Collectors.toList());
    }

    private void validate(final LadderInitInfo ladderInitInfo) {
        if (Objects.isNull(ladderInitInfo)) {
            throw new IllegalArgumentException("Ladder init info is null");
        }

        if (ladderInitInfo.getLadderHeight() < MINIMUM_HEIGHT_OF_LADDER) {
            throw new IllegalArgumentException("Ladder height must be larger or equal to " + MINIMUM_HEIGHT_OF_LADDER);
        }
    }

    public static Ladder init(final LadderInitInfo ladderInitInfo) {
        return new Ladder(ladderInitInfo);
    }

    //int takeLadder(int startPosition);
    //reduce

    public List<StepDto> getSteps() {
        return steps.stream()
                .map(Step::toFootSteps)
                .map(StepDto::of)
                .collect(Collectors.toList());
    }
}
