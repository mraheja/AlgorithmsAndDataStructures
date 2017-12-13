/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumberTheory;

import java.util.Arrays;

/**
 * © Mehul Raheja
 */
public class Combinations {

    /* ONLY WORKS IF MOD IS PRIME LARGER THAN N*/
    
    long[] fact;
    long[] ifact;

    public void precomp(int N, int M) {
        fact = new long[N + 1];
        ifact = new long[N + 1];

        fact[1] = ifact[1] = 1;
        for (int i = 2; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % M;
            ifact[i] = modinv(fact[i], M);
        }

        System.out.println(Arrays.toString(fact));
        System.out.println(Arrays.toString(ifact));
    }

    public long nCr(int n, int r, int m) {
        return ((fact[n] % m * ifact[r] % m) % m * ifact[n - r] % m) % m;
    }

    public long modinv(long N, long M) {
        return exp(N, M - 2, M);
    }

    public long exp(long a, long b, long m) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % m;
            }
            a = (a * a) % m;
            b >>= 1;
        }
        return ans;
    }
}
