package dynamic;

import java.util.ArrayList;

/**
 * Created by shu on 2017/7/29.
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]

 The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Solution6 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < i + 1; ++j) {
                triangle.get(i).add(j, triangle.get(i).get(j) + (triangle.get(i + 1).get(j + 1) > triangle.get(i + 1).get(j) ? triangle.get(i + 1).get(j) : triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }
}
