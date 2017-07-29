package dynamic;

/**
 * Created by shu on 2017/7/29.
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class Solution4 {
    public int singleNumber(int[] A) {
        int singleNum = A[0];
        for (int i = 1; i < A.length; ++i) {
            singleNum ^= A[i];
        }
        return singleNum;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.singleNumber(new int[]{1, 1, 2, 3, 3}));
    }
}
