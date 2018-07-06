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

public class PriorityBFS {

    public static void BFS(int s, int N, ArrayList<pair>[] al) {
        boolean[] v = new boolean[N];
        PriorityQueue<pair> q = new PriorityQueue<pair>();
        q.add(new pair(0, s));
        while (!q.isEmpty()) {
            int ind = q.poll().b;
            int len = q.poll().a;
            if (v[ind]) {
                continue;
            }
            v[ind] = true;

            /*
            Insert functions here
             */
            
            for (pair p : al[ind]) {
                if (!v[p.a]) {
                    q.add(new pair(len + p.b, p.a));
                }
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
