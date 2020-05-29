package ladder.domain.dto;

import ladder.domain.PlayerAndPrize;
import ladder.domain.ladder.Ladder;
import ladder.util.ObjectUtil;

import java.util.List;

public class LadderDto {
    private final List<String> players;
    private final List<StepDto> steps;
    private final List<String> prizes;

    private LadderDto(final PlayerAndPrize playerAndPrize, final Ladder ladder) {
        ObjectUtil.checkNull(playerAndPrize, ladder);

        this.players = playerAndPrize.getPlayers();
        this.prizes = playerAndPrize.getPrizes();
        this.steps = ladder.getSteps();
    }

    public static LadderDto of(final PlayerAndPrize playerAndPrize, final Ladder ladder) {
        return new LadderDto(playerAndPrize, ladder);
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<StepDto> getSteps() {
        return steps;
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
