package com.shinstealler.talkative.etc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Candy {
    // public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    //     List<Boolean> boolList = new ArrayList<>();
    //     int max = 0;
        
    //     for (int candy : candies) {
    //         max = Math.max(candy, max);
    //     }

    //     for (int candy : candies) {
    //         if (candy + extraCandies >= max) {
    //             boolList.add(true);
    //         }else{
    //             boolList.add(false);
    //         }
    //     }

    //     return boolList;

    // }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= max).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] candies = { 4, 2, 1, 1, 2 };
        int extraCandies = 1;

        Candy candy = new Candy();
        List<Boolean> result = candy.kidsWithCandies(candies, extraCandies);

        System.out.println(result);

    }
}