package test;

import org.junit.Test;
import sun.rmi.runtime.Log;

public class ThreadLocalUsage {

    @Test
    public void test(){
//        final ThreadLocal threadLocal = new InheritableThreadLocal(); //也可以
        final InheritableThreadLocal fatherThreadLocal = new InheritableThreadLocal();
        fatherThreadLocal.set("很帅的小伙子");
        System.out.println("pos 1");
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("joey是谁？"+fatherThreadLocal.get());
            }
        };
        t.start();
        System.out.println("pos2 finished");
    }
    @Test
    public void test2(){
        int pos = 21;
        String str = String.valueOf(pos);
        System.out.println(str);
    }


}
