package Qiu.WanMei;

import com.sun.org.apache.xpath.internal.objects.XNumber;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main2 {
    public static AtomicInteger order = new AtomicInteger(0);
    public static AtomicInteger number = new AtomicInteger(0);


    public static Collection<Runnable> makeTasks(List<Runnable> tasks) {

        //TODO
        List<Runnable> ans = new ArrayList();
        for (int i = 0; i < tasks.size(); i++) {
            Runnable task = tasks.get(i);
            Runnable adviceTask = new Runnable() {
                int num = number.get();

                @Override
                public void run() {
                    if (order.get() == num)
                        task.run();
                }
            };
            ans.add(adviceTask);
        }
        return ans;

    }
}
