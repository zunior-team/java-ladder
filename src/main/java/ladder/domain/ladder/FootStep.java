package ladder.domain.ladder;

import ladder.domain.ladder.footstep.FootStepCreateStrategy;
import ladder.util.ObjectUtil;

import java.util.function.Function;

//발판
public enum FootStep {
    LEFT(x -> x - 1),
    RIGHT(x -> x + 1),
    NONE(x -> x);

    private final Function<Integer, Integer> mover;

    FootStep(final Function<Integer, Integer> mover) {
        this.mover = mover;
    }

    public static FootStep init(final FootStepCreateStrategy footStepCreateStrategy) {
        return makeFootStep(footStepCreateStrategy);
    }

    public FootStep createNext(final FootStepCreateStrategy footStepCreateStrategy) {
        if (this == RIGHT) {
            return LEFT;
        }

        return makeFootStep(footStepCreateStrategy);
    }

    public FootStep createLast() {
        if (this == RIGHT) {
            return LEFT;
        }

        return NONE;
    }

    private static FootStep makeFootStep(final FootStepCreateStrategy footStepCreateStrategy) {
        validate(footStepCreateStrategy);

        if (footStepCreateStrategy.isGenerable()) {
            return RIGHT;
        }

        return NONE;
    }

    private static void validate(final FootStepCreateStrategy footStepCreateStrategy) {
        ObjectUtil.checkNull(footStepCreateStrategy, "FootStepStrategy can't be a null");
    }

    public Integer moveThroughFootStep(final int index) {
        return mover.apply(index);
    }
}
