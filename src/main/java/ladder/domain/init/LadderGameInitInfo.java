package ladder.domain.init;

import ladder.util.ObjectUtil;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final PlayerAndPrizeInitInfo playerAndPrizeInitInfo;

    private LadderGameInitInfo(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo, final int height) {
        ObjectUtil.checkNull(playerAndPrizeInitInfo, "PlayerAndPrizeInitInfo is null");

        LadderSize ladderSize = LadderSize.init(playerAndPrizeInitInfo.getPlayerCount(), height);
        this.playerAndPrizeInitInfo = playerAndPrizeInitInfo;
        this.ladderInitInfo = LadderInitInfo.init(ladderSize);
    }

    public static LadderGameInitInfo init(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo, final int height) {
        return new LadderGameInitInfo(playerAndPrizeInitInfo, height);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public PlayerAndPrizeInitInfo getPlayerAndPrizeInitInfo() {
        return playerAndPrizeInitInfo;
    }
}
