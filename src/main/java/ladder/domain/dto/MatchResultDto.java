package ladder.domain.dto;

import ladder.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchResultDto {
    private final Map<String, String> playerAndPrize;

    private MatchResultDto(final Map<String, String> playerAndPrize) {
        ObjectUtil.checkNull(playerAndPrize);

        this.playerAndPrize = playerAndPrize;
    }

    public static MatchResultDto of(final Map<String, String> playerAndPrize) {
        return new MatchResultDto(playerAndPrize);
    }

    public String match(final String playerName) {
        if (!playerAndPrize.containsKey(playerName)) {
            throw new IllegalArgumentException("Player is not exist");
        }

        return playerAndPrize.get(playerName);
    }

    public List<String> getPlayers() {
        return new ArrayList<>(playerAndPrize.keySet());
    }
}
