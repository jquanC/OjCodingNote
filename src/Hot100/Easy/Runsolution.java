package Hot100.Easy;

import sun.reflect.generics.tree.Tree;

public class Runsolution {
    public static void main(String args[]) {
        // String s = "()";
        // Solution1 so1 = new Solution1();
        // System.out.println(so1.isValid(s));
        // System.out.printf("%.2f" , 10000.0/3.0);
        // System.out.println();
        // System.out.printf("%,(.2f",-10000.0/3.0);

        //2021.04.09
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        Solution3 so3 = new Solution3();


        TreeNode newRoot = so3.mergeTrees(root1, root2);

        System.out.println("root1 level order");
        TreeOperate.levelOrder(root1);
        System.out.println("root2 level order");
        TreeOperate.levelOrder(root2);
        System.out.println("new root level order");
        TreeOperate.levelOrder(newRoot);

    }


}


