package dynamic;

import java.util.Arrays;

/**
 * Created by shu on 2017/7/29.
 * There are N children standing in a line. Each child is assigned a rating value.
 You are giving candies to these children subjected to the following requirements:
 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class Solution2 {
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int[] counts = new int[ratings.length];
        Arrays.fill(counts, 1);
        //从左往右，扫描
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i - 1] > ratings[i]) {
                counts[i - 1] = counts[i] + 1;
            }
        }

        //从右向左扫描
        int sum = 0;
        for (int i = ratings.length - 1; i > 0; --i) {
            sum += counts[i];
            //如果右边的权值大于左边，但是分发的糖果小于等于左边
            if (ratings[i] < ratings[i - 1] && counts[i] >= counts[i - 1]) {
                counts[i - 1] = counts[i] + 1;
            }
        }
        sum += counts[0];
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{2, 1}));
    }
}
