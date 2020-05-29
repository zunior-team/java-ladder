package ladder.domain.init;

import ladder.util.ObjectUtil;

import java.util.List;

public class PlayerAndPrizeInitInfo {
    private final List<String> names;
    private final List<String> prizes;

    private PlayerAndPrizeInitInfo(final List<String> names, final List<String> prizes) {
        ObjectUtil.checkNull(names, prizes);

        this.names = names;
        this.prizes = prizes;
    }

    public static PlayerAndPrizeInitInfo init(final List<String> names, final List<String> prizes) {
        return new PlayerAndPrizeInitInfo(names, prizes);
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getPrizes() {
        return prizes;
    }

    public int getPlayerCount() {
        return names.size();
    }
}
