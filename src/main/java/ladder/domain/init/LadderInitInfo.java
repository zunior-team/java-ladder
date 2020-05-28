package ladder.domain.init;

import ladder.domain.ladder.footstep.FootStepCreateStrategy;
import ladder.domain.ladder.footstep.HalfChanceGenerator;

public class LadderInitInfo {
    private final FootStepCreateStrategy footStepCreateStrategy;
    private final int ladderHeight;
    private final int ladderWidth;

    private LadderInitInfo(final int ladderHeight,
                           final int ladderWidth,
                           final FootStepCreateStrategy footStepCreateStrategy) {
        this.ladderHeight = ladderHeight;
        this.ladderWidth = ladderWidth;
        this.footStepCreateStrategy = footStepCreateStrategy;
    }

    public static LadderInitInfo init(final int ladderHeight,
                                      final int ladderWidth,
                                      final FootStepCreateStrategy footStepCreateStrategy) {
        return new LadderInitInfo(ladderHeight, ladderWidth, footStepCreateStrategy);
    }

    public static LadderInitInfo init(final int ladderHeight, final int ladderWidth) {
        return init(ladderHeight, ladderWidth, new HalfChanceGenerator());
    }

    public FootStepCreateStrategy getFootStepCreateStrategy() {
        return footStepCreateStrategy;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public int getLadderWidth() {
        return ladderWidth;
    }
}
