package ladder.domain.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MatchResultDto {
    private final List<String> players;
    private final List<StepDto> steps;

    private MatchResultDto(final List<String> playersName, final List<StepDto> steps) {
        validate(playersName, steps);

        this.players = playersName;
        this.steps = steps;
    }

    @SafeVarargs
    private final <T> void validate(T... parameters) {
        Arrays.stream(parameters)
                .filter(Objects::isNull)
                .findAny()
                .ifPresent(parameter -> {
                    throw new IllegalArgumentException("Some parameter is null");
                });
    }

    public static MatchResultDto of(final List<String> playersName, final List<StepDto> steps) {
        return new MatchResultDto(playersName, steps);
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<StepDto> getSteps() {
        return steps;
    }
}
