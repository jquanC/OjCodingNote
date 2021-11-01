package SwordOf.list;

import SwordOf.domain.Node;
import org.junit.Test;

import java.util.HashMap;

/*public class Node {
    int val;
    SwordOf.domain.Node next;
    SwordOf.domain.Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}*/

public class RopyRandomList {
    public Node copyRandomList(Node head) {

        Node scan1 = head;
        Node copyDumpHead = new Node(-1);
        Node scan2 = copyDumpHead;
        HashMap<Node, Integer> nodeMap1 = new HashMap<>();
        HashMap<Integer, Node> nodeMap2 = new HashMap<>();
        int id = 0;
        nodeMap1.put(null,id);//<null,0>的情况
        nodeMap2.put(id,null);
        while (scan1 != null) {
            id++;
            nodeMap1.put(scan1,id);
            Node newNode = new Node(scan1.val);
            scan1 = scan1.next;
            scan2.next = newNode;
            scan2 = scan2.next;
            nodeMap2.put(id,scan2);
        }
        scan1 = head;
        scan2 = copyDumpHead.next;
        while(scan1!=null){
            Node randomNodeInList1 = scan1.random;
            int randomId = nodeMap1.get(randomNodeInList1);
            Node randomNodeInCopyList = nodeMap2.get(randomId);
            scan2.random = randomNodeInCopyList;
            scan1 = scan1.next;
            scan2 = scan2.next;
        }
        return copyDumpHead.next;
    }


    /*[[7,null],[13,0],[11,4],[10,2],[1,0]]*/
    @Test
    public void test(){
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        /*---*/
        node1.next = node2;node1.random = null;
        node2.next = node3;node2.random = node1;
        node3.next = node4;node3.random = node5;
        node4.next = node5;node4.random = node3;
        node5.next = null;node5.random = node1;

        Node copy = copyRandomList(node1);
        System.out.println("--");

    }
}

