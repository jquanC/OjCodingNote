package DataStructAndAlgo.ClassicPro;

import java.util.concurrent.atomic.AtomicInteger;

public class ReadWriteFair {

    AtomicInteger rCountMutex = new AtomicInteger(1); // semaphore rCountMutex
    AtomicInteger wDateMutex = new AtomicInteger(1);// semaphore wDataMutex
    AtomicInteger flag = new AtomicInteger(1); //to achieve fair competition control
    int rCount = 0; // 正在进行读操作的读者个数

    //读进程
    public void reader() {
        while(true){
            P(flag);//用来让写进程来的时候，避免饥饿
            P(rCountMutex);
                if(rCount==0){ // if作用是提高效率，不用每次有读进程都判断
                    P(wDateMutex);//只要当前还有读进程没执行完，阻塞写进程执行
                }
                rCount++;
            V(rCountMutex);
            V(flag);
            read();
            P(rCountMutex);
                rCount--;
                if(rCount==0){ //读进程全部执行完，唤醒写进程
                    V(wDateMutex);
                }
            V(rCountMutex);
        }
    }

    //写进程
    public void writer() {
        while(true){
            P(flag);//先争夺flag , 避免自己饥饿；
                P(wDateMutex);
                write();
                V(wDateMutex);
            V(flag);
        }
    }


    public void read(){}
    public void write(){}
    public void P(AtomicInteger semaphore){semaphore.decrementAndGet();}
    public void V(AtomicInteger semaphore){semaphore.incrementAndGet();}
    /**
     * 读读共享，写写互斥，读写互斥
     * 造成读优先是因为，只要当前读者不空，读者可以进入等待队列，而写者不行；
     * 问题在于写者必须等到全部读者结束，才可以进入临界区；
     * flag变量使得，当前读者数不为0是，写者有机制阻塞后续的读者继续进入队列 ！
     * 当然，写者还是要等到已经在临界区的读者全部离开，才能进入临界区，但是flag避免了写者进程饥饿
     * */
}
