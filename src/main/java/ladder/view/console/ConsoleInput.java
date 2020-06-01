package ladder.view.console;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleInput {
    private static final String SPLITTER = ",";
    private static final String INPUT_PLAYERS_STATEMENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_PRIZE_STATEMENT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_COMPLEXITY = "실행할 사다리의 난이도는?";
    private static final String INPUT_PLAYER_TO_SEE_RESULT = "결과를 보고 싶은 사람은?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleInput() {}

    public static List<String> inputPlayers() {
        System.out.println(INPUT_PLAYERS_STATEMENT);

        String namesString = inputString();

        return split(namesString);
    }

    private static List<String> split(final String namesString) {
        return Stream.of(namesString.split(SPLITTER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<String> inputPrizes() {
        System.out.println(INPUT_PRIZE_STATEMENT);

        String prizes = inputString();

        return split(prizes);
    }

    public static String inputComplexity() {
        System.out.println(INPUT_LADDER_COMPLEXITY);

        return inputString();
    }

    public static String inputPlayerToSeeResult() {
        System.out.println(INPUT_PLAYER_TO_SEE_RESULT);

        return inputString();
    }

    private static int inputInt() {
        return Integer.parseInt(inputString());
    }

    private static String inputString() {
        return SCANNER.nextLine();
    }
}
