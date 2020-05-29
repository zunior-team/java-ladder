package ladder.domain.ladder;

import ladder.domain.dto.StepDto;
import ladder.domain.init.LadderInitInfo;
import ladder.util.ObjectUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private static final int MINIMUM_HEIGHT_OF_LADDER = 1;

    private final List<Step> steps;

    private Ladder(final LadderInitInfo ladderInitInfo) {
        validate(ladderInitInfo);

        steps = Stream.generate(() -> Step.init(ladderInitInfo))
                .limit(ladderInitInfo.getLadderHeight())
                .collect(Collectors.toList());
    }

    private void validate(final LadderInitInfo ladderInitInfo) {
        ObjectUtil.checkNull(ladderInitInfo, "Ladder init info is null");

        if (ladderInitInfo.getLadderHeight() < MINIMUM_HEIGHT_OF_LADDER) {
            throw new IllegalArgumentException("Ladder height must be larger or equal to " + MINIMUM_HEIGHT_OF_LADDER);
        }
    }

    public static Ladder init(final LadderInitInfo ladderInitInfo) {
        return new Ladder(ladderInitInfo);
    }

    public LadderTakeResult takeLadders() {
        int ladderWidth = steps.get(0)
                .getLadderWidth();

        List<Integer> matchPositions = IntStream.range(0, ladderWidth)
                .map(this::takeLadder)
                .boxed()
                .collect(Collectors.toList());

        return LadderTakeResult.init(matchPositions);
    }

    private int takeLadder(final int startPosition) {
        return steps.stream()
                .reduce(startPosition,
                        (byPosition, step) -> step.takeLadder(byPosition),
                        (x, y) -> {throw new RuntimeException("Can't reduce in parallel environment");});
    }

    public List<StepDto> getSteps() {
        return steps.stream()
                .map(Step::toFootSteps)
                .map(StepDto::of)
                .collect(Collectors.toList());
    }
}
