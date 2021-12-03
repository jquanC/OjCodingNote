package SwordOf.Search.Tree;

import Hot100.Medium.TreeNode;

public class LowestCommonAncestor {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val==q.val) return p;
        search(root,p,q);
        return res;

    }
    private void search(TreeNode root,TreeNode p,TreeNode q){
        if(root.val >p.val && root.val>q.val){
            search(root.left,p,q);
        }else if(root.val < p.val && root.val <q.val){
            search(root.right,p,q);
        }else{
            res = root;
            return;
        }
    }
}
