package mage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Done 10/20 testcases because TLE.
public class Solution {

    static class Spell {
        int k, l, r;

        Spell(int k, int l, int r) {
            this.k = k;
            this.l = l;
            this.r = r;
        }

        long effectAt(int pos) {
            if (pos < l || pos > r) return 0;

            switch (k) {
                case 0:
                    return 1;
                case 1:
                    return -1;
                case 2:
                    return (pos - l + 1);
                case 3:
                    return -(pos - l + 1);
                default:
                    return 0;
            }
        }
    }

    // Function for test.
    public static long[] solve(int N, int M, int[][] spellData) {
        List<Spell> spells = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            spells.add(new Spell(spellData[i][0], spellData[i][1], spellData[i][2]));
        }

        long[] heights = new long[N];

        for (int pos = 1; pos <= N; pos++) {
            long height = 0;
            for (Spell spell : spells) {
                height += spell.effectAt(pos);
            }
            heights[pos - 1] = height;
        }

        return heights;
    }

    // For submit on CodeTour25.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] spellData = new int[M][3];
        for (int i = 0; i < M; i++) {
            spellData[i][0] = sc.nextInt();
            spellData[i][1] = sc.nextInt();
            spellData[i][2] = sc.nextInt();
        }

        long[] result = solve(N, M, spellData);

        for (int i = 0; i < N; i++) {
            System.out.print(result[i]);
            if (i < N - 1) System.out.print(" ");
        }
        System.out.println();

        sc.close();
    }
}