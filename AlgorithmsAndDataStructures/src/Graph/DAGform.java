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

public class DAGform {

    static int[] low;
    static int[] val;
    static int T;
    static ArrayList<Integer>[] al;

    public static ArrayList<Integer>[] DAG(ArrayList<Integer>[] al) {
        int[] c = toRel(SCCTarjan(al));
        int max = 0;
        for (int i = 0; i < c.length; i++) {
            c[i]--;
            max = max(max, c[i]);
        }
        ArrayList<Integer>[] ans = new ArrayList[max];
        for (int i = 0; i < al.length; i++) {
            for (int e : al[i]) {
                if (!ans[c[i]].contains(c[e])) { //could use treesets for speed
                    ans[c[i]].add(c[e]);
                }
            }
        }

        return ans;
    }

    public static int[] SCCTarjan(ArrayList<Integer>[] al) {
        DAGform.al = al;
        int N = al.length - 1;
        low = new int[N + 1];
        val = new int[N + 1];
        T = 1;
        Arrays.fill(val, -1);
        Arrays.fill(low, -1);
        TarjanU(1, -1);

        return low;
    }

    public static void TarjanU(int i, int p) {
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

    public static int[] toRel(int[] d) {
        pair[] p = new pair[d.length];
        for (int i = 0; i < d.length; i++) {
            p[i] = new pair(d[i], i + 1);
        }
        Arrays.sort(p);
        int[] fin = new int[d.length];
        for (int i = 0; i < d.length; i++) {
            fin[i] = p[i].b;
        }
        return fin;
    }

    static class pair implements Comparable<pair> {

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
