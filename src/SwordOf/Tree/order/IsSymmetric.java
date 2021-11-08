package SwordOf.Tree.order;

import Hot100.Medium.TreeNode;

public class IsSymmetric {
    //LNR 和 RNL 一样
    //同时遍历比较
    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;

        return  orderScan(root,root);



    }
    public boolean orderScan(TreeNode scanLeft,TreeNode scanRight){
        if(scanLeft == null && scanRight == null) return true;
        if(scanLeft ==null || scanRight==null) return  false;
        if(scanLeft.val !=scanRight.val) return false;
        return orderScan(scanLeft.left,scanRight.right) && orderScan(scanLeft.right,scanRight.left);

    }

}
