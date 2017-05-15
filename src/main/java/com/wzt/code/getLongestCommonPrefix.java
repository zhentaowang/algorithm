package com.wzt.code;

/**
 * Created by wzt on 2017/4/21.
 */
public class getLongestCommonPrefix {
    static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        for(int i = 0; i < strs[0].length(); i++){
            for(String str: strs) {
                if(str == null) return "";
                if(i > str.length()-1 || !strs[0].substring(0, i+1).equals(str.substring(0, i+1))){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    static String longestCommonPrefix_best(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }

    public static void main(String[] args) throws Exception {
        String[] test = {"aac","a","ccc"};
        System.out.println("are you ok ?");
        System.out.printf("%s\n", longestCommonPrefix_best(test));
        System.out.printf("%s\n", longestCommonPrefix(test));
    }
}
