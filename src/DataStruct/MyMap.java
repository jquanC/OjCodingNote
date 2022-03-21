package DataStruct;

public interface MyMap<K,V>{
    V put(K key,V value);// 如果存在 old value则返回，否则返回null
    V get(K key);

    interface Entry<K,V>{
        K getKey();
        V getValue();
    }
}
