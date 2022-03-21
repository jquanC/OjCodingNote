package JUC.retrenlock;

import java.util.concurrent.locks.ReentrantLock;
/**
**测试结果说明了？ 感觉这个例子还不是很好，可重入应该是用递归调用的例子更好
* */
public class FairLocked implements Runnable {
    private int seatNumber = 10;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //测试结果说明了？ 感觉这个例子还不是很好，可重入应该是用递归调用的例子更好
             //   System.out.println(Thread.currentThread().getName() +": 到了非临界区，此处同一线程可重入");
                lock.lock();
                if (seatNumber > 0) {
                    Thread.sleep(100);
                    --seatNumber;
                    System.out.println(Thread.currentThread().getName() + "占用1个座位，还有" + seatNumber + "个座位");
                } else {
                    System.out.println(Thread.currentThread().getName() + ":不好意思，票买完了！");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() +":线程结束");//为了具体体现 “可重入”
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        FairLocked rlock = new FairLocked();//Thread(Runnable target, String name)   分配一个新的 Thread对象。
        Thread t1 = new Thread(rlock,"A窗口");
        Thread t2 = new Thread(rlock,"B窗口");
        t1.start();
        t2.start();
    }
}
