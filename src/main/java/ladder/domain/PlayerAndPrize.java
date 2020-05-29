package ladder.domain;

import ladder.domain.init.PlayerAndPrizeInitInfo;
import ladder.domain.ladder.LadderTakeResult;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import ladder.util.ObjectUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PlayerAndPrize {
    private final Players players;
    private final Prizes prizes;

    private PlayerAndPrize(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo) {
        ObjectUtil.checkNull(playerAndPrizeInitInfo, "PlayerAndPrizeInitInfo is null");

        this.players = Players.init(playerAndPrizeInitInfo.getNames());
        this.prizes = Prizes.init(playerAndPrizeInitInfo.getPrizes());
    }

    public static PlayerAndPrize init(final PlayerAndPrizeInitInfo playerAndPrizeInitInfo) {
        return new PlayerAndPrize(playerAndPrizeInitInfo);
    }

    public Map<String, String> matchPlayerAndPrize(final LadderTakeResult ladderTakeResult) {
        Map<String, String> playerAndPrize = new LinkedHashMap<>();

        IntStream.range(0, players.getPlayersName().size())
                .forEach(idx ->
                        playerAndPrize.put(
                                players.getPlayerName(idx),
                                prizes.getPrize(ladderTakeResult.getResultPositionOf(idx))
                        )
                );

        return playerAndPrize;
    }

    public List<String> getPlayers() {
        return players.getPlayersName();
    }

    public List<String> getPrizes() {
        return prizes.getPrizes();
    }
}
