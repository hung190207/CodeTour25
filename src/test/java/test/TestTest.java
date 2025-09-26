package test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTest {
    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(3, 4, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("test")
    void test(int a, int b, int expected) {
        int actual = new Test().sum(a, b);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5",
            "4,5,9"
    })
    void add(int a, int b, int expected0) {
        assertEquals(expected0, Test.add(a, b));
    }
}
