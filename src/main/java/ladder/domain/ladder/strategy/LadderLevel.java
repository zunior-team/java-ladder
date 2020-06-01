package ladder.domain.ladder.strategy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ladder.domain.ladder.strategy.LadderLevel.Type.*;

public enum LadderLevel {
    HARD(HARD_TYPE.type, HARD_TYPE.standard, HARD_TYPE.base, HARD_TYPE.range),
    MEDIUM(MEDIUM_TYPE.type, MEDIUM_TYPE.standard, MEDIUM_TYPE.base, MEDIUM_TYPE.range),
    EASY(EASY_TYPE.type, EASY_TYPE.standard, EASY_TYPE.base, EASY_TYPE.range);

    private final String type;
    private final int standard;
    private final int base;
    private final int range;

    public static final LadderLevel DEFAULT = MEDIUM;
    private static final Map<String, LadderLevel> STRATEGIES =
            Arrays.stream(values())
                    .collect(Collectors.toMap(LadderLevel::getType, Function.identity()));

    LadderLevel(final String type, final int standard, final int base, final int range) {
        this.type = type;
        this.standard = standard;
        this.base = base;
        this.range = range;
    }

    public static LadderLevel of(final String type) {
        if (!STRATEGIES.containsKey(type)) {
            throw new IllegalArgumentException("Unknown type : " + type);
        }

        return STRATEGIES.get(type);
    }

    private String getType() {
        return type;
    }

    public int getStandard() {
        return standard;
    }

    public int getBase() {
        return base;
    }

    public int getRange() {
        return range;
    }

    static class Type {
        static final Type HARD_TYPE = new Type("상", 7, 4, 2);
        static final Type MEDIUM_TYPE = new Type("중", 5, 2, 5);
        static final Type EASY_TYPE = new Type("하", 2, 3, 7);

        String type;
        int base;
        int range;
        int standard;

        public Type(final String type, final int base, final int range, final int standard) {
            this.type = type;
            this.base = base;
            this.range = range;
            this.standard = standard;
        }
    }
}
