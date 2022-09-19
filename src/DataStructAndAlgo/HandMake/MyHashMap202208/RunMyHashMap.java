package DataStructAndAlgo.HandMake.MyHashMap202208;

public class RunMyHashMap {
    public static void main(String[] args) {
        MyHashMap<String,String> strMap = new MyHashMap<>();
        strMap.put("jquan","good");
        strMap.put("lindan","play good");
        System.out.println(strMap.get("jquan"));
        System.out.println(strMap.get("lindan"));
        strMap.put("jquan","play good as well as lin dan one day");
        System.out.println(strMap.get("jquan"));
        MyHashMap<Integer,Integer> intMap = new MyHashMap();
        intMap.put(1,3);
        intMap.put(2,4);
        System.out.println(intMap.get(1));
        System.out.println(intMap.get(2));
        intMap.put(1,10);
        System.out.println(intMap.get(1));
        ThreadLocal<String> a = new ThreadLocal<>();
    }
}
