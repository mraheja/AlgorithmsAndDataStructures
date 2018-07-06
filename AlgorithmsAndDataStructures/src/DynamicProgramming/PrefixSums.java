/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/**
 * © Mehul Raheja
 */

public class PrefixSums {

    public int[] pref(int[] d) {
        int N = d.length;
        int[] p = new int[N];
        p[0] = d[0];
        for (int i = 1; i < d.length; i++) {
            p[i] = p[i - 1] + d[i];
        }
        return p;
    }

    public int[][] pref(int[][] d) {
        int N = d.length;
        int M = d[0].length;

        int[][] p = new int[N][M];
        p[0][0] = 1;
        for (int i = 1; i < N; i++) {
            p[i][0] = p[i - 1][0] + d[i][0];
        }
        for (int i = 1; i < M; i++) {
            p[0][i] = p[0][i - 1] + d[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                p[i][j] = p[i][j - 1] + p[i - 1][j] - p[i - 1][j - 1] + d[i][j];
            }
        }

        return p;
    }

    public int query(int[][] p, int x1, int y1, int x2, int y2) {
        int ans = p[x2][y2];
        if (x1 > 0) {
            ans -= p[x1 - 1][y2];
        }
        if (y1 > 0) {
            ans -= p[x2][y1 - 1];
        }
        if(x1 > 0 && y1 > 0){
            ans += p[x1-1][y1-1];
        }
        return ans;
    }
}
