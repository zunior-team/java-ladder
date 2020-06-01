package ladder.domain.ladder.strategy.ladderheight;

import java.util.Random;

public class RandomHeightStrategy implements LadderHeightStrategy {
    private final Random random;
    private final int base;
    private final int range;

    private RandomHeightStrategy(final int base, final int range) {
        this.random = new Random();
        this.base = base;
        this.range = range;
    }

    public static RandomHeightStrategy init(final int base, final int range) {
        return new RandomHeightStrategy(base, range);
    }

    @Override
    public int decideHeight() {
        return random.nextInt(range) + base;
    }
}
