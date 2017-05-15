package com.wzt.code;

/**
 * Created by wzt on 2017/5/11.
 */
public class removeElement {

    public static int removeElement(int[] nums, int val) {
        int begin = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != val)
                nums[begin++] = nums[i];
        return begin;
    }

    public  static int removeElementBest(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = {3,2,2,3};
        int val = 3;
//        System.out.printf("%d\n", removeElement(nums, val));
        System.out.printf("%d\n", removeElementBest(nums, val));
    }
}
