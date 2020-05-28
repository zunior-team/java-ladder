package ladder.view.console;

import ladder.domain.dto.MatchResultDto;
import ladder.domain.dto.StepDto;

import java.util.List;

public class ConsoleOutput {
    private static final String PADDING = "     ";
    private static final String HEADER_FORMAT = "%6s";
    private static final String COLUMN_WITH_FOOTSTEP = "|-----";
    private static final String COLUMN_WITHOUT_FOOTSTEP = "|     ";

    private ConsoleOutput() {}

    public static void showResult(final MatchResultDto matchResultDto) {
        System.out.println("실행 결과");
        showPlayers(matchResultDto.getPlayers());
        showLadder(matchResultDto.getSteps());
    }

    private static void showLadder(final List<StepDto> steps) {
        steps.forEach(ConsoleOutput::showStep);
    }

    private static void showStep(StepDto step) {
        System.out.print(PADDING);
        step.getFootSteps()
                .forEach(footStep -> System.out.print(footStep ? COLUMN_WITH_FOOTSTEP : COLUMN_WITHOUT_FOOTSTEP));
        newLine();
    }

    private static void showPlayers(final List<String> names) {
        names.forEach(name -> System.out.print(String.format(HEADER_FORMAT, name)));
        newLine();
    }

    private static void newLine() {
        System.out.println();
    }
}
