package dynamic;

import leetCode.tree.TreeLinkNode;

/**
 * Created by shu on 2017/7/29.
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 What if the given tree could be any binary tree? Would your previous solution still work?
 Note:
 You may only use constant extra space.

 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7

 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */
public class Solution7 {
    public void connect(TreeLinkNode root) {
        if (root ==  null) {
            return;
        }
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode cur;
        TreeLinkNode pre = dummy;

        for (cur = root; cur != null; cur = cur.next) {
            if (cur.left != null) {
                pre.next = cur.left;
                pre = pre.next;
            }

            if (cur.right != null) {
                pre.next = cur.right;
                pre = pre.next;
            }
        }
        connect(dummy.next);
    }
}
