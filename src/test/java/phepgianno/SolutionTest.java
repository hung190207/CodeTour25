package phepgianno;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(5, 5, 2,
                        new int[][]{
                                {1, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 0}
                        },
                        new int[][]{
                                {1, 1, 1, 0, 0},
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {0, 0, 1, 1, 1},
                                {0, 0, 1, 1, 1}
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource("test")
    void isDilation(int m, int n, int k, int[][] matrix, int[][] expected) {
        int[][] actual = new Solution().isDilation(matrix, k, m, n);
        assertArrayEquals2D(expected, actual);
    }

    // Method helper để so sánh 2 ma trận
    private void assertArrayEquals2D(int[][] expected, int[][] actual) {
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i],
                    "Row " + i + " is different");
        }
    }
}