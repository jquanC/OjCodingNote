package Hot100.Medium;

import com.sun.deploy.cache.InMemoryLocalApplicationProperties;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * 实现lru 用LinkedHashMap
 * */
public class LRUEasyVersion extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public  LRUEasyVersion (int capacity) {
       super(capacity,0.75F,true);
       this.capacity = capacity;

    }

    public int get(int key) {
      return super.getOrDefault(key,-1);//用这个方法就用不先使用contains方法判断是否存在

    }

    public void put(int key, int value) {
        super.put(key,value);

    }
    @Override
    /**
     * 每个put都会利用这个方法来判断是否需要更新
     * */
    protected  boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size()>capacity;
    }

}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */