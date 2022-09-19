package DataStructAndAlgo.HandMake.MyHashMap202208;

class Node<K,V>{
    K key;
    V value;
    int hash;
    Node<K,V> next;
    public Node(K key,V value,int hashVal){
        this.key = key;
        this.value = value;
        this.hash = hashVal;
    }
}
public class MyHashMap<K,V> {

    int n=16; //表示当前数组的长度，扩容时保证是2^16
    int cou; //每插入一个++，删除一个--;
    Node<K,V>[] table;
    public MyHashMap(int n){
        table = new Node[n];
    }
    public MyHashMap(){
        table = new Node[n];
    }
    public int hash(K key){
        int h = key.hashCode();
        int hash = (h>>>16)^h; //right? 应该是要用循环移位
        return hash;
    }
    public V put(K key,V value){
        int hashVal = hash(key);
        int pos = hashVal&(n-1); //需要保证每次扩容时数组长度是2的n次方； //是 & 不是 ^
//        System.out.println("pos="+pos);
        if(table[pos]==null){
            Node<K,V> curNode = new Node(key,value,hashVal);
            table[pos] = curNode;
            cou++;
            if(cou==n-1){
                //需要扩容 略
            }
            return value;
        }
        //存在哈希冲突，采用尾插法
        Node scanNode = table[pos];
        Node tail  = null;
        while(scanNode!=null){
            if(scanNode.hash == hashVal){ //已经插入，只需要更新值
                scanNode.value = value;
                return value;
            }
            if(scanNode.next == null) tail = scanNode;
            scanNode = scanNode.next;
        }
        //尾插法
        Node<K,V> curNode = new Node(key,value,hashVal);
        tail.next = curNode;
        cou++;
        if(cou==n-1){
            //需要扩容 略
        }
        return value;
    }
    public V get(K key){
        int hashVal = hash(key);
        int pos = hashVal&(n-1); //是 & 不是 ^
        Node<K,V> scan = table[pos];
        while(scan!=null){
            if(scan.hash == hashVal) return scan.value;
            scan = scan.next;

        }
        return null;
    }
}
