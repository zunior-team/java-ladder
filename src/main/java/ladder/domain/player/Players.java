package ladder.domain.player;

import ladder.util.ObjectUtil;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int NUM_OF_MINIMUM_PLAYER = 1;

    private final List<Player> players;

    private Players(final List<String> names) {
        validate(names);

        this.players = names.stream()
                .map(Player::init)
                .collect(Collectors.toList());
    }

    private void validate(final List<String> names) {
        ObjectUtil.checkNull(names, "Players names is null");

        if (names.size() < NUM_OF_MINIMUM_PLAYER) {
            throw new IllegalArgumentException("Players are required at least " + NUM_OF_MINIMUM_PLAYER);
        }
    }

    public static Players init(final List<String> names) {
        return new Players(names);
    }

    public String getPlayerName(final int idx) {
        return players.get(idx)
                .getName();
    }

    public List<String> getPlayersName() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
