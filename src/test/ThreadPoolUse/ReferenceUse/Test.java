package test.ThreadPoolUse.ReferenceUse;

import java.lang.ref.WeakReference;

public class Test {
    public static void main(String[] args) {
        /*Object obj = new Object();
        WeakReference<Object> sf = new WeakReference<>(obj);
        obj = null;
        System.out.println(sf.get());
        System.gc();
        System.out.println(sf.get());*/


        //Object obj = new Object();
        WeakReference<Object> sf = new WeakReference<>(new Object());
        System.out.println(sf.get());
        System.gc();
        System.out.println(sf.get());
        ThreadLocal<String> s = new ThreadLocal();

    }

}
