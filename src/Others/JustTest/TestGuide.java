package Others.JustTest;

/*
Thread(Runnable target)
* Runnable 接口是一个函数式接口，只有一个方法 run() 方法。可以通过lambda表达式创建一个runnable对象
调用start方法，线程进入可运行状态
其他类只要实现了Runnable接口，使用同样的方法启动一个线程
run方法中是线程启动start()后要执行的任务
*/
public class TestGuide {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);//这个延时是为了让线程2也顺利获得资源
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting resource2");

                //不释放resource1
                synchronized(resource2){
                    System.out.println(Thread.currentThread()+"get resources2");
                }
            }

        }
        ).start();

        new Thread(()->{
            synchronized(resource2){
                System.out.println(Thread.currentThread()+"get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waiting resource1");

                //不释放 resource2
                synchronized(resource1){
                    System.out.println(Thread.currentThread()+"get resource1");
                }

            }

        }).start();
    }
}
