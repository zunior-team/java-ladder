package ladder.domain.ladder.strategy.footstep;

import java.util.Random;

public class RandomChanceStrategy implements FootStepCreateStrategy {
    private static final int MAXIMUM = 10;

    private final Random random;
    private final int standard;

    private RandomChanceStrategy(final int standard) {
        this.random = new Random();
        this.standard = standard;
    }

    public static RandomChanceStrategy init(final int standard) {
        return new RandomChanceStrategy(standard);
    }

    @Override
    public boolean isGenerable() {
        return random.nextInt(MAXIMUM) > standard;
    }
}
