package leetCode.tree;

import java.util.ArrayList;
import java.util.Queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by shu on 2017/7/24.
 *
 */
public class PathofTree {
    private static int pathOftree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int minLeft = pathOftree(root.left);
        int minRight = pathOftree(root.right);
        if (minLeft == 0 || minRight == 0) {
            return minLeft >= minRight ? minLeft + 1 : minRight + 1;
        }

        return minLeft <= minRight ? minLeft + 1 : minRight + 1;
    }

    public static void main(String[] args) {
            TreeNode t = new TreeNode(1);
            TreeNode t1 = new TreeNode(2);
            TreeNode t2 = new TreeNode(3);
            t.left = t1;
            t1.right = t2;
            System.out.println(pathOftree(t));
    }
}
