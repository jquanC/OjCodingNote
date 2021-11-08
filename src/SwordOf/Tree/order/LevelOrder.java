package SwordOf.Tree.order;

import Hot100.Medium.TreeNode;
import org.junit.Test;

import java.util.*;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> oneRowList = new ArrayList<>();

        if (root == null) return resList;

        Queue<TreeNode> que = new LinkedList();
        que.offer(root);

        boolean leftOrRight = true;//左到右
        while (!que.isEmpty()) {
            for(int i=que.size();i>0;i--){
                TreeNode cur = que.poll();
                if(leftOrRight)  oneRowList.add(cur.val);
                else oneRowList.add(0,cur.val);

                if (cur.left != null) que.add(cur.left);
                if (cur.right != null) que.add(cur.right);
            }
            leftOrRight = !leftOrRight;
            resList.add(new ArrayList(oneRowList));
            oneRowList.clear();
        }

        return resList;
    }

    /*从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。*/
    /*分析，多了一个分层的功能*/
  /*  public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> oneRowList = new ArrayList<>();

        if (root == null) return resList;

        Queue<TreeNode> que = new LinkedList();

        que.offer(root);
        que.offer(new TreeNode(Integer.MIN_VALUE));
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur.val == Integer.MIN_VALUE) {
                resList.add(new ArrayList<>(oneRowList));
                oneRowList.clear();

                if(que.isEmpty()) break; //避免死循环
                else que.offer(new TreeNode(Integer.MIN_VALUE));
            } else {
                oneRowList.add(cur.val);
                if (cur.left != null) que.add(cur.left);
                if (cur.right != null) que.add(cur.right);
            }
        }

        return resList;
    }*/

    /*public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];

        List<Integer> orderList = new ArrayList<Integer>();
        Queue<TreeNode> que = new LinkedList();

        que.add(root);
        while(!que.isEmpty()){
            TreeNode cur = que.poll();
            orderList.add(cur.val);
            if(cur.left!=null) que.add(cur.left);
            if(cur.right!=null) que.add(cur.right);
        }
        int[] orderArr = new int[orderList.size()];
        for(int i=0;i<orderList.size();i++){
            orderArr[i] = orderList.get(i);
        }
        return orderArr;
    }*/


}
