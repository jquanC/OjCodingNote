package Others.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for(int i =0;i<5;i++){
            threadPool.submit(()->{
                System.out.println("current thread name:"+ Thread.currentThread().getName());
             /*   Object object = null;
                System.out.println("result## "+object.toString());*/
            try{
                Object object = null;
                System.out.println("result## "+object.toString());
            }catch (Exception e){
                System.out.println("程序异常被捕获，可处理...");
            }
            });

        }
    }
}
