package EeacDay;

import java.util.*;

public class M0707 {
    public static void main(String[] args) {
        M0707 so = new M0707();
//        int[][] events = new int[][]{{1,2},{1,2},{3,3},{1,5},{1,5}};
//        int[][] events = new int[][]{{1,3},{1,3},{1,3},{3,4}};
        int[][] events = new int[][]{{1,4},{4,4},{2,2},{3,4},{1,1}};
        int ans = so.maxEvents(events);
        System.out.println(ans);
    }

    public int maxEvents(int[][] events) {
        int curDay = 1;
        int meetIndex = 0;
        int cou = 0;
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        while(meetIndex<events.length || !que.isEmpty()){ //第2个条件 !que.isEmpty() 也是非常重要的

            while(meetIndex<events.length && events[meetIndex][0]==curDay){
                que.add(events[meetIndex]);
                meetIndex++; //** 注意 meetIndex 只有这里自增加
            }

            //剔除无效会议，结束时间《 curDay的会议，因为有些会议是无法安排的
            while(!que.isEmpty() && que.peek()[1]<curDay){
                que.poll();
            }
            //选择一个结束时间最早的会议
            if(!que.isEmpty()){ //if 不是 while...一天只能安排一个
                que.poll();
                cou++;
            }
            curDay++;

        }
        return cou;
    }

}
