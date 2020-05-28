package ladder.domain.ladder;

import ladder.domain.ladder.footstep.FootStepCreateStrategy;

import java.util.Objects;

//발판
public enum FootStep {
    LEFT,
    RIGHT,
    NONE;

    public static FootStep init(final FootStepCreateStrategy footStepCreateStrategy) {
        return makeFootStep(footStepCreateStrategy);
    }

    public FootStep next(final FootStepCreateStrategy footStepCreateStrategy) {
        if (this == RIGHT) {
            return LEFT;
        }

        return makeFootStep(footStepCreateStrategy);
    }

    public FootStep last() {
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
        if (Objects.isNull(footStepCreateStrategy)) {
            throw new IllegalArgumentException("FootStepStrategy can't be a null");
        }
    }
}
