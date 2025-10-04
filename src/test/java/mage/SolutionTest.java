package mage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    public static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(
                        5, 4,
                        new int[][]{
                                {0, 1, 2},
                                {1, 2, 3},
                                {2, 1, 3},
                                {3, 3, 5}
                        },
                        new long[]{2, 2, 1, -2, -3}
                ),


                Arguments.of(
                        3, 1,
                        new int[][]{
                                {0, 1, 3}
                        },
                        new long[]{1, 1, 1}
                ),


                Arguments.of(
                        3, 1,
                        new int[][]{
                                {1, 1, 3}
                        },
                        new long[]{-1, -1, -1}
                ),


                Arguments.of(
                        3, 1,
                        new int[][]{
                                {2, 1, 3}
                        },
                        new long[]{1, 2, 3}
                ),


                Arguments.of(
                        3, 1,
                        new int[][]{
                                {3, 1, 3}
                        },
                        new long[]{-1, -2, -3}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testcase")
    void Mage(int N, int M, int[][] spells, long[] expected) {
        long[] actual = Solution.solve(N, M, spells);
        assertArrayEquals(expected, actual);
    }
}