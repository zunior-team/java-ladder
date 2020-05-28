package ladder.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class ThreadLocalTest {
    @Test
    @DisplayName("thread local's next boolean")
    void nextBoolean() {
        Stream.generate(() -> ThreadLocalRandom.current().nextBoolean())
                .limit(10)
                .forEach(System.out::println);
    }
}
