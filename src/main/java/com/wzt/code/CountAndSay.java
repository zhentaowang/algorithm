package com.wzt.code;

/**
 * Created by wzt on 2017/5/15.
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < n; i++){
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);

            for (int j = 1, len = prev.length(); j < len; j++){
                if (prev.charAt(j) != say){
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                }
                else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }

    public static String countAndSayBetter(int n) {
        if (n <= 0) return "";

        String number = "1";
        for (int i = 1; i < n; i++) {
            number = nextNumber(number);
        }
        return number;
    }

    private static String nextNumber(String number) {
        char[] source = number.toCharArray();
        char old = source[0];
        int count = 0;
        StringBuilder builder = new StringBuilder();

        for (char current : source) {
            if (current == old) {
                count++;
            } else {
                builder.append(count).append(old);
                old = current;
                count = 1;
            }
        }
        builder.append(count).append(old);

        return builder.toString();
    }

    public static void main(String[] args) {
        int strSequenceNum = 5;
        System.out.printf("%s \n", countAndSay(strSequenceNum));
        System.out.printf("%s \n", countAndSayBetter(strSequenceNum));
    }
}
