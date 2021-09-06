package Hot100.Medium;

import Hot100.Easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class So42IsValidBST {
    List<Integer> inOrder = new ArrayList();

    public boolean isValidBST(TreeNode root) {
        inOrderTraverse(root);
        int pre = inOrder.get(0);
        for(int i=1;i<inOrder.size() ;i++){
            if(pre>=inOrder.get(i)) return false;
            pre = inOrder.get(i);
        }
        return true;
    }

    private void inOrderTraverse(TreeNode root) {
        if(root.left!=null) inOrderTraverse(root.left);
        inOrder.add(root.val);
        if(root.right!=null) inOrderTraverse(root.right);
    }

}
