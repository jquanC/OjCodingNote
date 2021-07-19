package Hot100.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 */
public class So23InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean place = false;
        List<int[]> ans = new ArrayList<>();
        for(int[] interval : intervals){
            if(right < interval[0]){
                //在插入区间的右侧且无交集
                if(!place){
                    ans.add(new int[]{left,right});
                    place = true;
                }
                ans.add(interval);

            }else if(interval[1] < left){
                //在插入区间的左边
                ans.add(interval); //这里这样处理就可以，只插入正常区间，插入区间的处理 归约在另外2种情况处理中
            }else{
                // 与插入区间有交集，计算他们的并集
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }

        if(!place){ //只剩一种情况
            ans.add(new int[]{left,right});
        }
        int [][]Arr = new int[ans.size()][];
        return ans.toArray(Arr);


    }
}
