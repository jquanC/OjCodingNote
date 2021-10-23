package Hot100.Medium.search;

import java.util.*;

public class LeastIntervalSo {

    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
        for (Character e : tasks) {
            freqMap.put(e, freqMap.getOrDefault(e, 0) + 1);
        }
        List<Integer> rest = new ArrayList<>();
        List<Integer> nextTime = new ArrayList<>();

        Set<Map.Entry<Character, Integer>> entrySet = freqMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            rest.add(entry.getValue());
            nextTime.add(1);
        }

        int time = 0;
        /**一共需要执行 task.length 个任务*/
        for (int i = 0; i < tasks.length; i++) {
            time++;
            /**寻找最小next Valid Time*/
            int minNextValidTime = Integer.MAX_VALUE;
            for (int j = 0; j < nextTime.size(); j++) {
                /**已经全部执行完的任务不需要参与判断*/
                if (rest.get(j) != 0) {
                    minNextValidTime = Math.min(minNextValidTime, nextTime.get(j));
                }
            }
            /**程序优化，time < minNextValidTime 的时候CPU只能等待*/
            time = Math.max(time, minNextValidTime); //每个任务都只需要1个单位时间片来执行

            /**寻找本次执行的任务,相同情况下，选择剩余执行任务数多的*/
            int bestChooseIndex = -1;
            for (int j = 0; j < rest.size(); j++) {
                if (rest.get(j) != 0 && nextTime.get(j) <= time) {
                    if (bestChooseIndex == -1 || rest.get(j) > rest.get(bestChooseIndex)) {
                        bestChooseIndex = j;
                    }
                }
            }
            rest.set(bestChooseIndex, rest.get(bestChooseIndex) - 1);//细节，这里为什么不能是--， 注意--是赋值运算符，这里需要的是值，不是等式
            nextTime.set(bestChooseIndex, time + n + 1);
        }
        return time;
    }

}
