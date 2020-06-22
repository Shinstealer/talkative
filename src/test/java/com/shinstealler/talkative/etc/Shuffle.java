package com.shinstealler.talkative.etc;

import java.util.Arrays;

public class Shuffle {

    public int[] shuffle(final int[] nums, final int n) {
        int[] shuffled = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                shuffled[i] = nums[i/2];
            }else{
                shuffled[i]= nums[n + i/2];
                
            }
        }

        return shuffled;

    }

    public static void main(final String[] args) {
        int[] nums = { 2, 5, 1, 3, 4, 7 };
        int n = 3;

        Shuffle sf = new Shuffle();
        int[] result =  sf.shuffle(nums, n);
        System.out.println(Arrays.toString(result));
    }

}