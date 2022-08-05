package SwordOf.Redo;

import Hot100.Easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SW26 {
    public static void main(String[] args) {
        TreeNode ra = new TreeNode(1);
        ra.left = new TreeNode(2);
        ra.right = new TreeNode(3);
        ra.left.left = new TreeNode(4);

        SW26 so = new SW26();
         boolean ans  = so.isSubStructure(ra,new TreeNode(3));
        System.out.println(ans);
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null) return false;
        List<TreeNode> startList = new ArrayList();

        visitA(A,B,startList);
        boolean ans = false;
        for(TreeNode e: startList){
            ans = ans ||isSub(e,B);
        }


        return ans;
    }
    public boolean isSub(TreeNode A, TreeNode B){
        boolean ans = false;
        if(B == null) return true;
        if(A == null && B!= null) return false;

        if(A.val == B.val){
            ans = ans || (isSub(A.left,B.left) && isSub(A.right,B.right));
        }else{
            ans =  false;
        }
        return ans;
    }
    public void visitA(TreeNode ra, TreeNode B,List<TreeNode> list){
        if(ra == null) return;
        if(ra.val == B.val) list.add(ra);

        visitA(ra.left,B,list);
        visitA(ra.right,B,list);
    }
}
