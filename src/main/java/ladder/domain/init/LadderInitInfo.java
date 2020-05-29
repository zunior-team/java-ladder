package ladder.domain.init;

import ladder.domain.ladder.footstep.FootStepCreateStrategy;
import ladder.domain.ladder.footstep.HalfChanceGenerator;
import ladder.util.ObjectUtil;

public class LadderInitInfo {
    private final FootStepCreateStrategy footStepCreateStrategy;
    private final LadderSize ladderSize;

    private LadderInitInfo(final LadderSize ladderSize, final FootStepCreateStrategy footStepCreateStrategy) {
        ObjectUtil.checkNull(ladderSize, footStepCreateStrategy);

        this.ladderSize = ladderSize;
        this.footStepCreateStrategy = footStepCreateStrategy;
    }

    public static LadderInitInfo init(final LadderSize ladderSize,
                                      final FootStepCreateStrategy footStepCreateStrategy) {
        return new LadderInitInfo(ladderSize, footStepCreateStrategy);
    }

    public static LadderInitInfo init(final LadderSize ladderSize) {
        return init(ladderSize, new HalfChanceGenerator());
    }

    public FootStepCreateStrategy getFootStepCreateStrategy() {
        return footStepCreateStrategy;
    }

    public int getLadderHeight() {
        return ladderSize.getHeight();
    }

    public int getLadderWidth() {
        return ladderSize.getWidth();
    }
}
