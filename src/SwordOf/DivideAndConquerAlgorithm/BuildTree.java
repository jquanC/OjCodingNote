package SwordOf.DivideAndConquerAlgorithm;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import Hot100.Medium.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。*/

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTreeFromTop(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;

    }
    public TreeNode buildTreeFromTop(int[] preorder,int leftP,int rightP,int[] inorder,int leftI,int rightI){

        TreeNode root;
        if(leftP<=rightP){
            root = new TreeNode(preorder[leftP]);
            int len=0;
            while(inorder[leftI+len]!=preorder[leftP]) len++;
            root.left = buildTreeFromTop(preorder,leftP+1,leftP+len,inorder,leftI,leftI+len-1);
            root.right = buildTreeFromTop(preorder,leftP+len+1,rightP,inorder,leftI+len+1,rightI);
        }else{
            return null;
        }
        return root;
    }
}
