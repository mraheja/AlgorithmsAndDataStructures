/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 * © Mehul Raheja
 */
import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class SCCTarjan {

    int[] low;
    int[] val;
    int T;
    ArrayList<Integer>[] al;

    public SCCTarjan(ArrayList<Integer>[] al) {
        this.al = al;
        int N = al.length-1;
        low = new int[N + 1];
        val = new int[N + 1];
        T = 1;
        Arrays.fill(val, -1);
        Arrays.fill(low, -1);
        TarjanU(1, -1);
        
        System.out.println(Arrays.toString(val));
        System.out.println(Arrays.toString(low));
        
        pair[] p = new pair[N];
        
        for (int i = 1; i <= N; i++) {
            p[i-1] = new pair(low[i],val[i]);
        }
        Arrays.sort(p);
        
        int prev = -1;
        for (int i = 0; i < N; i++) {
            if(p[i].a != prev){
                System.out.println("");
            }
            prev = p[i].a;
            System.out.print(" " + p[i].b);
        }
        System.out.println("");
    }

    public void TarjanU(int i, int p) {
        System.out.println(i);
        low[i] = val[i] = T++;

        for (int e : al[i]) {
            if (e != p) {
                if (val[e] == -1) {
                    TarjanU(e, i);
                    low[i] = min(low[i], low[e]);
                } else {
                    low[i] = min(low[i], val[e]);
                }
            }
        }
    }
    
    class pair implements Comparable<pair> {
        
        int a, b;
        
        public pair(int _a, int _b) {
            this.a = _a;
            this.b = _b;
        }
        
        @Override
        public int compareTo(pair t) {
            return (a == t.a) ? b - t.b : a - t.a;
        }
    }
}
