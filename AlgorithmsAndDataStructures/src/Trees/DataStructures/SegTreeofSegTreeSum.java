/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees.DataStructures;

/**
 * © Mehul Raheja
 */
public class SegTreeofSegTreeSum {

    int N, M;
    SSI[] tree;
    int[] lazy;
    int[][] d;

    public SegTreeofSegTreeSum(int N, int M, int[][] d) {
        tree = new SSI[N * 4 + 1];
        lazy = new int[N * 4 + 1];
        this.N = N;
        this.M = M;
        this.d = d;
        build(1, 1, N);
    }

    public int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }
    
    public SSI merge(SSI a, SSI b){
        SSI ret = new SSI();
        ret.tree = merge(a.tree,b.tree);
        ret.lazy = merge(a.lazy,b.lazy);
        return ret;
    }

    public SSI build(int node, int l, int r) {
        if (l == r) {
            return (tree[node] = new SSI(M, d[l]));
        }
        int nl = node * 2;
        int nr = node * 2 + 1;
        int mid = (l + r) >> 1;
        tree[node] = merge(build(nl, l, mid), build(nr, mid + 1, r));
        return tree[node];
    }

    public void update(int node, int l, int r, int start, int end, int start2, int end2, int val) {
        int nl = node * 2, nr = node * 2 + 1, mid = (l + r) >> 1;
        if (lazy[node] != 0) {
            tree[node].update(1, 1, M, start2, end2, lazy[node] * (r - l + 1));
            if (l != r) {
                lazy[nl] += lazy[node];
                lazy[nr] += lazy[node];
            }
            lazy[node] = 0;
        }
        if (start <= l && r <= end) {
            tree[node].update(1, 1, M, start2, end2, val * (r - l + 1));
            if (l != r) {
                lazy[nl] += val;
                lazy[nr] += val;
            }
            return;
        } else if (l > end || r < start || l == r) {
            return;
        }

        update(nl, l, mid, start, end,start2,end2,val);
        update(nr, mid + 1, r, start, end,start2,end2, val);
        tree[node] = merge(tree[nl], tree[nr]);
    }

    public int query(int node, int l, int r, int start, int end, int start2, int end2) {
        int nl = node * 2, nr = node * 2 + 1, mid = (l + r) >> 1;
        if (lazy[node] != 0) {
            tree[node].update(1, 1, M, start2, end2, lazy[node] * (r - l + 1));
            if (l != r) {
                lazy[nl] += lazy[node];
                lazy[nr] += lazy[node];
            }
            lazy[node] = 0;
        }
        if (start <= l && r <= end) {
            return tree[node].query(1, 1, N, start2, end2);
        } else if (l > end || r < start || l == r) {
            return 0;
        }

        return query(nl, l, mid, start, end,start2,end2) + query(nr, mid + 1, r, start, end,start2,end2);
    }

}

class SSI {

    int[] tree;
    int[] lazy;
    int[] d;

    public SSI(){
        
    }
    
    public SSI(int N, int[] d) {
        tree = new int[N * 4 + 1];
        lazy = new int[N * 4 + 1];
        this.d = d;
        build(1, 1, N);
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
