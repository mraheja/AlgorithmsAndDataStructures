/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaxFlow;

/**
 * © Mehul Raheja
 */
import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import Tester.Main.pair;

public class FordFulkerson {

    int[] par;

    public int MaxFlow(int[][] am, int source, int sink) {
        int flow = 0;
        par = new int[am.length];

        int cur = 0;
        while ((cur = BFS(am, source, sink)) != 1 << 30) {
            System.out.println(cur);
            flow += cur;
        }
        return flow;
    }

    public int BFS(int[][] am, int source, int sink) {
        Queue<Integer> q = new LinkedList<Integer>();
        Arrays.fill(par, -1);
        q.add(source);
        boolean flag = false;
        par[source] = -2;
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.println(cur + " = CUR");
            if (cur == sink) {
                flag = true;
                break;
            }
            for (int i = 0; i < am.length; i++) {

                if (am[cur][i] != 0) {
                    if (par[i] == -1) {
                        par[i] = cur;
                        q.add(i);
                    }
                }
            }
            
            
        }

        System.out.println(Arrays.toString(par));
        if(!flag){
            return 1<<30;
        }
        
        
        int t = sink;
        int min = 1 << 30;
        while (t != source) {
            //System.out.println("NEXT = " + t);
            min = min(am[par[t]][t], min);
            t = par[t];
        }

        t = sink;
        while (t != source) {
            //System.out.println(par[t] + " " + t);
            am[par[t]][t] -= min;
            am[t][par[t]] += min;
            t = par[t];
        }
        return min;
    }

}
