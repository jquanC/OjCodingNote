package Hot100.Medium;

import org.junit.Test;

import java.util.*;

public class ReconstructQueueSo {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }

            }
        });

        int[][] res = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            int kth = people[i][1];
            int cou = -1;
            for (int j = 0; j < res.length; j++) {
                if (res[j] == null) cou++;
                if (cou == kth) {
                    res[j] = people[i];
                    break;
                }
            }

        }
        return res;
    }

    @Test
    public void test() {
//        int[][] nums = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        int[][] nums = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = reconstructQueue(nums);
        for (int[] e :
                res) {
            System.out.print(Arrays.toString(e)+"  ");
        }
    }
}
