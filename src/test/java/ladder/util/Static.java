package ladder.util;

import ladder.domain.init.LadderInitInfo;
import ladder.domain.init.LadderSize;
import ladder.domain.ladder.Column;
import ladder.domain.ladder.footstep.FootStepCreateStrategy;

import java.util.Arrays;
import java.util.List;

public class Static {
    public static final List<String> NAMES = Arrays.asList("name1", "name2", "name3", "name4", "name5");
    public static final List<String> PRIZES_STRS = Arrays.asList("prize1", "prize2", "prize3", "prize4", "prize5");

    public static final int HEIGHT = 5, WIDTH = 5;
    public static final FootStepCreateStrategy TRUE_RETURN_STRATEGY = () -> true;
    public static final FootStepCreateStrategy FALSE_RETURN_STRATEGY = () -> false;

    public static final Column COLUMN_WITH_RIGHT_FOOTSTEP = Column.init(TRUE_RETURN_STRATEGY);
    public static final Column COLUMN_WITH_LEFT_FOOTSTEP = COLUMN_WITH_RIGHT_FOOTSTEP.createNext(TRUE_RETURN_STRATEGY);
    public static final Column COLUMN_WITHOUT_FOOTSTEP = Column.init(FALSE_RETURN_STRATEGY);

    public static final LadderInitInfo LADDER_INIT_INFO_WITH_TRUE_STRATEGY =
            LadderInitInfo.init(LadderSize.init(WIDTH, HEIGHT), TRUE_RETURN_STRATEGY);

    private Static() {}
}
