package SwordOf.Tree.order;

import Hot100.Medium.TreeNode;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode mirrorRoot = new TreeNode(root.val);

        if (root.left != null) mirrorRoot.right = mirrorTree(root.left);
        if (root.right != null) mirrorRoot.left = mirrorTree(root.right);

        return mirrorRoot;


    }
}
