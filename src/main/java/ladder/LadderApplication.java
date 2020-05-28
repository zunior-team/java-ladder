package ladder;

import ladder.domain.LadderGame;
import ladder.domain.init.LadderGameInitInfo;
import ladder.view.console.ConsoleInput;
import ladder.view.console.ConsoleOutput;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        List<String> players = ConsoleInput.inputPlayers();
        int ladderHeight = ConsoleInput.inputHeight();

        LadderGame ladderGame = LadderGame.init(LadderGameInitInfo.init(players, ladderHeight));

        ConsoleOutput.showResult(ladderGame.getMatchResult());
    }
}
