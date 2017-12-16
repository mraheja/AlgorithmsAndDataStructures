/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees.DataStructures;

/**
 * © Mehul Raheja
 */
public class FenwickOfSegTree {

    STS[] tree;
    int N;
    int M;

    public FenwickOfSegTree(int N, int M) {
        this.N = N;
        this.M = M;
        
        tree = new STS[N+1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new STS(M);
        }
    }

    int query(int K, int l, int r) {
        int sum = 0;
        for (int i = K; i > 0; i -= (i & -i)) {
            sum += tree[i].query(1, 1, M, l, r);
        }
        return sum;
    }

    void update(int K, int l, int r, int val) {
        for (int i = K; i <= N; i += (i & -i)) {
            tree[i].update(1, 1, M, l, r, val);
        }
    }

    class STS {

        int[] tree;
        int[] lazy;
        int[] d;

        public STS(int N) {
            tree = new int[N * 4 + 1];
            lazy = new int[N * 4 + 1];
        }

        public int build(int node, int l, int r) {
            if (l == r) {
                return (tree[node] = d[l]);
            }
            int nl = node * 2;
            int nr = node * 2 + 1;
            int mid = (l + r) >> 1;
            tree[node] = build(nl, l, mid) + build(nr, mid + 1, r);
            return tree[node];
        }

        public void update(int node, int l, int r, int start, int end, int val) {
            int nl = node * 2, nr = node * 2 + 1, mid = (l + r) >> 1;
            if (lazy[node] != 0) {
                tree[node] += lazy[node] * (r - l + 1);
                if (l != r) {
                    lazy[nl] += lazy[node];
                    lazy[nr] += lazy[node];
                }
                lazy[node] = 0;
            }
            if (start <= l && r <= end) {
                tree[node] += val * (r - l + 1);
                if (l != r) {
                    lazy[nl] += val;
                    lazy[nr] += val;
                }
                return;
            } else if (l > end || r < start || l == r) {
                return;
            }

            update(nl, l, mid, start, end, val);
            update(nr, mid + 1, r, start, end, val);
            tree[node] = tree[nl] + tree[nr];
        }

        public int query(int node, int l, int r, int start, int end) {
            int nl = node * 2, nr = node * 2 + 1, mid = (l + r) >> 1;
            if (lazy[node] != 0) {
                tree[node] += lazy[node];
                if (l != r) {
                    lazy[nl] += lazy[node];
                    lazy[nr] += lazy[node];
                }
                lazy[node] = 0;
            }
            if (start <= l && r <= end) {
                return tree[node];
            } else if (l > end || r < start || l == r) {
                return 0;
            }

            return query(nl, l, mid, start, end) + query(nr, mid + 1, r, start, end);
        }
    }
}
