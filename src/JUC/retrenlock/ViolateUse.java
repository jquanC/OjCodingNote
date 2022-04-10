package JUC.retrenlock;

import org.junit.Test;

public class ViolateUse {

    public  static  int i = 0;
    public  static void add(){
        i++;
    }
//    public synchronized static void add(){
//        i++;
//    }

    static class TestThread extends Thread {
        @Override
        public  void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            for (int j = 0; j < 1000; j++)i++;
            for (int j = 0; j < 1000; j++) add();//放到方法里面才能看出这种效果
            System.out.println(i);
        }
        /* 但是最终的执行结果还是同时会有多个线程在执行run()中的代码，然后百思不得其解，想了很久，才发现问题所在。
        在方法上加synchronized等同于synchronized(this),虽然看似给run()方法加上了锁，但是我们看main()中是如何去产生多个线程的，是分别new出了三个不同的线程对象。也就是说三个线程都拿到各自对象的锁，因此都能够执行run()中的代码。要解决这个问题其中一个方法是通过runnable接口来实现线程，详细代码如下：
         */
//        public synchronized void add(){
//            i++;
//        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new TestThread();
        t1.start();
        Thread t2 = new TestThread();
        t2.start();
        //你要延时才能看到结果啊，不然是0
        Thread.sleep(5000);
        System.out.println(i);
    }

    @Test
    public void test() {


    }
}
