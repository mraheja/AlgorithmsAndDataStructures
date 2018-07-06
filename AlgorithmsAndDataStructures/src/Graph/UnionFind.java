/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graph;

/**
 *  © Mehul Raheja
 */
public class UnionFind {
    int[] p;
    int[] rank;
    public UnionFind(int N){
        p = new int[N+1];
        rank = new int[N+1];
    }
    public void createset(int x){
        p[x] = x;
        rank[x] = 0;
    }
    public int find(int x){
        if(x != p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public void merge(int x, int y){
        int PX = p[x];
        int PY = p[y];
        if(rank[PX] > rank[PY]){
            p[PY] = PX;
        }else if(rank[PX] < rank[PY]){
            p[PX] = PY;
        }else{
            p[PX] = PY;
            rank[PY]++;
        }
    }
}
