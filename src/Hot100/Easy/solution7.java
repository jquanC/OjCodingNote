package Hot100.Easy;

import java.util.ArrayList;

import java.util.List;

public class solution7 {
    private List<Integer> diameterOfNodeList = new ArrayList<>();

    public int diameterOfBinaryTree(TreeNode root) {
        traverseOfTree(root);
        int maxDia = Integer.MIN_VALUE;
        for (int i = 0; i < diameterOfNodeList.size(); i++) {
            if (diameterOfNodeList.get(i) >= maxDia) maxDia = diameterOfNodeList.get(i);
        }
        return maxDia;
    }

    public int traverseOfTree(TreeNode root) {
        if (root == null) return 0;

        int rDepth = 0;
        int lDepth = 0;

        if (root.left != null) {
            rDepth = traverseOfTree(root.left) + 1;
        }
        if (root.right != null) {
            lDepth = traverseOfTree(root.right) + 1;
        }
        diameterOfNodeList.add(rDepth + lDepth );
        return rDepth >= lDepth ? rDepth : lDepth;
    }
}
