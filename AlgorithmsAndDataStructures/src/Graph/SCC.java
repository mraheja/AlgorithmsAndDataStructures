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

public class SCC {

    public static int kosarajus(ArrayList<Integer>[] al, int N) {
        Stack trav = new Stack();
        boolean[] v = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                buildStack(i, trav, v, al, N);
            }
        }
        transpose(al);
        v = new boolean[N];
        int ans = 0;
        while (!trav.isEmpty()) {
            int c = (int) trav.pop();
            if (!v[c]) {
                if (DFS(c, v, al)) {
                    ans++;
                }
            }
        }
        return ans;

    }

    public static void buildStack(int source, Stack trav, boolean[] v, ArrayList<Integer>[] al, int N) {
        v[source] = true;
        Iterator<Integer> it = al[source].iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!v[n]) {
                buildStack(n, trav, v, al, N);
            }
        }
        trav.push(source);
    }

    public static void transpose(ArrayList<Integer>[] d) {
        ArrayList<Integer>[] nd = new ArrayList[d.length];
        for (int i = 0; i < nd.length; i++) {
            nd[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < d.length; i++) {
            Iterator<Integer> it = d[i].iterator();
            while (it.hasNext()) {
                int n = it.next();
                nd[n].add(i);
            }
        }
        d = nd;
    }

    public static boolean DFS(int i, boolean[] v, ArrayList<Integer>[] al) {
        v[i] = true;
        Iterator<Integer> it = al[i].iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!v[n]) {
                return (true && DFS(n, v, al));
            }
        }
        return false;
    }
}
