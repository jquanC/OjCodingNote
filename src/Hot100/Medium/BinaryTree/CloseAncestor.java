package Hot100.Medium.BinaryTree;

import Hot100.Medium.TreeNode;
import sun.java2d.loops.GraphicsPrimitiveProxy;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class CloseAncestor {
    Map<Integer, TreeNode> parentMap = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Set<Integer> visitedSet = new HashSet<>();
        traverse(root);

        TreeNode ancestor;
        if (p.val == root.val) {
            visitedSet.add(p.val);
        } else {
            visitedSet.add(p.val);
            ancestor = parentMap.get(p.val);
            visitedSet.add(ancestor.val);
            while (ancestor.val != root.val) {
                ancestor = parentMap.get(ancestor.val);
                visitedSet.add(ancestor.val);
            }
        }

        if (visitedSet.contains(q.val)) return q;
        else {
            ancestor = parentMap.get(q.val);
            while (!visitedSet.contains(ancestor.val)) {
                ancestor = parentMap.get(ancestor.val);
            }
            return ancestor;
        }

    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            parentMap.put(root.left.val, root);
            traverse(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            traverse(root.right);
        }

    }


    /**
     * 两个结点有最近公共祖先，两个结点必定在这个最近公共祖先结点的左右分支中
     * */
    /*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null) return null; //空树返回null

        if(root == p || root == q) return root; //往下的过程 找到p 或 q
        else{//从当前节点开始，往下找p,q（分别从当前左分支，和右分支往下）

            TreeNode lNode = lowestCommonAncestor(root.left,p,q);// 往左分支
            TreeNode rNode = lowestCommonAncestor(root.right,p,q);//往右分支

            if(lNode != null && rNode !=null){ //两边不空，说明当前节点必定是最近祖先
                return root;
            }else if(lNode !=null){
                return lNode; //在左分支支，递归所得解
            }else{
                return rNode;//在右分支支，递归所得解
            }
        }

    }*/

}
