/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees.DataStructures;

/**
 * © Mehul Raheja
 */
import java.util.*;
import java.io.*;

public class HeavyLightDecomp {

    public node[] n;
    public ArrayList<trip>[] al;
    public int[] chaintop;
    public int[] base;
    public int[] bot;

    public class node {

        public int par, depth, size, pos, chain;

        public node() {
            par = depth = pos = chain = 0;
            size = 1;
        }
    }

    public HeavyLightDecomp(int N) {
        
        N++;
        this.N = N;
        n = new node[N];
        base = new int[N];
        v = new boolean[N];
        al = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            al[i] = new ArrayList<trip>();
        }
        for (int i = 0; i < N; i++) {
            n[i] = new node();
        }
        w = new int[N];
        n[1].chain = 1;
        chaintop = new int[N];
        bot = new int[N];
        loc = new int[N];
    }

    int eInd = 0;

    public int[] loc;

    public void addEdge(int u, int v, int c) {
        al[u].add(new trip(v, c, ++eInd));
        al[v].add(new trip(v, c, eInd));
    }

    int ch = 1;

    public void DFS(int i) {

        for (trip p : al[i]) {
            int e = p.a;
            if (n[e].depth == 0) {
                n[e].depth = n[i].depth + 1;
                n[e].par = i;

                DFS(e);

                n[i].size += n[e].size;
            }
        }
    }

    public int ind = -1;
    public boolean[] v;
    public int prev = 0;
    public int prevInd;
    public int[] w;
    boolean used = false;

    public void DFS2(int i) {
        if (chaintop[n[i].chain] == 0) {
            chaintop[n[i].chain] = i;
        }
        v[i] = true;
        base[++ind] = prev;
        w[prevInd] = ind;
        loc[i] = ind ;
        
        ArrayList<trip> t = new ArrayList<trip>();
        for (trip p : al[i]) {
            t.add(new trip(n[p.a].size, p.a, p.b, p.c));
        }

        Collections.sort(t, Collections.reverseOrder());

        for (trip tr : t) {
            int e = tr.b;
            if (!v[e]) {
                prev = tr.c;
                prevInd = tr.d;
                n[e].chain = ch;
                used = true;
                System.out.println(e + " " + ch);
                DFS2(e);
                if (used) {
                    ch++;
                    used = false;
                }

            }
        }
    }

    public SegTreeMax stm;

    public void initSegTree() {
        stm = new SegTreeMax(base.length - 1, base);
    }

    public void change(int i, int val) {
        stm.update(w[i], val);
    }

    public int[][] dp;
    int N;
    
    public void initLCA() {
        dp = new int[N + 1][(int) (Math.log(N) / Math.log(2)) + 1];
        for (int i = 1; i < N; i++) {
            dp[i][0] = 
                    n[i].par;
        }

        for (int i = 1; i < dp[0].length; i++) {
            for (int j = 1; j <= N; j++) {
                if (dp[j][i - 1] != -1) {
                    dp[j][i] = dp[dp[j][i - 1]][i - 1];
                }
            }
        }
    }
    
    public int LCA(int a, int b) {
        if(n[a].depth < n[b].depth){
            int temp = a;
            a = b;
            b = temp;
        }
        
        int log = (int)(Math.log(n[a].depth)/Math.log(2));
        
        for (int i = log; i >= 0; i--) {
            if(n[a].depth - (1<<i) >= n[b].depth){
                a = dp[a][i];
            }
        }
        
        if(a == b){
            return a;
        }
        
        for (int i = log; i >= 0; i--) {
            if(dp[a][i] != -1 && dp[a][i] != dp[b][i]){
                a = dp[a][i];
                b = dp[b][i];
            }
        }
        
        return n[a].par;
    }

    public int getMax(int u, int v) {
        int tar = LCA(u, v);
        System.out.println("TAR " + tar);
        int max = 0;
        while(n[u].chain != n[tar].chain){
            System.out.println(stm.query(1, 1, N-1, loc[chaintop[n[u].chain]], loc[u]));
            max = Math.max(max, stm.query(1, 1, N-1, loc[chaintop[n[u].chain]], loc[u]));
            u = n[chaintop[n[u].chain]].par;
        }
        while(n[v].chain != n[tar].chain){
            System.out.println("B QUERY = " + loc[chaintop[n[v].chain]] + " " + loc[v]);
            max = Math.max(max, stm.query(1, 1, N-1,  loc[chaintop[n[v].chain]],loc[v]));
            v = n[chaintop[n[v].chain]].par;
        }
        
        System.out.println("FINAL = " + w[tar] + " " + w[v]);
        
        max = Math.max(max, stm.query(1, 1, N-1, loc[tar]+1, loc[v]));
        System.out.println("IND 1 = " + max);
        max = Math.max(max, stm.query(1, 1, N-1, loc[tar]+1, loc[u]));
        System.out.println("2 = " + max);
        
        return max;
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

    class trip implements Comparable<trip> {

        int a, b, c, d;

        public trip(int _a, int _b, int _c) {
            this.a = _a;
            this.b = _b;
            this.c = _c;
        }

        public trip(int _a, int _b, int _c, int _d) {
            this.a = _a;
            this.b = _b;
            this.c = _c;
            this.d = _d;
        }

        @Override
        public int compareTo(trip t) {
            return (a == t.a) ? (b == t.b) ? c - t.c : t.b - b : a - t.a;
        }
    }

    public class SegTreeMax {

        public int[] tree;
        public int[] d;
        public int[] ind;

        public SegTreeMax(int N, int[] d) {
            tree = new int[(N + 1) * 4];
            ind = new int[N + 1];
            this.d = d;
            build(1, 1, N);
        }

        int build(int node, int l, int r) {
            System.out.println(node + " " + l + " " + r);
            int mid = (l + r) >> 1;
            if (l == r) {
                ind[l] = node;
                System.out.println("NODING " + node + " " + l + " " + d[l]);
                return (tree[node] = d[l]);
            }
            return (tree[node] = Math.max(build(node * 2, l, mid), build(node * 2 + 1, mid + 1, r)));
        }

        void update(int i, int val) {
            for (int j = ind[i]; j > 0; j >>= 1) {
                tree[j] = Math.max(tree[j], val);
            }
        }

        int query(int node, int l, int r, int start, int end) {
            System.out.println(l + " " + r);
            int mid = (l + r) >> 1;
            if (l >= start && r <= end) {
                System.out.println("RETURNING " + node + " " + tree[node]);
                return tree[node];
            } else if (l > end || r < start || l == r) {
                return 0;
            }
            return Math.max(query(node * 2, l, mid, start, end), query(node * 2 + 1, mid + 1, r, start, end));
        }

    }

}
