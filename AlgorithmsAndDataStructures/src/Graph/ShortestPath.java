/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.*;

/**
 * © Mehul Raheja
 */
public class ShortestPath {

    public static class pair implements Comparable<pair> {

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
    
    public static class trip implements Comparable<pair> {

        int a, b, c;

        public trip(int _a, int _b, int _c) {
            this.a = _a;
            this.b = _b;
            this.c = _c;
        }

        @Override
        public int compareTo(pair t) {
            return (a == t.a) ? b - t.b : a - t.a;
        }
    }

    public int dijk(ArrayList<pair>[] al, int s, int t) {
        PriorityQueue<pair> pq = new PriorityQueue();
        pq.add(new pair(0, s));
        int[] key = new int[al.length + 1];
        for (int i = 0; i < key.length; i++) {
            key[i] = Integer.MAX_VALUE;
        }
        boolean[] v = new boolean[al.length + 1];
        key[s] = 0;
        while (!pq.isEmpty()) {
            pair cur = pq.poll();
            if (v[cur.b]) {
                continue;
            }
            v[cur.b] = true;

            for (pair e : al[cur.b]) {
                if (key[e.a] > key[cur.b] + e.b) {
                    key[e.a] = key[cur.b] + e.b;
                    pq.add(new pair(key[e.a], e.a));
                }
            }
        }

        return key[t];
    }

    public int[][] floids(int N, int[][] am) {

        int[][] full = new int[N + 1][N + 1];
        for (int i = 0; i < full.length; i++) {
            full[i] = Arrays.copyOf(am[i], full[i].length);
        }
        
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= N; k++) {
                    if (full[j][i] + full[i][k] < full[j][k]) {
                        full[j][k] = full[j][i] + full[i][k];
                    }
                }
            }
        }

        return full;
    }
    
    public int bellmanford(ArrayList<trip> edges, int N, int s, int t){
        int[] d = new int[N+1];
        Arrays.fill(d, 1<<30);
        d[s] = 0;
        
        for (int i = 0; i < N-1; i++) {
            for(trip e: edges){
                int u = e.a, v = e.b, c = e.c;
                if(d[u] + e.c < d[v]){
                    d[v] = d[u] + e.c;
                }
            }
        }
        
        return d[t];
    }
    
    
}
