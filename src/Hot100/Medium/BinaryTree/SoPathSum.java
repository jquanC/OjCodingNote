package Hot100.Medium.BinaryTree;

import Hot100.Medium.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * ---算法思路分析
 *要求符合的路径的数目，很显然，需要考虑到所有路径的情况(遍历树)
 * 深度遍历树，每访问一个结点，求出根到当前结点的路径节点值之和 cur；(也就是该节点的前缀和，节点前缀和包括自己)
 * 此时，HashMap已经纪录了 到该结点之前 的所有结点的前缀和（HashMap<前缀和，数量>）
 * 通过查找 cur-targetSum，就知道了 以当前结点结束的解的数量；(遍历树的过程，统计以每个访问节点为路径结尾的解的数量，这样就求得了全部解)
 * HahsMap.put(cur ，HashMap.get(当前前缀和)+1)
 * HashMap 弹出发生在，当前节点递归返回时
 * ---算法结构设计
 *
 * 对每个结点
 *      往下遍历时，先更新HashMap
 *      递归返回时，更新（还原）HashMap
 *      求解当前节点解

 * */

public class SoPathSum {
    int res=0;
    Map<Integer,Integer> map = new HashMap<>();
    public int pathSum(TreeNode root,int targetSum){
        map.put(0,1);//每个结点自身值=targetSum 的情况
       traverse(root,0,targetSum);

        return res;

    }
    private void traverse(TreeNode node,int cur,int targetSum){
        if(node == null){
            return ;
        }
        cur+=node.val;
        map.put(cur,map.getOrDefault(cur,0)+1);
        traverse(node.left,cur,targetSum);
        traverse(node.right,cur,targetSum);
        map.put(cur,map.get(cur)-1);

        //处理当前结点
        res+= map.getOrDefault(cur-targetSum,0);

    }
}
