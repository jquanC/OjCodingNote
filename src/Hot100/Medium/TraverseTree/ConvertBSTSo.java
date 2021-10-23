package Hot100.Medium.TraverseTree;

import Hot100.Medium.TreeNode;
import sun.reflect.generics.tree.Tree;

public class ConvertBSTSo {
    int curSum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;

        if(root.right!=null) convertBST(root.right);
        root.val = curSum+root.val;
        curSum = root.val;
        if(root.left!=null) convertBST(root.left);

        return root;
    }
}
