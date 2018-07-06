/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Tarjan {

    int[] low;
    int[] val;
    int T;
    ArrayList<Integer>[] al;
   

    public Tarjan(ArrayList<Integer>[] al) {
        this.al = al;
        int N = al.length;
        low = new int[N + 1];
        val = new int[N + 1];
        T = 1;
        Arrays.fill(val, -1);
        Arrays.fill(low, -1);
        TarjanU(1, -1);
        System.out.println(Arrays.toString(val));
        System.out.println(Arrays.toString(low));
    }

    public void TarjanU(int i, int p) {
        System.out.println(i);
        low[i] = val[i] = T++;

        for (int e : al[i]) {
            if (e != p) {
                if (val[e] == -1) {
                    TarjanU(e,i);
                    low[i] = min(low[i], low[e]);
                } else {
                    low[i] = min(low[i], val[e]);
                }
            }
        }
        
    }

}
