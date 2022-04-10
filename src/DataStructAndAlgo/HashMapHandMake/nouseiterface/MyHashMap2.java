package DataStructAndAlgo.HashMapHandMake.nouseiterface;

import DataStructAndAlgo.HashMapHandMake.MyHashMap;
import org.junit.Test;

public class MyHashMap2<K,V> {
    class Node<K,V>{
        K key;
        V value;
        int hash;
        Node<K,V> next;
        public Node(K key,V value,Node<K,V>next,int hash){
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }
        public Node(K key,V value,Node<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Node<K,V>[] table;
    private int capacity;
    private double loadFactory;

    public MyHashMap2(int cap,double fac){ //构造方法上不需要加泛型说明
        this.capacity = cap;
        this.loadFactory = fac;
        table = new Node[capacity];
    }
    public MyHashMap2(){
        this.capacity = 16;
        this.loadFactory = 0.75;
        table = new Node[capacity];
    }

    private int hash(K key){
        int hash = (key.hashCode())^(key.hashCode()>>>16);
        return hash;
    }

    public V put(K key,V value){
        int hashVal = hash(key);
        int len = table.length;
        int pos = hashVal&(len-1);
        Node<K,V> addNode;
        if(table[pos] == null){
            addNode = new Node(key,value,null,hashVal);
            table[pos] = addNode;
            return value;
        }
        Node<K,V> scan = table[pos];
        while(scan!=null){
            Node<K,V> next = scan.next;
            if(scan.hash == hashVal){ //更新值
                V oldVal = scan.value;
                scan.value = value;
                return oldVal;
            }
            scan  = next;
        }
        //说明需要插入一个新节点 头插就可以了
        addNode = new Node(key,value,table[pos],hashVal);
        table[pos] = addNode;
        return value;

    }
    public V get(K key){
        int hashVal = hash(key);
        int len = table.length;
        int pos = hashVal&(len-1);
        if(table[pos] == null) return null;
        Node<K,V> scan = table[pos];
        while(scan!=null){
            Node<K,V> next = scan.next;
            if(scan.hash == hashVal) return scan.value;
            scan = next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap2<String,Integer> map1 = new MyHashMap2<>();
        map1.put("p1",21);
        map1.put("p2",23);
        System.out.println("p1 val:"+ map1.get("p1"));
        System.out.println("p2 val:"+ map1.get("p2"));
        map1.put("p1",18);
        System.out.println("after update p1 val"+map1.get("p1"));

        MyHashMap<Integer,String> map2 = new MyHashMap<Integer, String>();
        map2.put(1,"001");
        map2.put(2,"002");
        System.out.println("1 val:"+ map2.get(1));
        System.out.println("2 val:"+ map2.get(2));
        map2.put(1,"special 001");
        System.out.println("after update 1 val:"+map2.get(1));


    }

}
