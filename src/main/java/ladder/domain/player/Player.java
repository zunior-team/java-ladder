package ladder.domain.player;

import ladder.util.StringUtil;

public class Player {
    private static final int MAX_LENGTH_OF_PLAYER_NAME = 5;
    private final String name;

    private Player(final String name) {
        validate(name);

        this.name = name;
    }

    private void validate(final String name) {
        if (StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException("Player name is null or empty");
        }

        if (name.length() > MAX_LENGTH_OF_PLAYER_NAME) {
            throw new IllegalArgumentException("Player name should less than or equal to " + MAX_LENGTH_OF_PLAYER_NAME);
        }
    }

    public static Player init(final String name) {
        return new Player(name);
    }

    public String getName() {
        return name;
    }
}
