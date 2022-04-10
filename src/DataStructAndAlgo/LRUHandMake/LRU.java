package DataStructAndAlgo.LRUHandMake;

import java.util.HashMap;

/**lru 算法： map+双向链表
 * map 用于快速查询缓存是否命中
 * 链表是为了需要换出时方便，即每次访问，添加的页都在链表头，需要换出时淘汰链表尾
 * 这个链表自己实现
 * */
public class LRU<K,V> {
    class Node<K,V>{
        V value;
        K key;
        Node<K,V> next;
        Node<K,V> prev;
        public Node(K key,V value,Node next,Node prev){
            this.key = key;this.value = value; this.next = next; this.prev = prev;
        }
    }
    Node<K,V> head;
    Node<K,V> tail;
    HashMap<K,Node<K,V>> hashMap;
    int cap;

    public LRU(int cap){
        //head tail 不存在hashmap中
        head = new Node(-1,-1,null,null);
        tail = new Node(-2,-2,null,null);
        head.next = tail;
        tail.prev = head;
        hashMap = new HashMap<K,Node<K,V>>();
        this.cap = cap;
    }

    public V put(K key,V value){
        if(hashMap.containsKey(key)){
            Node<K,V> curNode = hashMap.get(key);
            curNode.value = value;
        }else{
            Node<K,V> newNode = new Node<>(key,value,null,null);
            hashMap.put(key,newNode);
            addHead(newNode);
        }
        return value;
    }

    public V get(K key){

        if(hashMap.containsKey(key)){
            Node<K,V> node = hashMap.get(key);
            moveToHead(node);
            return node.value;
        }
        return null;
    }
    //只是为了测试方便加的方法
    public V getLRUHeadValue(){
        return head.next.value;
    }
    private void addHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        if(hashMap.size()>cap){
            removeTail();
        }
        return;
    }
    //访问时
    private void moveToHead(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    /** 删除结点，也要记得删除 hashmap呀*/
    private void removeTail(){
        Node temp = tail.prev;
        hashMap.remove(temp.key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;

//        temp.prev = null; //没必要
//        temp.next = null;
    }

}
