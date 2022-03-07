package Others.DesignModel;

public class SinglePattern {
    volatile private static SinglePattern singleObject;


    //构造器
    private SinglePattern(){

    }

    /**
     * 1. 方法必须是静态的
     * */
    public static SinglePattern getSingleObject(){
        if( singleObject ==null){
            synchronized (SinglePattern.class){
                if(singleObject == null) singleObject = new SinglePattern();
            }
        }
        return singleObject;

    }
}
/*
爲什麽兩次判斷？
第一次判断是否为null：
第一次判断是在Synchronized同步代码块外，理由是单例模式只会创建一个实例，并通过getInstance方法返回singleton对象，所以如果已经创建了singleton对象，
就不用进入同步代码块，不用竞争锁，直接返回前面创建的实例即可，这样大大提升效率
第二次判断原因是为了保证同步，假若线程A通过了第一次判断，进入了同步代码块，但是还未执行，线程B就进来了（线程B获得CPU时间片），
线程B也通过了第一次判断（线程A并未创建实例，所以B通过了第一次判断），准备进入同步代码块，假若这个时候不判断，就会存在这种情况：线程B创建了实例，
此时恰好A也获得执行时间片，如果不加以判断，那么线程A也会创建一个实例，就会造成多实例的情况。

爲什麽用volatile?
volatile关键字可以防止jvm指令重排优化，使用了volatile关键字可用来保证其线程间的可见性和有序性
对象的创建并非一步完成，而是需要分为3个步骤执行的，比如：singleton = new Singleton();
指令1：获取singleton对象的内存地址
指令2：初始化singleton对象
指令3：将内存地址指向引用变量singleton
因为Volatile禁止JVM对指令进行重排序，所以创建对象时会严格按照指令1-2-3的顺序执行，假若如果没有Volatile关键字，单线程环境下不会出现问题，
但是在多线程环境下会导致一个线程获得还没有初始化的实例 ！！
e.g.,线程A正常创建一个实例，执行了1-3，此时线程B调用getInstance()后发现instance不为空，因此会直接返回instance，但此时instance并未被初始化，
所以需要用volatile关键字修饰

*/