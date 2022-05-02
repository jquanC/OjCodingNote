package Others.JustTest;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class LCsolution {
    Node head;
    Node pre ;
    //Node cur;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public void inorder(Node root){

        if(root.left !=null){
            inorder(root.left);
        }
        //visit;
        if(head == null){
            head = root;
            pre = root;
        }else{
            pre.right = root;
            root.left = pre;
            pre = root;
            //并没有破坏root 的右链
        }

        if(root.right!=null){
            inorder(root.right);
        }
    }

    @Test
    public void tets() {
        /*[4,2,5,1,3]*/
        Node node = new Node(4);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        Node dlist = treeToDoublyList(node);
        while(dlist!=null){
            System.out.print(dlist.val+" ");
            dlist = dlist.right;
        }
    }
}
