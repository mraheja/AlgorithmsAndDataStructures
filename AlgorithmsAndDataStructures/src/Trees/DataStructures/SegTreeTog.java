/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees.DataStructures;

/**
 * © Mehul Raheja
 */
public class SegTreeTog {

    int[] tree;
    int[] lazy;
    int[] d;

    public SegTreeTog(int N) {
        tree = new int[N * 4 + 5];
        lazy = new int[N * 4 + 5];
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
            if (lazy[node] % 2 == 1) {
                tree[node] = (r - l + 1) - tree[node];
            }
            if (l != r) {
                lazy[nl] += lazy[node];
                lazy[nr] += lazy[node];
            }
            lazy[node] = 0;
        }
        if (start <= l && r <= end) {
            lazy[node] += val;
            if (lazy[node] % 2 == 1) {
                tree[node] = (r - l + 1) - tree[node];
            }
            if (l != r) {
                lazy[nl] += val;
                lazy[nr] += val;
            }
            lazy[node] = 0;
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
            if (lazy[node] % 2 == 1) {
                tree[node] = (r - l + 1) - tree[node];
            }
            if (l != r) {
                lazy[nl] += lazy[node];
                lazy[nr] += lazy[node];
            }
            lazy[node] = 0;
        }
        if (start <= l && r <= end) {
            //System.out.println("RETURING " + tree[node] + " " + l + " " + r);
            return tree[node];
        } else if (l > end || r < start || l == r) {
            return 0;
        }

        return query(nl, l, mid, start, end) + query(nr, mid + 1, r, start, end);
    }
}
