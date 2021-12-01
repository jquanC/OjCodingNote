package SwordOf.Search.Tree;

import Hot100.Medium.TreeNode;

public class Deepth {
    public int maxDepth(TreeNode root) {
        return treeDepth(root);
    }
    private int treeDepth(TreeNode root){
        if(root == null) return 0;

        int leftDepth = treeDepth(root.left);
        int rightDepth =treeDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
