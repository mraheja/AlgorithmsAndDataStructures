/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import AdditionalAlgorithms.Inversions;
import AdditionalAlgorithms.RelativeData;
import DynamicProgramming.Knapsack;
import DynamicProgramming.LongestCommonSubsequence;
import DynamicProgramming.LongestIncreasingSubsequence;
import DynamicProgramming.PrefixSums;
import NumberTheory.*;
import Trees.Algorithms.*;
import Trees.DataStructures.BIT;
import Trees.DataStructures.HeavyLightDecomp;
import Trees.DataStructures.SegTreeofSegTreeSum;
import java.util.*;
import java.io.*;

/**
 * © Mehul Raheja
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //System.out.println("hi");
//        Combinations e = new Combinations();
//        int MOD = 7;
//        
//        e.precomp(10, MOD);
//        long ans2 = e.nCr(5, 2, MOD);
//        System.out.println(ans2);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        ArrayList<Integer>[] al = new ArrayList[N+1];
//        for (int i = 0; i <= N; i++) {
//            al[i] = new ArrayList<Integer>();
//        }
//        for (int i = 0; i < N-1; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            al[a].add(b);
//            al[b].add(a);
//        }
//        
//        LCA l = new LCA(N,al);
//        System.out.println(l.LCA(7, 5));

//          int[] d = {0,3,4,5,2};
//          BIT b = new BIT(4,d);
//          b.update(2, 1);
//          System.out.println(b.query(3) - b.query(1));
//        int[][] d = {{0, 0, 0, 0}, {0, 1, 2, 3}, {0, 4, 5, 6}, {0, 1, 2, 3}};
//        SegTreeofSegTreeSum lol = new SegTreeofSegTreeSum(3, 3, d);
//        for (int i = 1; i <= 3; i++) {
//            for (int j = 1; j <= 3; j++) {
//                System.out.print(lol.query(1, 1, 3, i, i, j, j) + " ");
//            }
//            System.out.println("");
//        }
//        
//        lol.update(1, 1, 3, 2, 3, 1, 2, 1);
//        
//        System.out.println("");
//        for (int i = 1; i <= 3; i++) {
//            for (int j = 1; j <= 3; j++) {
//                System.out.print(lol.query(1, 1, 3, i, i, j, j) + " ");
//            }
//            System.out.println("");
//        }
//        
//        System.out.println(lol.query(1, 1, 3, 2, 3, 1, 2));
//        int[] d = {3,1,-9,-10};
        // int[] x = (new RelativeData()).toRel(d);
        // System.out.println(new Inversions().inv(d));
        //System.out.println(lol.query(1, 1, 3, 1, 1, 1, 1));
//        PostOrder po = new PostOrder(al);
//        System.out.println(Arrays.toString(po.trav));
//        System.out.println(Arrays.toString(po.start));
//        System.out.println(Arrays.toString(po.len));
//        int[] x = {3,2};
//        Knapsack k = new Knapsack();
//        System.out.println(Arrays.toString(k.limknap(x, 10)));
//        
//        PrefixSums ps = new PrefixSums();
//        int[][] y = {{1,2,3},{4,2,1},{2,1,1}};
//        int[][] p = ps.pref(y);
//        for (int[] e: p) {
//            System.out.println(Arrays.toString(e));
//        }
//        
//        System.out.println(ps.query(p, 1, 1, 1, 2));
//            LongestCommonSubsequence lcs = new LongestCommonSubsequence();
//            String s1 = "AGGTAB";
//            String s2 = "GXTXAYB";
//            int[] d = {1,2,1,3,1,4,6};
//            //int l = lcs.lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
//            LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
//            System.out.println(lis.lis(d));
        BufferedReader br = new BufferedReader(new FileReader("hld.in"));
        int N = Integer.parseInt(br.readLine().trim());
        HeavyLightDecomp hld = new HeavyLightDecomp(N);
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            hld.addEdge(a, b, c);
        }

        hld.DFS(1);
        hld.DFS2(1);
        hld.initSegTree();
        
        System.out.println(Arrays.toString(hld.base));
        
       // hld.change(9, 100);
       // System.out.println(Arrays.toString(hld.stm.tree));
        //System.out.println(Arrays.toString(hld.chaintop));
        hld.initLCA();
        System.out.println("LOC 4 = " + hld.loc[4]);
        System.out.println("LOC = " + Arrays.toString(hld.loc));
        System.out.println(hld.n[6].chain);
        System.out.println(hld.n[2].chain);
        hld.change(5, 30);
        System.out.println(hld.getMax(10, 1));
//        
//        for (int i = 0; i < hld.n.length; i++) {
//            System.out.println(i + " " + hld.n[i].chain);
//        }
        //System.out.println(Arrays.toString(hld.w));

        // System.out.println(Arrays.toString(hld.base));
//        int[] d = {0, 1, 2, 4, 3};
//
//        SegTreeMax seg = new SegTreeMax(4, d);
//        System.out.println(Arrays.toString(seg.tree));
//       // seg.update(1, 6);
//        int ans = seg.query(1, 1, 4, 1, 4);
//        System.out.println(ans);

    }
}

class SegTreeMax {

    int[] tree;
    int[] d;
    int[] ind;

    public SegTreeMax(int N, int[] d) {
        tree = new int[(N + 1) * 4];
        ind = new int[N + 1];
        this.d = d;
        build(1, 1, N);
    }

    int build(int node, int l, int r) {
        int mid = (l + r) >> 1;
        if (l == r) {
            ind[l] = node;
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
        int mid = (l + r) >> 1;
        if (l >= start && r <= end) {
            return tree[node];
        } else if (l > end || r < start) {
            return 0;
        }
        return Math.max(query(node * 2, l, mid, start, end), query(node * 2 + 1, mid + 1, r, start, end));
    }

}
