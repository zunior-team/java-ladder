package ladder.domain;

import ladder.domain.dto.MatchResultDto;
import ladder.domain.init.LadderGameInitInfo;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    private LadderGame(final LadderGameInitInfo ladderGameInitInfo) {
        this.players = Players.init(ladderGameInitInfo.getNames());
        this.ladder = Ladder.init(ladderGameInitInfo.getLadderInitInfo());
    }

    public static LadderGame init(final LadderGameInitInfo ladderGameInitInfo) {
        return new LadderGame(ladderGameInitInfo);
    }

    public MatchResultDto getMatchResult() {
        return MatchResultDto.of(players.getPlayersName(), ladder.getSteps());
    }
}
