/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.Arrays;

/**
 * © Mehul Raheja
 */
public class MST {

    public static class trip implements Comparable<trip> {

        int a, b, c;

        public trip(int _a, int _b, int _c) {
            this.a = _a;
            this.b = _b;
            this.c = _c;
        }

        @Override
        public int compareTo(trip t) {
            return c - t.c;
        }
    }

    class pair implements Comparable<pair>{
        trip e;
        int i;

        @Override
        public int compareTo(pair t) {
            return e.compareTo(t.e);
        }
        
    }
    public int[] kruskal(int N, trip[] edge) {
        UnionFind uf = new UnionFind(N);
        for (int i = 1; i <= N; i++) {
            uf.createset(i);
        }
        pair[] p = new pair[edge.length];
        for (int i = 0; i < edge.length; i++) {
            p[i] = new pair();
            p[i].e = edge[i];
            p[i].i = i;
        }
        
        Arrays.sort(p);
        int[] ans = new int[N - 1];
        int ind = -1;
        for (int i = 0; i < edge.length && ind < N - 2; i++) {
            int u = p[i].e.a;
            int v = p[i].e.b;
            if (uf.find(u) == uf.find(v)){
                continue;
            }else{
                uf.merge(u, v);
                ans[++ind] = p[i].i;
            }
        }
        return ans;
    }

    class UnionFind {

        int[] p;
        int[] rank;

        public UnionFind(int N) {
            p = new int[N + 1];
            rank = new int[N + 1];
        }

        public void createset(int x) {
            p[x] = x;
            rank[x] = 0;
        }

        public int find(int x) {
            if (x != p[x]) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public void merge(int x, int y) {
            int PX = p[x];
            int PY = p[y];
            if (rank[PX] > rank[PY]) {
                p[PY] = PX;
            } else if (rank[PX] < rank[PY]) {
                p[PX] = PY;
            } else {
                p[PX] = PY;
                rank[PY]++;
            }
        }
    }
}
