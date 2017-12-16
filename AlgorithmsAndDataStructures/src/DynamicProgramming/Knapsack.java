/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DynamicProgramming;

/**
 *  © Mehul Raheja
 */
public class Knapsack {
    public int[] knap(int[] d, int M){
        int[] poss = new int[M+1];
        poss[0] = 1;
        for(int e: d){
            for (int i = 0; i <= M-e; i++) {
                poss[i + e] += poss[i];
            }
        }
        return poss;
    }
    
    public int[] limknap(int[] d, int M){
        int[] poss = new int[M+1];
        poss[0] = 1;
        for (int e: d) {
            for (int i = M-e; i >= 0; i--) {
                poss[i+e] += poss[i];
            }
        }
        return poss;
    }
}
