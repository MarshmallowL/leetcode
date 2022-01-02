package com.liugs.algorithm;

import java.util.Arrays;

/**
 * @author liugs
 * @createTime 2021/12/26 23:11
 */
public class KMP_Str_Match {
    public static void main(String[] args) {
        char[] pArray = new char[]{'a','b','c','a','b','d','d','d','a','b','c','a','b','c'};
        KMP_Str_Match smp = new KMP_Str_Match();
        String s = "abcbasijfodqweooijfoqijfjqwf";
        String p = "ijfoqij";
        System.out.println(smp.search(s,p));
    }

    public int search(String s,String p){
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        int[] next = getNextArray(P);
        int i = 0,j = 0;
        while (j < S.length){
            if (S[j] == P[i]){
                i++;j++;
            }else if (i != 0){
                i = next[i - 1];
            }else{
                j++;
            }
            if (i == P.length){
                return j - i;
            }
        }
        return -1;
    }

    private int[] getNextArray(char[] p){
        int pLen = p.length;
        int[] next = new int[pLen+1];
        int i = 1,now = 0;
        while (i < pLen){
            if (p[i] == p[now]){
                 now++;
                 next[i] = now;
                 i++;
            }else if (now != 0){
                now = next[now -1];
            }else {
                i++;
                next[i] = now;
            }
        }
        return next;
    }
}
