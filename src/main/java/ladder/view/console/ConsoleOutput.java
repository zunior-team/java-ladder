package ladder.view.console;

import ladder.domain.dto.LadderDto;
import ladder.domain.dto.MatchResultDto;
import ladder.domain.dto.StepDto;

import java.util.List;

public class ConsoleOutput {
    private static final String PADDING = "     ";
    private static final String HEADER_FORMAT = "%6s";
    private static final String COLUMN_WITH_FOOTSTEP = "|-----";
    private static final String COLUMN_WITHOUT_FOOTSTEP = "|     ";

    private ConsoleOutput() {}


    public static void showLadderInfo(final LadderDto ladderInfo) {
        System.out.println("사다리 결과");

        showPlayers(ladderInfo.getPlayers());
        showLadder(ladderInfo.getSteps());
        showPrizes(ladderInfo.getPrizes());
    }

    public static void showResult(final MatchResultDto matchResultDto, final String playerName) {
        System.out.println("실행 결과");

        showMatchResult(playerName, matchResultDto.match(playerName));
    }

    public static void showAllMatchResult(final MatchResultDto matchResult) {
        System.out.println("실행 결과");

        matchResult.getPlayers()
                .forEach(name -> ConsoleOutput.showMatchResult(name, matchResult.match(name)));
    }

    public static void showMatchResult(final String playerName, final String prize) {
        System.out.println(playerName + " : " + prize);
    }

    private static void showLadder(final List<StepDto> steps) {
        steps.forEach(ConsoleOutput::showStep);
    }

    private static void showStep(final StepDto step) {
        System.out.print(PADDING);

        step.getFootSteps()
                .forEach(footStep -> System.out.print(footStep ? COLUMN_WITH_FOOTSTEP : COLUMN_WITHOUT_FOOTSTEP));
        newLine();
    }

    private static void showPlayers(final List<String> names) {
        names.forEach(name -> System.out.print(String.format(HEADER_FORMAT, name)));
        newLine();
    }

    private static void showPrizes(final List<String> prizes) {
        prizes.forEach(prize -> System.out.print(String.format(HEADER_FORMAT, prize)));
        newLine();
    }

    private static void newLine() {
        System.out.println();
    }
}
