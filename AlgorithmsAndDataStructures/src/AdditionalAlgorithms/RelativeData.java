/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AdditionalAlgorithms;

import java.util.Arrays;

/**
 *  © Mehul Raheja
 */
public class RelativeData {
    public int[] toRel(int[] d){
        pair[] p = new pair[d.length];
        for (int i = 0; i < d.length; i++) {
            p[i] = new pair(d[i],i+1);
        }
        Arrays.sort(p);
        int[] fin = new int[d.length];
        for (int i = 0; i < d.length; i++) {
            fin[i] = p[i].b;
        }
        return fin;
    }
}

class pair implements Comparable<pair> {
    
    int a, b;
    
    public pair(int _a, int _b) {
        this.a = _a;
        this.b = _b;
    }
    
    @Override
    public int compareTo(pair t) {
        return (a == t.a) ? b - t.b : a - t.a;
    }
}
