package leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by shu on 2017/7/25.
 *
 */
public class SolutionSumPath {
    private static LinkedList<Integer> queue = new LinkedList<Integer>();
    private static ArrayList<Integer> list = new ArrayList<Integer>();

    public static int sumNumbers(TreeNode root) {
        sumOfOnePath(root);
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    private static void sumOfOnePath(TreeNode root) {
        if (root != null) {
            queue.add(root.val);
            sumOfOnePath(root.left);
            sumOfOnePath(root.right);

            if (root.left == null && root.right == null) {
                int sum = 0;
                int counts = queue.size();
                for (int i = 0; i < counts; ++i) {
                    sum += queue.get(i) * Math.pow(10, counts- i - 1);
                }
                list.add(sum);
            }
            queue.removeLast();
        }
    }

    public static void main(String[] args) {
        TreeNode pNode = new TreeNode(4);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(0);
        pNode.left = t1;
        pNode.right = t2;
        t1.left = t3;
        System.out.println(sumNumbers(pNode));
    }
}
