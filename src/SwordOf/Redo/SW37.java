package SwordOf.Redo;

import Hot100.Easy.TreeNode;

public class SW37 {
    public static void main(String[] args) {
        Codec so = new Codec();
        TreeNode root = new TreeNode(-1);

    }

}
class Codec {

    int p;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preVisit(root);
    }
    public  String preVisit(TreeNode root){
        if(root == null) return "$";
        String str = String.valueOf(root.val);
        str += preVisit(root.left);
        str += preVisit(root.right);

        return str;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        p=0;
        return dePreVisit(data);

    }
    public TreeNode dePreVisit(String data){
        char ch = data.charAt(p++);
        if(ch == '$') return null;
        TreeNode cur = new TreeNode(ch-'0');
        cur.left = dePreVisit(data);
        cur.right = dePreVisit(data);
        return cur;
    }
}