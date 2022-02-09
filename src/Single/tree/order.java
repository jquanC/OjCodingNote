package Single.tree;

import Hot100.Medium.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 实现二叉树的非递归遍历
 */
public class order {


    /*** 模拟递归遍历函数栈调用的实现方式  */

    /**
     * 非递归先序遍历 NLR
     * 1.遇到新结点先入栈，后取栈顶元素->2；
     * 2.该元素有左孩子？令其为左孩子
     * else该元素有右孩子? 令其为右孩子
     * 3.是叶子结点，取栈顶
     */
    public List<Integer> preOrderNonRecur(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p != null) {
                if (p.right != null) stack.push(p.right);
                if (p.left != null) stack.push(p.left);
                stack.push(p);
                stack.push(null);
            } else {
                //方法调用的状态（参数），-》 ‘方法执行’
                res.add(stack.pop().val);
            }

        }
        return res;
    }

    /**
     * 非递归中序遍历 LNR
     */
    public List<Integer> inOrderNonRecur(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p != null) {
                if (p.right != null) stack.push(p.right);
                stack.push(p);
                stack.push(null);
                if (p.left != null) stack.push(p.left);
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;

    }

    /**
     * 非递归后序遍历 LRN
     */
    public List<Integer> postOrderNonRecur(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p != null) {
                stack.push(p);
                stack.push(null);
                if (p.right != null) stack.push(p.right);
                if (p.left != null) stack.push(p.left);
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;

    }

    /*****  另一种非递归实现树遍历的方式 *****/
    /**
     * 入栈条件 出栈条件
     **/
    public List<Integer> preOrderNonRecurII(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
        List<Integer> res = new ArrayList<>();

        while (root != null) {
            res.add(root.val);
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            TreeNode temp = top.right;
            stack.pop();//出栈条件:左子节点均已入栈, 并获得右子树索引

            while (temp != null) {
                res.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            }
        }
        return res;
    }

    public List<Integer> inOrderNonRecurII(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
        List<Integer> res = new ArrayList<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            TreeNode temp = top.right;
            res.add(stack.pop().val);//出栈条件:左子节点均已入栈, 并获得右子树索引

            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
        }
        return res;
    }

    public List<Integer> postOrderNonRecurII(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
        List<Integer> res = new ArrayList<>();
        TreeNode last = null;

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {

            TreeNode top = stack.peek();

            if ((top.right == null && top.left == null) ||
                    top.right == last ||
                    (top.right == null && last == top.left)){
                TreeNode out = stack.pop();
                res.add(out.val);
                last = out;
            }
            else {
                TreeNode temp = top.right;
                while (temp!=null){
                    stack.push(temp);
                    temp = temp.left;
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

//        List<Integer> ans = preOrderNonRecur(rt0);
        List<Integer> ans = preOrderNonRecurII(rt0);
//        System.out.println(ans.toString());
//        List<Integer> ans1 = inOrderNonRecur(rt0);
        List<Integer> ans1 = inOrderNonRecurII(rt0);
//        System.out.println(ans1.toString());
//        List<Integer> ans2 = postOrderNonRecur(rt0);
        List<Integer> ans2 = postOrderNonRecurII(rt0);
        System.out.println(ans2);

    }

}
