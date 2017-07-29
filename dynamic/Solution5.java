package dynamic;


import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by shu on 2017/7/29.
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 For example,
 Given[100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 Your algorithm should run in O(n) complexity.
 */
public class Solution5 {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int m : num) {
            set.add(m);
        }

        Iterator<Integer> it = set.iterator();
        int first = it.hasNext() ? it.next() : 0;
        int maxLength = 1;

        while (it.hasNext()) {
            int counts = 1;
            int temp = it.next();
            while ( (temp - first) == 1) {
                ++counts;
                if (!it.hasNext()) {
                    break;
                }
                first = temp;
                temp = it.next();
            }

            first = temp;
            maxLength = counts > maxLength ? counts : maxLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestConsecutive(new int[]{9,1,-3,2,4,8,3,-1,6,-2,-4,7}));
    }
}
