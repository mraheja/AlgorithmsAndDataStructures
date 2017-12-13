/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * © Mehul Raheja
 */

public class LCA {

    public ArrayList<Integer>[] al;
    public int[] T; //PARENT ARRAY
    public int[] D;
    public int[][] dp;

    public LCA(int N, ArrayList<Integer>[] al) {
        this.al = al;
        T = new int[N + 1];
        D = new int[N + 1];
        dp = new int[N + 1][(int) (Math.log(N) / Math.log(2)) + 1];

       // Arrays.fill(T, 0);
        Arrays.fill(D, -1);
        D[1] = 1;
        T[1] = -1;
        DFS(1);

        for (int i = 1; i <= N; i++) {
            dp[i][0] = T[i];
        }

        for (int i = 1; i < dp[0].length; i++) {
            for (int j = 1; j <= N; j++) {
                if (dp[j][i - 1] != -1) {
                    dp[j][i] = dp[dp[j][i - 1]][i - 1];
                }
            }
        }
       
    }

    public void DFS(int i) {
        for (int e : al[i]) {
            if (T[e] == 0) {
                T[e] = i;
                D[e] = D[i] + 1;
                DFS(e);
            }
        }
    }

    public int LCA(int a, int b) {
        if(D[a] < D[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        
        int log = (int)(Math.log(D[a])/Math.log(2));
        
        for (int i = log; i >= 0; i--) {
            if(D[a] - (1<<i) >= D[b]){
                a = dp[a][i];
            }
        }
        
        if(a == b){
            return a;
        }
        
        for (int i = log; i >= 0; i--) {
            if(dp[a][i] != -1 && dp[a][i] != dp[b][i]){
                a = dp[a][i];
                b = dp[b][i];
            }
        }
        
        return T[a];
    }
}
