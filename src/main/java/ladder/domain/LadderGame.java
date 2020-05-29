package ladder.domain;

import ladder.domain.dto.LadderDto;
import ladder.domain.dto.MatchResultDto;
import ladder.domain.init.LadderGameInitInfo;
import ladder.domain.ladder.Ladder;
import ladder.util.ObjectUtil;

import java.util.Map;

public class LadderGame {
    private final PlayerAndPrize playerAndPrize;
    private final Ladder ladder;

    private LadderGame(final LadderGameInitInfo ladderGameInitInfo) {
        ObjectUtil.checkNull(ladderGameInitInfo, "Ladder init info is null");

        this.playerAndPrize = PlayerAndPrize.init(ladderGameInitInfo.getPlayerAndPrizeInitInfo());
        this.ladder = Ladder.init(ladderGameInitInfo.getLadderInitInfo());
    }

    public static LadderGame init(final LadderGameInitInfo ladderGameInitInfo) {
        return new LadderGame(ladderGameInitInfo);
    }

    public MatchResultDto play() {
        Map<String, String> playerAndPrizeMatchResult =
                playerAndPrize.matchPlayerAndPrize(ladder.takeLadders());

        return MatchResultDto.of(playerAndPrizeMatchResult);
    }

    public LadderDto getLadderInfo() {
        return LadderDto.of(playerAndPrize, ladder);
    }
}
