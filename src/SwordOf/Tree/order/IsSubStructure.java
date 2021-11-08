package SwordOf.Tree.order;

import Hot100.Medium.TreeNode;
import org.junit.Test;

import javax.xml.bind.annotation.XmlInlineBinaryData;

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null) return false;

        boolean result = false;
        if(A.val == B.val){
            result = isSameStructure(A,B);
        }

        return result||isSubStructure(A.left,B) || isSubStructure(A.right,B);

    }
    public boolean isSameStructure(TreeNode A,TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        if(A.val!=B.val) return false;

       return isSameStructure(A.left,B.left) && isSameStructure(A.right,B.right);

    }
    @Test
    public void test(){
        TreeNode A1 = new TreeNode(4);
        TreeNode A2 = new TreeNode(2);
        TreeNode A3 = new TreeNode(3);
        TreeNode A4 = new TreeNode(4);
        TreeNode A5 = new TreeNode(5);
        TreeNode A6 = new TreeNode(6);
        TreeNode A7 = new TreeNode(7);
        TreeNode A8 = new TreeNode(8);
        TreeNode A9 = new TreeNode(9);
        A1.left = A2;
        A1.right = A3;
        A2.left= A4;
        A2.right = A5;
        A3.left = A6;
        A3.right = A7;
        A4.left = A8;
        A4.right = A9;

        TreeNode B1 = new TreeNode(4);
        TreeNode B2 = new TreeNode(8);
        TreeNode B3 = new TreeNode(9);
        B1.left = B2;
        B1.right = B3;

        System.out.println(isSubStructure(A1,B1));

    }



}
