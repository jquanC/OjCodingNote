package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        System.out.println(testM());
        byte [] bs  = new byte[5];
        String pkStr = Base64.getEncoder().encodeToString(bs);
        System.out.println(pkStr);
        System.out.println("-------");
        ThreadLocal<String > tlStr = new ThreadLocal();
        tlStr.set("aaaa");
        String get1 = tlStr.get();
        System.out.println(get1);
        tlStr.set("bbb");
        String get2 = tlStr.get();
        System.out.println(get2);
    }


}
