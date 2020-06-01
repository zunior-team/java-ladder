package ladder.domain.ladder.strategy;

import ladder.domain.ladder.strategy.footstep.FootStepCreateStrategy;
import ladder.domain.ladder.strategy.footstep.RandomChanceStrategy;
import ladder.domain.ladder.strategy.ladderheight.LadderHeightStrategy;
import ladder.domain.ladder.strategy.ladderheight.RandomHeightStrategy;
import ladder.util.ObjectUtil;

public class LadderInitStrategyWithLevel implements LadderInitStrategies {

    private final FootStepCreateStrategy footStepCreateStrategy;
    private final LadderHeightStrategy ladderHeightStrategy;

    private LadderInitStrategyWithLevel(final LadderLevel ladderLevel) {
        ObjectUtil.checkNull(ladderLevel, "LadderLevel is null");

        this.footStepCreateStrategy = RandomChanceStrategy.init(ladderLevel.getStandard());
        this.ladderHeightStrategy = RandomHeightStrategy.init(ladderLevel.getBase(), ladderLevel.getRange());
    }

    public static LadderInitStrategies init(final LadderLevel ladderLevel) {
        return new LadderInitStrategyWithLevel(ladderLevel);
    }

    @Override
    public boolean isGenerable() {
        return footStepCreateStrategy.isGenerable();
    }

    @Override
    public int decideHeight() {
        return ladderHeightStrategy.decideHeight();
    }
}
