package Blank;


import org.junit.Test;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Lc_Sw_37 {
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        preVisit(root, sb);
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int couStar = 0;
        StringBuilder oneNum = new StringBuilder();
        while(couStar<2){
            char ch = data.charAt(index++);
            if(ch == '*') couStar++;
            else{
                oneNum.append(ch);
            }
        }
        String numStr = oneNum.toString();

        if (numStr.equals("#")) return null;
        TreeNode curNode = new TreeNode(Integer.parseInt(numStr));
        curNode.left = deserialize(data);
        curNode.right = deserialize(data);
        return curNode;

    }

    public void preVisit(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("*#*");
            return;
        }
        String numStr = "*"+node.val+"*";
        sb.append(numStr);
        preVisit(node.left, sb);
        preVisit(node.right, sb);

    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(-1);
        TreeNode l = new TreeNode(0);
        TreeNode r = new TreeNode(1);
        root.left = l;
        root.right = r;
        String str =  serialize(root);
        System.out.println(str);
        TreeNode node = deserialize(str);
    }

}
