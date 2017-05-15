package com.wzt.code;

import static java.lang.Math.log;
import static java.lang.Math.min;

/**
 * Created by wzt on 2017/5/8.
 */
public class containerWithMaxWater {
    public static int maxArea(int[] height) {
        Integer max = 0;
        int i = 0;
        int j = height.length - 1;
        while(i < j) {
            int loMax = height[i];
            int hiMax = height[j];
            max = Math.max(Math.min(height[i], height[j]) * (j - i), max);

            // without this, Time Limit Exceeded will occur
            if (height[i] <= height[j]){
                while(i < j && height[i] <= loMax){
                    i++;
                }
            }
            else {
                while (i < j && height[j] <= hiMax) {
                    j--;
                }
            }
        }
        return max;
    }

    public static int maxAreaBetter(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int loMax = height[i];
            int hiMax = height[j];
            max = Math.max(Math.min(height[i], height[j]) * (j - i), max);

            // without this, TLE will occur
            if (height[i] <= height[j])
                while (i < j && height[i] <= loMax) ++i;
            else
                while (i < j && height[j] <= hiMax) --j;
        }

        return max;
    }

    public static int maxAreaInimitableness(int[] height) {
        int area;
        int maxArea = 0;
        int srt = 0;
        int end = height.length - 1;

        while (srt < end)
        {
            int tmp;

            if (height[srt] < height[end])
            {
                area = (end - srt) * height[srt];
                tmp = srt++;
                while (height[srt] < height[tmp] && srt < end)
                    srt++;
            }
            else
            {
                area = (end - srt) * height[end];
                tmp = end--;
                while (height[end] < height[tmp] && srt < end)
                    end--;
            }
            maxArea = area > maxArea ? area : maxArea;
        }
        return maxArea;
    }

    public static int maxAreaPerfect(int[] height) {
        int front = 0;
        int end = height.length-1;
        int a = 0;
        while(end > front){
            int left = height[front];
            int right = height[end];
            a = Math.max(a, Math.min(left,right)*(end - front));
            if(left < right){
                while(height[front] <= left && front++ < height.length - 1);
            }
            else{
                while(height[end] <= right && end-- > 0);
            }
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        int[] ss = {1,1};
        System.out.printf("%d\n",maxArea(ss));
        System.out.printf("%d\n",maxAreaBetter(ss));
    }
}
