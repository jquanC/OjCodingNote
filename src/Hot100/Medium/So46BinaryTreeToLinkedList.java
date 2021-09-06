package Hot100.Medium;

import java.util.Stack;

public class So46BinaryTreeToLinkedList {
    Stack<TreeNode> rChild = new Stack<>();
    public void flatten(TreeNode root){
        if(root == null) return ;
        change(root,rChild);


    }
    public void change(TreeNode root, Stack<TreeNode> rChildStack){
        if(root.left == null && root.right!=null) change(root.right,rChildStack);
        if(root.left != null && root.right==null) {
            root.right = root.left;
            root.left = null;
            change(root.right,rChildStack);
        }
        if(root.left == null && root.right ==null){
            if(rChildStack.empty()){
                return ;
            }else{
                TreeNode rChild = rChildStack.pop();
                root.right = rChild;
                 change(root.right,rChildStack);
            }
        }
        if(root.left != null && root.right !=null){
            TreeNode temp = root.right;
            rChildStack.push(temp);
            root.right = root.left;
            root.left = null;
            change(root.right,rChildStack);
        }
        return ;

    }
}
