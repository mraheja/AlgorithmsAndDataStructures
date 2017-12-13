/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalAlgorithms;

import java.util.Arrays;

/**
 * © Mehul Raheja
 */
public class Inversions {

    class BIT {

        int[] tree;
        int N;

        public BIT(int N) {
            this.N = N;
            tree = new int[N + 1];
        }

        public BIT(int N, int[] d) {
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

    public int[] toRel(int[] d) {
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

    public int inv(int[] d) {
        int ans = 0;
        int N = d.length;
        int[] x = toRel(d);
        BIT b = new BIT(N + 1);

        for (int i = N - 1; i >= 0; i--) {
            ans += b.query(x[i]);
            b.update(x[i], 1);
        }

        return ans;
    }

}
