package Hot100.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class TreeOperate {

    public static void levelOrder(TreeNode root) {
        if (root == null){
            System.out.println("This is a null tree");
            return ;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + "  ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

        }
        System.out.println();
        return;
    }
}
