/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DynamicProgramming;

/**
 *  © Mehul Raheja
 */
public class LongestCommonSubsequence {
    public int lcs(char[] a, char[] b, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }else if(a[n-1] == b[m-1]){
            return 1 + lcs(a,b,n-1,m-1);
        }else{
            return Math.max(lcs(a,b,n-1,m), lcs(a,b,n,m-1));
        }  
    }
}
