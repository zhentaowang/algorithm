package com.wzt.code;

/**
 * Created by wzt on 2017/5/15.
 */
public class strStr {
    public static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public int strStrBetter(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "I hate you !!!!!";
        System.out.printf("%d \n",strStr(haystack, "hae"));
    }
}
