package ladder.domain.ladder.footstep;

import java.util.concurrent.ThreadLocalRandom;

public class HalfChanceGenerator implements FootStepCreateStrategy {

    @Override
    public boolean isGenerable() {
        return ThreadLocalRandom.current()
                .nextBoolean();
    }
}
