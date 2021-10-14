package Hot100.Medium;

import java.util.*;

public class topKFrequentSo {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int e : nums) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        Queue<int[]> countHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            /**
             * priorityQueue 内部是数组维护的Heap
             * 小顶堆，数组【0】最小，compare 方法 a-b >0 */
            @Override
            public int compare(int[] o1, int[] o2) { //要小顶堆
                return o1[1] - o2[1];//这样定义比较器是升序
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();


            if (countHeap.size() == k) {
                if (countHeap.peek()[1] >= count) ;
                else {
                    countHeap.poll();
                    countHeap.offer(new int[]{num, count});
                }

            }
            if (countHeap.size() < k) {
                countHeap.add(new int[]{num, count});
            }
        }
        int res[] = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            res[i] = countHeap.poll()[0];
        }
        return res;

    }
}
