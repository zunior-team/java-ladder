package ladder.domain.init;

import ladder.domain.ladder.strategy.LadderInitStrategies;
import ladder.util.ObjectUtil;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final PlayerAndPrizeInitInfo playerAndPrizeInitInfo;

    private LadderGameInitInfo(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo,
                               final LadderInitStrategies ladderInitStrategies) {
        ObjectUtil.checkNull(playerAndPrizeInitInfo, ladderInitStrategies);

        int height = ladderInitStrategies.decideHeight();

        LadderSize ladderSize = LadderSize.init(playerAndPrizeInitInfo.getPlayerCount(), height);
        this.playerAndPrizeInitInfo = playerAndPrizeInitInfo;
        this.ladderInitInfo = LadderInitInfo.init(ladderSize, ladderInitStrategies);
    }

    public static LadderGameInitInfo init(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo,
                                          final LadderInitStrategies ladderInitStrategies) {
        return new LadderGameInitInfo(playerAndPrizeInitInfo, ladderInitStrategies);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public PlayerAndPrizeInitInfo getPlayerAndPrizeInitInfo() {
        return playerAndPrizeInitInfo;
    }
}
