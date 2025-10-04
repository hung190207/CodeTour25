package phepgianno;

import java.util.Scanner;
// Done 18/20 testcases because TLE.
public class Solution {

    static int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public static int[][] isDilation(int[][] matrix, int k, int m, int n) {
        for (int iter = 0; iter < k; iter++) {
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] = matrix[i][j];
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        for (int[] dir : directions) {
                            int ni = i + dir[0];
                            int nj = j + dir[1];

                            if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                                res[ni][nj] = 1;
                            }
                        }
                    }
                }
            }

            matrix = res;
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] result = isDilation(matrix, k, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}