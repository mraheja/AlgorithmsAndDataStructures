/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees.DataStructures;

/**
 * © Mehul Raheja
 */
public class FenwickOfFenwick {

    BITIn[] tree;
    int N;

    public FenwickOfFenwick(int N, int M) {
        this.N = N;
        tree = new BITIn[N + 1];
        for (int i = 1; i < tree.length; i++) {
            tree[i] = new BITIn(M);
        }
    }

    public FenwickOfFenwick(int N, int M, int[][] d) {
        this.N = N;  
        tree = new BITIn[N + 1];
        for (int i = 1; i < tree.length; i++) {
            tree[i] = new BITIn(M,d[i]);
        }
    }

    public int query(int K, int L) {
        int sum = 0;
        for (int i = K; i > 0; i -= (i & -i)) {
            sum += tree[i].query(L);
        }
        return sum;
    }

    public void update(int K, int L, int val) {
        for (int i = K; i <= N; i += (i & -i)) {
            tree[i].update(L, val);
        }
    }
}

class BITIn {

    int[] tree;
    int N;

    public BITIn(int N) {
        this.N = N;
        tree = new int[N + 1];
    }

    public BITIn(int N, int[] d) {
        this.N = N;
        tree = new int[N + 1];
        for (int i = 1; i < d.length; i++) {
            update(i, d[i]);
        }
    }

    public int query(int K) {
        int sum = 0;
        for (int i = K; i > 0; i -= (i & -i)) {
            sum += tree[i];
        }
        return sum;
    }

    public void update(int K, int val) {
        for (int i = K; i <= N; i += (i & -i)) {
            tree[i] += val;
        }
    }
}
