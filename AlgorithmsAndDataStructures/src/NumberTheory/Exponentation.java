/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NumberTheory;

/**
 *  © Mehul Raheja
 */
public class Exponentation {
    /* (a ^ b) % M */
    public long exp(long a, long b, long m){
        long ans = 1;
        while(b > 0){
            if((b&1) == 1){
                ans = (ans*a)%m;
            }
            a = (a * a)%m;
            b >>= 1;
        }
        return ans;
    }
}
