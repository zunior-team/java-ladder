package ladder.domain.dto;

import java.util.List;
import java.util.Objects;

public class StepDto {
    private final List<Boolean> footSteps;

    private StepDto(final List<Boolean> footSteps) {
        validate(footSteps);

        this.footSteps = footSteps;
    }

    private void validate(List<Boolean> footSteps) {
        if (Objects.isNull(footSteps)) {
            throw new IllegalArgumentException("Foot steps are null");
        }
    }

    public static StepDto of(final List<Boolean> footSteps) {
        return new StepDto(footSteps);
    }

    public List<Boolean> getFootSteps() {
        return footSteps;
    }
}
