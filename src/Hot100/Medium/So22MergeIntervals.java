package Hot100.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class So22MergeIntervals {


    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals,new ArrayComparator());
        List<int[]> ans = new ArrayList<>();

        int leftMost=intervals[0][0],rightMost = intervals[0][1];
        int i;
        for(i=0;i<intervals.length;i++){
            if(rightMost >= intervals[i][0]){
                rightMost= intervals[i][1]>rightMost ? intervals[i][1]: rightMost ;
                //易忽略情况[[1,6],[2,4],[7,9]] ->[1,6] [7,9] 而非 [1,4] [7,9]
                continue;
            }else{ //
                int[] oneRange = new int[2];
                oneRange[0]= leftMost;
                oneRange[1]= rightMost;
                ans.add(oneRange);
                leftMost = intervals[i][0];
                rightMost = intervals[i][1];

            }

        }
        int[] oneRange = new int[2];
        oneRange[0] = leftMost;
        oneRange[1] = rightMost;
        ans.add(oneRange);

        int[][] ansArr = new int[ans.size()][];
        return ans.toArray(ansArr);
    }

}

class ArrayComparator implements Comparator<int[]>{
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0]-o2[0];
    }
}
