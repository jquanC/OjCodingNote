package Hot100.Easy;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution3 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode newRoot = new TreeNode(0);
        preTra(root1,root2,newRoot,-1);
        return newRoot;
    }
    public void preTra(TreeNode root1,TreeNode root2,TreeNode newRoot,int flag){


        // 到这里，必定是一个需要合并的结点,flga={-1,0,1}; 新建结点并插入
        TreeNode node = new TreeNode(root1.val+root2.val);
        if(flag == -1){ //指针同步
            newRoot.val = node.val;
        }
        //newRoot的构造指针慢一步
        if(flag == 0){
            newRoot.left = node;
        }
        if(flag == 1){
            newRoot.right = node;
        }
        //
        if(root1.left!=null && root2.left !=null ) preTra(root1.left,root2.left, flag == -1 ? newRoot:node ,0);

        if(root1.right != null && root2.right != null) preTra(root1.right,root2.right,flag == -1 ? newRoot:node ,1);

        //是否需要递归的判定，不需要递归时直接移接支干
        if(root1.left!=null && root2.left == null){
            if(flag == -1) newRoot.left = root1.left;
            else node.left = root1.left;
           // return ;
        }
        if(root2.left!=null && root1.left == null){
            if(flag == -1) newRoot.left = root2.left;
            else node.left = root2.left;
            //return ;
        }
        if(root1.right!=null && root2.right == null){
            if(flag == -1) newRoot.right = root1.right;
            else node.right = root1.right;
       //     return ;
        }
        if(root2.right!=null && root1.right == null){
            if(flag == -1) newRoot.right = root2.right;
            else node.right = root2.right;
       //     return ;
        }
        return ;


    }

}
