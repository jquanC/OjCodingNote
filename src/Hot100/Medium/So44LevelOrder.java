package Hot100.Medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class So44LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return  ans;

        List<Integer> oneAns = new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        int thisLevelCount = 1;
        int nextLevelCount = 0;


        while (!levelQueue.isEmpty()) {
            TreeNode cur = levelQueue.poll();
            oneAns.add(cur.val);
            thisLevelCount--;

            if (cur.left != null) {
                levelQueue.add(cur.left);
                nextLevelCount++;
            }
            if (cur.right != null) {
                levelQueue.add(cur.right);
                nextLevelCount++;
            }

            if (thisLevelCount == 0) {
                ans.add(new ArrayList<>(oneAns));
                oneAns.clear();
                thisLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return ans;

    }
}
