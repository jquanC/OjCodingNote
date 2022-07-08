package EeacDay;

import Hot100.Easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M0725 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left =  node3;
        node2.right = node4;
        List<List<Integer>> res =  zigzagLevelOrder(root);
        for(List<Integer> e : res){
            System.out.println(e);
        }


    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que  = new LinkedList<TreeNode>();
        que.offer(root);
        que.offer(null);
        int flag = 1;
        List<List<Integer>> ans = new ArrayList();
        List<Integer> list = new ArrayList<Integer>();
        while(!que.isEmpty()){

            if(que.peek()==null){
                que.poll();
                if(flag == 1){
                    List<Integer> oneList = new ArrayList<Integer>();
                    for(int i=0;i<list.size();i++){
                        oneList.add(list.get(i));

                    }
                    ans.add(oneList);
                }else{
                    List<Integer> revList = new ArrayList<Integer>();
                    for(int i=list.size()-1;i>=0;i--){
                        revList.add(list.get(i));
                    }
                    ans.add(revList);
                }
                flag = -flag;
                list.clear();
                if(que.size()==0) break;
                que.offer(null);
                continue;
            }
            TreeNode cur = que.poll();
            if(cur.left!=null) que.offer(cur.left);
            if(cur.right!=null) que.offer(cur.right);
            list.add(cur.val);
        }
        return ans;
    }

}
