package ladder.domain.prize;

import ladder.util.StringUtil;

public class Prize {
    private final String prize;

    private Prize(final String prize) {
        validate(prize);

        this.prize = prize;
    }

    private void validate(final String name) {
        if (StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException("Prize value is null or empty");
        }
    }

    public static Prize init(final String prize) {
        return new Prize(prize);
    }

    public String getPrize() {
        return prize;
    }
}
