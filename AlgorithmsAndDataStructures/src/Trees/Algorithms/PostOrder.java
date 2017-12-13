/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Trees.Algorithms;

import java.util.*;
import java.io.*;

/**
 *  © Mehul Raheja
 */

public class PostOrder {
    ArrayList<Integer>[] al;
    int N;
    public int[] trav;
    public int[] start;
    public int[] len;
    
    public PostOrder(ArrayList<Integer>[] al){
        this.N = al.length-1;
        this.al = al;
        trav = new int[N+1];
        start = new int[N+1];
        Arrays.fill(start, -1);
        len = new int[N+1];
        DFS(1);
    }
    
    int ind = 1;
    int DFS(int i){
        int size = 1;
        trav[ind] = i;
        start[i] = ind++;
        for (int e: al[i]) {
            if(start[e] == -1){
                size += DFS(e);
            }
        }
        len[i] = size;
        return size;
    }
}
