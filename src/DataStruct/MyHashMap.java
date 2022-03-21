package DataStruct;

//注意开头写法
public class MyHashMap<K,V> implements MyMap<K,V>{
    //内部类实现
    class Entry<K,V> implements MyMap.Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;
        int hash;

        public Entry(K key,V value,Entry next,int hash){
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
        public Entry<K,V> getNext(){
            return next;
        }
    }

    private int capacity;
    private float loadFactory;
    private int cou;//记录多少个元素了
    private Entry<K,V>[] table;

    //构造方法
    public MyHashMap(){
        this.capacity = 4;
        this.loadFactory = 0.75f;
//        table = new Entry<K,V>[this.capacity];
        table = new Entry[this.capacity];
    }
    public MyHashMap(int capacity,float loadFactory){
        this.capacity = capacity;
        this.loadFactory = loadFactory;
        table = new Entry[this.capacity];
    }

    private int hash(K key){
        int h;
        return key == null? 0 : (h=key.hashCode())^(h >>> 16);
    }



    @Override
    public V put(K key, V value) {

        if(cou >= capacity*loadFactory) resize();

        cou++;
        int hash = hash(key);
        int pos = hash & (capacity-1); // 可进一步优化计算 hash&(capacity - 1);
        if(table[pos] == null){
            table[pos] = new Entry<K,V>(key,value,null,hash);
            return  null;
        }
        Entry<K,V> entry = table[pos];
        Entry<K,V> preEntry = null; //为了方便用尾插法
        while(entry!= null){
            preEntry = entry;
            if(entry.getKey().equals(key) && entry.hash == hash(key)){ //内容比较要用 equals 不要用 == ！为什么要用equals ，因为hashcode不能严格保证相等
                V oldValue = entry.getValue();
                entry.value = value;
                entry.hash = hash(key);
                return  oldValue;
            }
            entry = entry.next;
        }
        //尾插到开始的地方
        preEntry.next = new Entry<K,V>(key,value,null,hash);
        return value;// 不返回null, 因为null 也可以做为值
    }

    @Override
    public V get(K key) {
        int hash = hash(key);
        int pos = hash&(capacity-1);
        Entry<K,V> scan = table[pos];
        while(scan !=null){
            if(scan.getKey().equals(key) && scan.hash == hash){ //如果key 可为null: (key==null && scan.key ==null) ||(scan.getKey().equals(key) && scan.hash == hash)
                return scan.getValue();
            }
            scan = scan.next;
        }
        return null;
    }
    //remove 方法 , 类似

    public void resize(){
        capacity = capacity<<2;
        Entry<K,V>[] oldTab = table;
        table = new Entry[capacity];
        for(Entry e:oldTab){
            while(e!=null){
                Entry next = e.next;
                int pos = e.hash&(capacity-1);
                Entry<K,V> entry = table[pos];
               //不断头插就好了
                if (entry != null) {
                    e.next = table[pos];
                }
                table[pos] = e;
                e = next;
            }
        }
    }
}
