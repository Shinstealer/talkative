package com.shinstealler.talkative.etc;

import java.util.ArrayList;
import java.util.List;

public class Candy {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> boolList = new ArrayList<>();
        int max = 0;
        
        for (int candy : candies) {
            max = Math.max(candy, max);
        }

        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                boolList.add(true);
            }else{
                boolList.add(false);
            }
        }

        return boolList;

    }

    public static void main(String[] args) {
        int[] candies = { 4, 2, 1, 1, 2 };
        int extraCandies = 1;

        Candy candy = new Candy();
        List<Boolean> result = candy.kidsWithCandies(candies, extraCandies);

        System.out.println(result);

    }
}