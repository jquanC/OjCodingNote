package SwordOf.Search.Tree;

import Hot100.Medium.TreeNode;

public class IsBalanced {
    /**自底向上*/
    public boolean isBalanced(TreeNode root){
        if(root == null) return true;
        int high  = height(root);
        if(high>0) return true;
        else return false;
    }
    /**是平衡树则返回该树高度，否则放回-1*/
    public int height(TreeNode root){
        if(root == null) return 0;
        int leftDeep = height(root.left);
        int rightDeep = height(root.right);
        if(Math.abs((leftDeep-rightDeep))<=1 && leftDeep!=-1 && rightDeep!=-1){
            return Math.max(leftDeep,rightDeep)+1;
        }else{
            return -1;
        }
    }

    /*
    自顶向下，复杂度更高
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        boolean childValid = isBalanced(root.left) && isBalanced(root.right);
        if(childValid){
            int leftDepth = treeDepth(root.left);
            int rightDepth = treeDepth(root.right);
            if(Math.abs(leftDepth-rightDepth)>1) return false;
            else return true;
        }else  return false;
    }
    public int treeDepth(TreeNode node){

        if(node == null) return 0;
        int leftDeep = treeDepth(node.left);
        int rightDeep = treeDepth(node.right);
        int deep =  Math.max(leftDeep,rightDeep)+1;
        return deep;
    }*/

}
