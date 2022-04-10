package DataStructAndAlgo.LRUHandMake;

public class Test {
    public static void main(String[] args) {
        LRU<Integer,Integer> lru = new LRU<>(3);
        lru.put(1,1);
        System.out.println(lru.get(1));//1
        lru.put(2,2);
        lru.put(3,3);
        System.out.println(lru.getLRUHeadValue());//3
        lru.put(4,4);
        if(lru.get(1)==null) System.out.println("key 1 is drop");
        System.out.println(lru.getLRUHeadValue());//4
        System.out.println(lru.get(2));//2
        lru.put(5,5);
        if(lru.get(3)==null) System.out.println("key 3 is drop");

    }
}
