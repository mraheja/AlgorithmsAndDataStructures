/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SystemsOfEquations;

/**
 *  © Mehul Raheja
 */
public class CrammersRule {

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
