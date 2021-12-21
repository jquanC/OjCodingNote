package SwordOf.Search.Recurse;

import Hot100.Medium.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private int pos = -1;

    // Encodes a tree to a single st5ring.
    public String serialize(TreeNode root) {
        String serializeOrder = "";
        if (root == null) {
            serializeOrder += "$,";
            return serializeOrder;
        }
        serializeOrder += root.val+",";
        serializeOrder += serialize(root.left);
        serializeOrder += serialize(root.right);
        return serializeOrder;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArr = data.split(",");
        return deserializeSup(strArr);
    }
    public TreeNode deserializeSup(String[] dataArr) {
        pos++;
        String cur = dataArr[pos];

        TreeNode node;
        if (!cur.equals("$")){
            node = new TreeNode(Integer.valueOf(cur));
            node.left = deserializeSup(dataArr);
            node.right = deserializeSup(dataArr);
        }else return null;

        return node;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(-1);
        TreeNode node1 = new TreeNode(0);
        TreeNode  node2 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        String res = serialize(root);
        TreeNode reRoot = deserialize(res);
    }

}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));