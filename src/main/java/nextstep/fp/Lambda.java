package nextstep.fp;

import java.util.List;
import java.util.function.Function;

public class Lambda {

    public static final int ZERO = 0;

    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();
    }

    private static int sum(final List<Integer> numbers, final Function<Integer, Boolean> filter) {
        return numbers.stream()
                .filter(filter::apply)
                .reduce(ZERO, Integer::sum);
    }

    public static int sumAll(final List<Integer> numbers) {
        return sum(numbers, number -> true);
    }

    public static int sumAllEven(final List<Integer> numbers) {
        return sum(numbers, number -> number % 2 == 0);
    }

    public static int sumAllOverThree(final List<Integer> numbers) {
        return sum(numbers, number -> number > 3);
    }
}
