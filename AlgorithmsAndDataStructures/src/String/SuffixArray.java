/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

/**
 * © Mehul Raheja
 */
public class SuffixArray {

    public final int cuttoff = 5;
    int n;
    String t;
    int[] ind;

    public int[] suff(String t) {
        n = t.length();
        this.t = t;
        ind = new int[n];
        for (int i = 0; i < n; i++) {
            ind[i] = i;
        }

        sort(0, n - 1, 0);
        return ind;
    }

    public void sort(int lo, int hi, int d) {
        if (hi <= lo + cuttoff) {
            insertion(lo, hi, d);
            return;
        }

        int lt = lo;
        int gt = hi;
        char v = t.charAt(ind[lo] + d);
        int i = lo + 1;
        while(i <= gt){
            char temp = t.charAt(ind[i] + d);
            if(temp < v){
                exch(lt++,i++);
            }else if(temp > v){
                exch(i, gt--);
            }else{
                i++;
            }
        }
        
        sort(lo,lt-1,d);
        if(v > 0){
            sort(lt,gt,d+1);
        }
        sort(gt+1,hi,d);
    }

    public void insertion(int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(ind[j], ind[j - 1], d); j--) {
                exch(j, j - 1);
            }
        }
    }

    public boolean less(int i, int j, int d) {
        if (i == j) {
            return false;
        }
        i += d;
        j += d;
        while (i < n && j < n) {
            if (t.charAt(i) < t.charAt(j))
                return true;
            if (t.charAt(i) > t.charAt(j))
                return false;
            i++;
            j++;
        }
        return i > j;
    }

    public void exch(int i, int j) {
        ind[i] ^= ind[j];
        ind[j] ^= ind[i];
        ind[i] ^= ind[j];
    }
    
    public int lcp(int i, int j){
        int len = 0;
        while(i < n && j < n){
            if(t.charAt(i) != t.charAt(j)){
                return len;
            }
            i++;
            j++;
            len++;
        }
        return len;
    }
}
