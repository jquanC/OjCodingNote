package JUC.retrenlock;



import java.util.concurrent.locks.ReentrantLock;

/**
 * 递归的示例表示
 * **/
public class RetrenDemo implements Runnable{
    private ReentrantLock lock = new ReentrantLock();
    private int cout = 0;
    public void print() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"到非上锁区");
        lock.lock();
        Thread.sleep(500);
        try{
           System.out.println(Thread.currentThread().getName()+"到临界区代码");
            while(cout <5){
                System.out.println(Thread.currentThread().getName()+": cur count value = "+cout);
                cout++;
                print();
            }
        }catch (Exception e){

        }finally {
            System.out.println(Thread.currentThread().getName()+"即刻释放 count ="+cout);
            lock.unlock();
        }
    }



    @Override
    public void run() {
        try {
            print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        RetrenDemo rd = new RetrenDemo();
        Thread threadA = new Thread(rd,"TA");
        Thread threadB = new Thread(rd,"TB");
        threadA.start();
        threadB.start();
    }
}
