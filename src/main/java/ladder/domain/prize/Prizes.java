package ladder.domain.prize;

import ladder.util.ObjectUtil;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private static final int NUM_OF_MINIMUM_PRIZE = 1;

    private final List<Prize> prizes;

    private Prizes(final List<String> prizes) {
        validate(prizes);

        this.prizes = prizes.stream()
                .map(Prize::init)
                .collect(Collectors.toList());
    }

    private void validate(final List<String> prizes) {
        ObjectUtil.checkNull(prizes, "Prizes string list is null");

        if (prizes.size() < NUM_OF_MINIMUM_PRIZE) {
            throw new IllegalArgumentException("Prizes are required at least " + NUM_OF_MINIMUM_PRIZE);
        }
    }

    public static Prizes init(final List<String> prizes) {
        return new Prizes(prizes);
    }

    public String getPrize(final int idx) {
        return prizes.get(idx)
                .getPrize();
    }

    public List<String> getPrizes() {
        return prizes.stream()
                .map(Prize::getPrize)
                .collect(Collectors.toList());
    }
}
