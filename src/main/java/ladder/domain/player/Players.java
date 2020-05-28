package ladder.domain.player;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(final List<String> names) {
        validate(names);

        this.players = names.stream()
                .map(Player::init)
                .collect(Collectors.toList());
    }

    private void validate(final List<String> names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException("Players names is null");
        }
    }

    public static Players init(List<String> names) {
        return new Players(names);
    }

    public List<String> getPlayersName() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
