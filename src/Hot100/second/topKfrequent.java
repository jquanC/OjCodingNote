package Hot100.second;

import org.junit.Test;

import java.util.*;

public class topKfrequent {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e : nums){
            map.put(e,map.getOrDefault(e,0)+1);
        }

        Queue<Integer> stHeap = new PriorityQueue<Integer>(2,
                new Comparator<Integer>(){
                    public int compare(Integer a,Integer b){
                        return map.get(a)-map.get(b);//1.堆中存放的是元素，但比较的应该是元素的频率 2 对堆来说： 参数1-参数2 是默认的 小顶堆
                    }
                }
        );//这里要显式指定k，默认是 11 ,否则 if(stHeap.size()<k){ 一直为假


        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getValue();
            int key = entry.getKey();
            if(stHeap.size()<k){
                stHeap.offer(key);
            }else{
                if(val>map.get( stHeap.peek())){
                    stHeap.poll();
                    stHeap.offer(key);
                }
            }
        }
        int [] ans = new int[k];
        int i=0;
        for(Integer e:stHeap){
            ans[i++] = e;
        }
        return ans;


    }

    @Test
    public void test(){
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int[] ans = topKFrequent(nums,2);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void testLRUcache(){
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}
