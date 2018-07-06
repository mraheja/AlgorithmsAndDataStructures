/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrices;

/**
 * © Mehul Raheja
 */
public class Multiplication {

    public static long[][] mult(long[][] a, long[][] b, long mod) {
        int aR = a.length;
        int aC = a[0].length;
        int bR = b.length;
        int bC = b[0].length;
        
        if(aC != bR){
            throw new IllegalArgumentException();
        }
        
        long[][] ans = new long[aR][bC];
        for (int i = 0; i < aR; i++) {
            for (int j = 0; j < bC; j++) {
                for (int k = 0; k < aC; k++) {
                    ans[i][j] = (ans[i][j] + mod + (a[i][k] * b[k][j] + mod)%mod)%mod;
                }
            }
        }
        
        return ans;
    }
    
    public static long[][] exp(long[][] a, long b, long m){
        long[][] ans = new long[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            ans[i][i] = 1;
        }
        while(b > 0){
            if((b&1) == 1){
                ans = mult(ans,a,m);
            }
            a = mult(a,a,m);
            b >>= 1;
        }
        return ans;
    }
}
