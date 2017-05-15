package com.wzt.code;

/**
 * Created by wzt on 2017/5/15.
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int flag = -1;
        int i;
        for(i = 0; i < nums.length; i++) {
            if(target <= nums[i]) {
                flag = i;
                break;
            }
        }
        if(flag == -1) {
            return i;
        } else {
            return  flag;
        }
    }

    public static int searchInsertBest(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int middle;
        int low = 0, high = nums.length-1;
        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] < target)
                low = middle + 1;
            else
                high = middle - 1;
        }
        return high + 1;
    }


    public static void main(String[] args) {
        int[] nums = {1};
        System.out.printf("%d \n", searchInsert(nums, 2));
        System.out.printf("%d \n", searchInsertBest(nums, 2));
    }
}
