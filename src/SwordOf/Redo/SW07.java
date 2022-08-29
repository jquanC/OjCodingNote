package SwordOf.Redo;

import Hot100.Easy.TreeNode;

public class SW07 {
    public static void main(String[] args) {
        SW07 so = new SW07();
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        so.build(preOrder,0,preOrder.length-1,inorder,0,inorder.length-1);

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }
    private TreeNode build(int[] preorder,int s1,int e1, int[] inorder,int s2,int e2){

        if(s1>e1||s2>e2) return null;


        int val = preorder[s1];
        TreeNode curNode = new TreeNode(val);
        int leftLenCou = 0;
        while(inorder[s2+leftLenCou]!=val){
            leftLenCou++;
        }
        curNode.left = build(preorder,s1+1,s1+leftLenCou,inorder,s2,s2+leftLenCou-1);
        curNode.right = build(preorder,s1+leftLenCou+1,e1,inorder,s2+leftLenCou+1,e2);
        return curNode;

    }

}
