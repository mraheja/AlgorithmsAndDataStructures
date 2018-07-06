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

public class BiconnectedComponents {

    int[] low;
    int[] val;
    boolean[] ap;
    int[] map;
    int T;
    ArrayList<Integer>[] al;

    public BiconnectedComponents(ArrayList<Integer>[] al) {
        this.al = al;
        int N = al.length;
        low = new int[N + 1];
        val = new int[N + 1];
        map = new int[N + 1];
        ap = new boolean[N];
        T = 1;
        Arrays.fill(val, -1);
        Arrays.fill(low, -1);
        TarjanU(1, -1);
        System.out.println(Arrays.toString(val));
        System.out.println(Arrays.toString(low));
        System.out.println(Arrays.toString(map));
        System.out.print("BICONNECTED COMPONENTS:");
        for (int i = 1; i < ap.length; i++) {
            if (ap[map[i]] || al[map[i]].size() == 1) {
                System.out.println("");
            }
            System.out.print(map[i] + " ");
        }
        System.out.println("");
    }

    public void TarjanU(int i, int p) {
        System.out.println(i);
        
        low[i] = val[i] = T++;
        map[T-1] = i;
        for (int e : al[i]) {
            if (e != p) {
                if (val[e] == -1) {
                    TarjanU(e, i);
                    low[i] = min(low[i], low[e]);
                } else {
                    low[i] = min(low[i], val[e]);
                }
            }
            if (low[e] >= val[i]) {
                ap[i] = true;
            }
        }

    }
}
