package ladder;

import ladder.domain.LadderGame;
import ladder.domain.dto.MatchResultDto;
import ladder.domain.init.LadderGameInitInfo;
import ladder.domain.init.PlayerAndPrizeInitInfo;
import ladder.domain.ladder.strategy.LadderInitStrategyWithLevel;
import ladder.domain.ladder.strategy.LadderLevel;
import ladder.domain.ladder.strategy.LadderInitStrategies;
import ladder.view.console.ConsoleInput;
import ladder.view.console.ConsoleOutput;

import java.util.List;

public class LadderApplication {
    private static final String ALL = "ALL";
    private static final String EXIT = "EXIT";

    public static void main(String[] args) {
        List<String> players = ConsoleInput.inputPlayers();
        List<String> prizes = ConsoleInput.inputPrizes();
        String complexity = ConsoleInput.inputComplexity();

        PlayerAndPrizeInitInfo playerAndPrizeInitInfo = PlayerAndPrizeInitInfo.init(players, prizes);
        LadderInitStrategies ladderInitStrategies = LadderInitStrategyWithLevel.init(LadderLevel.of(complexity));
        LadderGame ladderGame = LadderGame.init(LadderGameInitInfo.init(playerAndPrizeInitInfo, ladderInitStrategies));

        ConsoleOutput.showLadderInfo(ladderGame.getLadderInfo());
        MatchResultDto matchResult = ladderGame.play();

        String playerName;
        while (!(playerName = ConsoleInput.inputPlayerToSeeResult()).equalsIgnoreCase(EXIT)) {
            showResult(matchResult, playerName);
        }
    }

    private static void showResult(final MatchResultDto matchResult, final String playerName) {
        if (playerName.equalsIgnoreCase(ALL)) {
            ConsoleOutput.showAllMatchResult(matchResult);
            return;
        }

        ConsoleOutput.showResult(matchResult, playerName);
    }
}
