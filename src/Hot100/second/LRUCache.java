package Hot100.second;

import org.junit.Test;

import java.util.HashMap;

class LRUCache {

    Node head;
    HashMap<Integer,Node> map;
    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer,Node>();
        head = new Node(-1);
        head.next = head;
        head.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;

            head.next.prev = cur;
            cur.next = head.next;
            cur.prev = head;
            head.next = cur;

            return map.get(key).value;
        }
        return -1;

    }

    public void put(int key, int value) {
        //注意判断容量
        Node cur;
        if(map.containsKey(key)){
            cur = map.get(key);
            cur.value = value;

            map.put(key,cur);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;

            head.next.prev = cur;
            cur.next = head.next;
            cur.prev = head;
            head.next = cur;
        }else{
            cur = new Node(value);
            map.put(key,cur);
            head.next.prev = cur;
            cur.next = head.next;
            cur.prev = head;
            head.next = cur;

        }
        //判断容量
        if(map.size()>capacity){ //map 里面是没有 head node 的
            map.remove(head.prev);
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
        }

    }
    class Node{
        private int value;
        private Node next;
        private Node prev;
        public Node(int value,Node next,Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        public Node(int value){
            this.value = value;
        }
    }


}

