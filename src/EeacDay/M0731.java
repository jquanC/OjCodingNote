package EeacDay;

import java.util.HashMap;

class Node{
    int val;
    int key;
    Node prev;
    Node next;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
    public Node(int key,int val,Node prev,Node next){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
public class M0731 {

    private int capacity;
    int listLen = 0;
    Node head;
    HashMap<Integer,Node> map;
    public void LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.map = new HashMap();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        moveToHead(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int value) {

        Node curNode;
        if(map.containsKey(key)){
            curNode = map.get(key);
            curNode.val = value;
            moveToHead(curNode);
        }else{
            curNode = new Node(key,value);
            map.put(key,curNode);
            addNode(curNode);
        }

    }
    public void moveToHead(Node curNode){
        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;
        Node t = head.next;
        head.next = curNode;
        curNode.prev = head;
        curNode.next = t;
        t.prev = curNode;
        return ;
    }
    public void addNode(Node curNode){
        Node t = head.next;
        head.next = curNode;
        curNode.prev = head;
        curNode.next = t;
        t.prev = curNode;
        listLen++;
        if(listLen>capacity){
            Node delNode = head.prev;
            map.remove(delNode.key);
            delNode.prev.next = delNode.next;
            delNode.next.prev = delNode.prev;
            delNode.prev = null;
            delNode.next = null;
            listLen--;

        }
        return ;

    }
}
