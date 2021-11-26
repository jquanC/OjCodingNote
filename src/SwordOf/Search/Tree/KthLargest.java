package SwordOf.Search.Tree;

import Hot100.Medium.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthLargest {
    int kth =0,res=0;
    public int kthLargest(TreeNode root, int k){
        inOrderListRNL(root,k);
        return res;
    }
    public void inOrderListRNL(TreeNode root,int k){
        if(root ==null) return;
        if(root.right!=null) inOrderListRNL(root.right,k);
        kth++;
        if(kth == k){
            res = root.val;
            return;
        }
        if(root.left!=null) inOrderListRNL(root.left,k);
    }

    /*常规思路一
    private List<Integer> inOrderList ;
    public int kthLargest(TreeNode root, int k){
        inOrderList = new ArrayList<Integer>();
        inOrder(root);
        return inOrderList.get(inOrderList.size()-k);

    }
    public void inOrder(TreeNode root){
        if(root == null) return;
        if(root.left != null) inOrder(root.left);
        inOrderList.add(root.val);
        if(root.right != null){
            inOrder(root.right);
        }

    }*/

    @Test
    public void test(){
        TreeNode root1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);

        root1.left = node2;
        root1.right = node3;
        root1.right = node5;

         int res =  kthLargest(root1,1);
        System.out.println(res);

    }
}
