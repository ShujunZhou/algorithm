package leetCode.tree;

/**
 * Created by shu on 2017/7/25.
 *
 */
public class MaxPathSum {
    private int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathValue(root);
        return maxValue;
    }

    public int maxPathValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左子树的最大值
        int leftValue = Math.max(0, maxPathValue(root.left));
        //右子数最大值
        int rightValue = Math.max(0, maxPathValue(root.right));
        //左右整体最大值
        maxValue = Math.max(maxValue, leftValue + rightValue + root.val);

        return Math.max(leftValue, rightValue) + root.val;
    }
}
