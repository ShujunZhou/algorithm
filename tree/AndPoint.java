package leetCode.tree;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class AndPoint {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> list = new LinkedBlockingQueue<TreeLinkNode>();
        root.next = null;
        list.add(root);
        while (!list.isEmpty()) {
            int i = 1;
            while (i != 0) {
                TreeLinkNode newNode = list.remove();
                --i;
                if (newNode.left != null) {
                    list.add(newNode.left);
                    ++i;
                }
                if (newNode.right != null) {
                    list.add(newNode.right);
                    ++i;
                }
                if (newNode.left != null && newNode.right !=null) {
                    newNode.left.next = newNode.right;
                }
            }

        }
    }
}
