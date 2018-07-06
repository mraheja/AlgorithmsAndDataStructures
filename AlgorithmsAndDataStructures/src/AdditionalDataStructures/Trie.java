/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalDataStructures;

/**
 * © Mehul Raheja
 */
public class Trie {
    
    public v root = new v();

    public class v {

        int word = 0;
        int prefix = 0;
        v[] con = new v[26];

        public v() {
            for (int i = 0; i < con.length; i++) {
                con[i] = null;
            }
        }

        public void init(int a) {
            con[a] = new v();
        }
    }

    public void add(v v, char[] s, int i) {
        if (s.length == i) {
            v.word++;
        } else {
            v.prefix++;
            int k = s[i] - 'a';
            if (v.con[k] == null) {
                v.init(k);
            }
            add(v.con[k], s, i + 1);
        }
    }

    public int cword(v v, char[] s, int i) {
        if(s.length==i){
            return v.word;
        }else if(v.con[s[i] - 'a'] == null){
            return 0;
        }else{
            return cword(v.con[s[i] - 'a'],s,i+1);
        }
    }
    
    public int cpre(v v, char[] s, int i){
        if(s.length==i){
            return v.prefix;
        }else if(v.con[s[i] - 'a'] == null){
            return 0;
        }else{
            return cpre(v.con[s[i] - 'a'],s,i+1);
        }
    }
}
