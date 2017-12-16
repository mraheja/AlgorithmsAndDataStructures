/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DynamicProgramming;

/**
 *  © Mehul Raheja
 */

//An O(NlogN) solution for this exists but its not DP
public class LongestIncreasingSubsequence {
    int max = 1;
    public int lis(int[] d){
        int N = d.length;
        max = 1;
        lish(d,N);
        return max;
    }
    
    public int lish(int[] d, int N){
        if(N == 1){
            return 1;
        }
        int tmax = 1;
        for (int i = 1; i < N; i++) {
            int temp = lish(d,i);
            if(d[i-1] < d[N-1] && temp + 1 > tmax){
                tmax = temp + 1;
            }
        }
        
        max = Math.max(max, tmax);
        
        return tmax;
    }
}
