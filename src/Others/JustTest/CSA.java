package Others.JustTest;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CSA {
//        static int count = 0;
    static AtomicInteger count = new AtomicInteger(0);

    @Test
    public void test1() {

        for (int i = 0; i < 2; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {

                            for (int j = 0; j < 100; j++) {
                                /*synchronized (CSA.class){
                                    count++;
                                }*/
                                count.incrementAndGet();

                            }
                        }
                    }
            ).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count=" + count );

    }


    private volatile int value;

    public final int get() {

        return value;

    }
    ConcurrentHashMap<Integer,Integer>ses = new ConcurrentHashMap<>();
}
