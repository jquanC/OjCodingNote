package Single.tree;

import Hot100.Medium.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MorrisOrder {

    /**
     * 1.如果当前节点x没有左子树，（访问节点-访问本身不是遍历的行为），x朝右边走
     * 2.当前节点有左子树，求出左子树的最右节点。
     *     1）如果最右节点的右指针为空，最右节点指向x，x朝左走
     *     2）如果最右节点的右指针不为空（说明第二次访问，x的左子树均已访问，刚刚x就是通过‘morris’路径遍历到的），还原树结构，x朝右走*/
    //LNR
    public List<Integer> inMorrisOrder(TreeNode root){
        if(root == null) return null;
        TreeNode cur = root;
        List<Integer> res = new ArrayList<>();

        while(cur != null){

            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                //寻找leftTree 的 rightMost
                TreeNode rightMost = cur.left;
                while(rightMost.right!=null && rightMost.right!=cur) rightMost = rightMost.right;

                //判断cur 是第一次还是第二次访问
                if(rightMost.right == null){
                    rightMost.right = cur;
                    cur = cur.left;
                }else{
                    rightMost.right = null; //还原二叉树
                    res.add(cur.val);//访问
                    cur = cur.right;
                }
            }
        }

        return res;
    }

    //NLR
    public List<Integer> preMorrisOrder(TreeNode root){
        if(root == null) return null;
        TreeNode cur = root;
        List<Integer> res = new ArrayList<>();

        while(cur != null){

            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                //寻找leftTree 的 rightMost
                TreeNode rightMost = cur.left;
                while(rightMost.right!=null && rightMost.right!=cur) rightMost = rightMost.right;

                //判断cur 是第一次还是第二次访问
                if(rightMost.right == null){
                    rightMost.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                }else{
                    rightMost.right = null; //还原二叉树
                    cur = cur.right;
                }
            }
        }

        return res;
    }

    @Test
    public void test() {
        TreeNode rt0 = new TreeNode(1);
        TreeNode rt1 = new TreeNode(2);
        TreeNode rt2 = new TreeNode(3);
        TreeNode rt3 = new TreeNode(4);
        TreeNode rt4 = new TreeNode(5);
        TreeNode rt5 = new TreeNode(6);
        TreeNode rt6 = new TreeNode(7);

        rt0.left = rt1;
        rt0.right = rt2;
        rt1.left = rt3;
        rt1.right = rt4;
        rt2.right = rt5;
        rt4.left = rt6;

//        List<Integer> ans = inMorrisOrder(rt0);
        List<Integer> ans = preMorrisOrder(rt0);
        System.out.println(ans.toString());

    }

}
