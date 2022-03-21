package DataStruct;

public class Test {
    public static void main(String[] args) {
        MyHashMap<String,Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("JunMing",21);
        myHashMap.put("JiaHao",22);
        System.out.println(myHashMap.get("JunMing"));
        System.out.println(myHashMap.get("JiaHao"));
        myHashMap.put("JunMing",24);
        System.out.println(myHashMap.get("JunMing"));
        System.out.println("----");
        myHashMap.put("key1",5);
        myHashMap.put("key2",6);//扩容
        myHashMap.put("key3",7);//扩容
        System.out.println(myHashMap.get("JiaHao"));
        System.out.println(myHashMap.get("JunMing"));
        System.out.println(myHashMap.get("key1"));
        System.out.println( myHashMap.get("key2"));
        System.out.println( myHashMap.get("key3"));


    }
}
