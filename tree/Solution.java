package leetCode.tree;

import java.util.ArrayList;

/**
 * Created by shu on 2017/7/25.
 *
 */
public class Solution {

    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }
}
