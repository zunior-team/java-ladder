package ladder.domain.init;

import java.util.List;
import java.util.Objects;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final List<String> names;

    private LadderGameInitInfo(final List<String> names, final int height) {
        validate(names);

        this.names = names;
        this.ladderInitInfo = LadderInitInfo.init(height, names.size());
    }

    private void validate(final List<String> names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException("Names are null");
        }
    }

    public static LadderGameInitInfo init(final List<String> names, final int height) {
        return new LadderGameInitInfo(names, height);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public List<String> getNames() {
        return names;
    }
}
