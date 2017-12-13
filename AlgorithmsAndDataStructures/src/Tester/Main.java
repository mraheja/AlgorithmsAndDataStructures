/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import AdditionalAlgorithms.Inversions;
import AdditionalAlgorithms.RelativeData;
import NumberTheory.*;
import Trees.Algorithms.*;
import Trees.DataStructures.BIT;
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
    }
}
