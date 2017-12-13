/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumberTheory;

/**
 * © Mehul Raheja
 */
public class GCDLCM {

    public long gcd(long a, long b) {
        while (b > 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
