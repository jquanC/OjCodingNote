package EeacDay;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class M1104 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> freq = new HashMap();//用于统计

        for(int i=0;i<tasks.length;i++){
            freq.put(tasks[i],freq.getOrDefault(tasks[i],0)+1);
        }
        //因为后面需要遍历，而HashMap遍历不方便
        Set<Character> keys = freq.keySet();
        int m = keys.size();
        int[] taskNums = new int[m];
        int[] nextValid = new int[m];

        int j=0;
        for(Character e:keys){
            taskNums[j] = freq.get(e);
            nextValid[j] = 1;
            j++;
        }
        int time = 0;

        while(true){
            time++;
            int nextMinValid = Integer.MAX_VALUE;
            //此轮为了直接求下一个最小合法时间，监视while循环次数
            for(int i=0;i<m;i++){
                if(taskNums[i]!=0) nextMinValid = Math.min(nextMinValid,nextValid[i]);
            }
            if(nextMinValid == Integer.MAX_VALUE){
                time--;
                break;
            }

            time = Math.max(time,nextMinValid);

            //选择剩余任务数最多的可执行任务
            int selected = -1;
            for(int i=0;i<m;i++){
                if(nextValid[i]<=time && taskNums[i]!=0){
                    if(selected==-1 || taskNums[i]>taskNums[selected])
                        selected = i;
                }
            }
            if(selected !=-1){
                taskNums[selected]--;
                nextValid[selected] = time+n+1;
            }
        }
        return time;

    }
}
