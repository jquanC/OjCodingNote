package Hot100.Medium;

import java.util.HashMap;

public class LRUCache {
    class DLinkedNode {
        int value;
        int key;
        DLinkedNode prev;
        DLinkedNode next;


        public DLinkedNode() {
        }



        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private int capacity;
    private HashMap<Integer, DLinkedNode> map;
    private DLinkedNode head = new DLinkedNode();
    private DLinkedNode tail = new DLinkedNode();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, DLinkedNode>(capacity, 0.75F);
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        if(map.containsKey(key)){
            DLinkedNode node =  map.get(key);
            moveToHead(node);
            return node.value;
        }else return -1;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            DLinkedNode node = new DLinkedNode(key,value);
            map.put(key,node);
            addHead(node);

        }


    }
    private void delete(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    private void addHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        if(map.size()>capacity){
            DLinkedNode nodeDel = tail.prev;
            map.remove(nodeDel.key);
            delete(nodeDel);

        }

    }
    private void moveToHead(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;

    }


}
