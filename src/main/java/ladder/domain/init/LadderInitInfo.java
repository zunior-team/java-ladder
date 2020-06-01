package ladder.domain.init;

import ladder.domain.ladder.strategy.LadderInitStrategyWithLevel;
import ladder.domain.ladder.strategy.LadderLevel;
import ladder.domain.ladder.strategy.LadderInitStrategies;
import ladder.util.ObjectUtil;

public class LadderInitInfo {
    private final LadderInitStrategies ladderInitStrategies;
    private final LadderSize ladderSize;

    private LadderInitInfo(final LadderSize ladderSize, final LadderInitStrategies ladderInitStrategies) {
        ObjectUtil.checkNull(ladderSize, ladderInitStrategies);

        this.ladderSize = ladderSize;
        this.ladderInitStrategies = ladderInitStrategies;
    }

    public static LadderInitInfo init(final LadderSize ladderSize,
                                      final LadderInitStrategies ladderInitStrategies) {
        return new LadderInitInfo(ladderSize, ladderInitStrategies);
    }

    public static LadderInitInfo init(final LadderSize ladderSize) {
        return init(ladderSize, LadderInitStrategyWithLevel.init(LadderLevel.DEFAULT));
    }

    public LadderInitStrategies getLadderInitStrategies() {
        return ladderInitStrategies;
    }

    public int getLadderHeight() {
        return ladderSize.getHeight();
    }

    public int getLadderWidth() {
        return ladderSize.getWidth();
    }
}
