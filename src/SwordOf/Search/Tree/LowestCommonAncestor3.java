package SwordOf.Search.Tree;

import Hot100.Medium.TreeNode;
import org.junit.Test;
import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 如果子树没有指向父节点的指针，那么可以建立从**根开始到p，q的链表**。得到这两个链表后，寻找最后一个相同的公共结点，即解。
 * 问题的关键，变成了在遍历过程，如何建立根到某个结点的路径(链表)-code3
 */
public class LowestCommonAncestor3 {
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathListOfp = new ArrayList<>();
        List<TreeNode> pathListOfq = new ArrayList<>();
        getNodeListFromRoot(root, p, pathListOfp);
        getNodeListFromRoot(root, q, pathListOfq);
        Iterator<TreeNode> iteratorP = pathListOfp.iterator();
        Iterator<TreeNode> iteratorQ = pathListOfq.iterator();
        TreeNode res = root;
        while (iteratorP.hasNext() && iteratorQ.hasNext()) {
            TreeNode pListNode = iteratorP.next();
            TreeNode qListNode = iteratorQ.next();
            if (pListNode.val == qListNode.val) res = pListNode;
        }
        return res;
    }

    public boolean getNodeListFromRoot(TreeNode root, TreeNode target, List<TreeNode> pathlist) {
        //找到了就不用一直遍历了，且能保存当前的pathList
        boolean haveFind=false;
        pathlist.add(root);
        if (root.val == target.val) return true;
        else{
            if (root.left != null && !haveFind){
                haveFind = getNodeListFromRoot(root.left, target, pathlist);
            }
            if (root.right != null && !haveFind){
                haveFind =  getNodeListFromRoot(root.right, target, pathlist);
            }
            if(!haveFind) pathlist.remove(pathlist.size()-1);
        }
        return haveFind;
    }

    @Test
public void test(){
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(20);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node2.left = node5;
        node1.left = node3;
        node1.right = node4;
        node3.left = node6;
        node4.right = node7;

        TreeNode res = lowestCommonAncestor(root,node6,node7);
        System.out.println(res.val);

    }
}
