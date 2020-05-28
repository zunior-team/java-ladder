package ladder.view.console;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleInput {
    private static final String SPLITTER = ",";
    private static final String INPUT_PLAYERS_STATEMENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleInput() {}

    public static List<String> inputPlayers() {
        System.out.println(INPUT_PLAYERS_STATEMENT);

        String namesString = inputString();

        return Stream.of(namesString.split(SPLITTER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int inputHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);

        return inputInt();
    }

    private static int inputInt() {
        return Integer.parseInt(inputString());
    }

    private static String inputString() {
        return SCANNER.nextLine();
    }
}
