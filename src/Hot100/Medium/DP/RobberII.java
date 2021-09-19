package Hot100.Medium.DP;

import Hot100.Medium.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class RobberII {
    public int rob(TreeNode root){
        if(root == null) return  0 ;
        //1个哈希表，用节点作为计算Bucket的key，一个bucket 第一个值存选择时的最优解，第二个值存不选择的最优解
        HashMap<TreeNode,Integer> bestSelectSet = new HashMap();
        HashMap<TreeNode,Integer> bestUnselectSet = new HashMap();

        traverse(root,bestSelectSet,bestUnselectSet);
        return Math.max(bestSelectSet.getOrDefault(root,0),bestUnselectSet.getOrDefault(root,0));
    }
    private void traverse(TreeNode root,HashMap<TreeNode,Integer> setSe,HashMap<TreeNode,Integer> setUnSe){
        if(root.left !=null){
            traverse(root.left,setSe,setUnSe);
        }
        if(root.right != null){
            traverse(root.right,setSe,setUnSe);
        }
//        访问结点-处理该节点的逻辑
//        不需要分是不是叶子，可以统一处理
        //如果这个节点是叶子
        if(root.left == null && root.right == null){
            setSe.put(root,root.val);
            setUnSe.put(root,0);
        }else{
            //不是叶子，动态规划
//        以该节点为根，选择该节点的最优解;需判空
            int fl =setUnSe.getOrDefault(root.left,0);
            int fr =setUnSe.getOrDefault(root.right,0);
            setSe.put(root,fl+fr+root.val);
//        以该节点为根，不选择该节点的最优解
            int gl =  Math.max(setSe.getOrDefault(root.left,0),setUnSe.getOrDefault(root.left,0));
            int gr =  Math.max(setSe.getOrDefault(root.right,0),setUnSe.getOrDefault(root.right,0));

            setUnSe.put(root,gl+gr);



        }
    }
}
