package com.shinstealler.talkative.etc;

import java.util.Arrays;

public class Solution {

    public int[] runnningSum(int[] nums){
        if(nums ==null || nums.length == 0){
            return null;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = new int[4];
        nums[0] =1;
        nums[1] =2;
        nums[2] =3;
        nums[3] =4;

        Solution solution = new Solution();
        int[] result = solution.runnningSum(nums);
        System.out.println(Arrays.toString(result));   
    }

}