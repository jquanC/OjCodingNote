package Hot100.Medium;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

public class So43PreAndInOrderTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTreeRecur(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1,map);


    }

    public TreeNode buildTreeRecur(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR, HashMap<Integer,Integer>map) {
        if(preL>preR || inL>inR)return null;
        if(preL == preR && inL==inR) return new TreeNode(preorder[preL]);

        TreeNode head = new TreeNode(preorder[preL]);//找到根节点
        int loc = map.get(preorder[preL]);
        int count = loc - inL+1;
        /*int count = 0;
        for (int i = inL; i <= inR; i++) {
            count++;
            if (inorder[i] == preorder[preL]) {
                break;
            }
        }
        head.left = buildTreeRecur(preorder, inorder, preL + 1, preL + count - 1, inL, inL + count - 2);
        head.right = buildTreeRecur(preorder, inorder, preL+count,preR,inL+count,inR);
*/
        head.left = buildTreeRecur(preorder, inorder, preL + 1, preL + (loc-inL), inL, loc-1,map);
        head.right = buildTreeRecur(preorder, inorder, preL + (loc-inL)+1,preR,loc+1,inR,map);

        return head;
    }
}
