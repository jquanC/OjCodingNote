package Hot100.Easy;

import sun.reflect.generics.tree.Tree;

public class TestSee {
    public static void main(String args[]){
        TreeNode root1 = new TreeNode(1);

        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeOperate.levelOrder(root1);
        TreeOperate.levelOrder(root2);

        Solution3 so3 = new Solution3();
        TreeNode root3 = so3.mergeTrees(root1,root2);
        TreeOperate.levelOrder(root3);

    }
}
