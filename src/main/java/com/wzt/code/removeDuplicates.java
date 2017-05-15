package com.wzt.code;

/**
 * Created by wzt on 2017/5/10.
 */
public class removeDuplicates {
    //this is a sorted array
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int temp = nums[0];
        int length = nums.length;
        for(int i = 1; i < length; i++) {
            if(nums[i] == temp) {
                int j = i;
                while(j < nums.length-1) {
                    nums[j] = nums[j+1];
                    j++;
                }
                i--;
                length--;
            }
            else {
                temp = nums[i];
            }
        }
        return length;
    }

    public static int removeDulicates_better(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    public static int removeDuplicates_best_best(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }

    public static int removeDuplicates_best(int[] nums) {
        if (nums.length==0) return 0;
        int j=0;
        for (int i=0; i<nums.length; i++)
            if (nums[i]!=nums[j]) nums[++j]=nums[i];
        return ++j;
    }

    public static void main(String[] args) {
        int[] num = {1,1,1,2};
        System.out.printf("num's new length: %d\n", removeDuplicates(num));
        System.out.printf("num's new length: %d\n", removeDuplicates_best(num));
    }
}
