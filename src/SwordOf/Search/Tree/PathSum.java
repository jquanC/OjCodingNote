package SwordOf.Search.Tree;

import Hot100.Medium.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*到叶子的时候判断当前和就Ok了*/
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> resList = new ArrayList<>();

        pathSumSearch(root, target, new ArrayList<Integer>(), resList, 0,0);
        return resList;


    }

    public void pathSumSearch(TreeNode root, int target, List<Integer> oneRes, List<List<Integer>> resList, int pathSum,int index) {
        if (root == null) return;

        pathSum += root.val;
        oneRes.add(root.val);
        //是叶子，且是目标解
        if (root.left == null && root.right == null) {
            if (pathSum == target) {
                resList.add(new ArrayList<>(oneRes));
            }
        }
        if(root.left!=null){
            pathSumSearch(root.left,target,oneRes,resList,pathSum,index+1);
        }
        if(root.right!=null){
            pathSumSearch(root.right,target,oneRes,resList,pathSum,index+1);
        }
        pathSum-=root.val;
        oneRes.remove(index);

    }
}
