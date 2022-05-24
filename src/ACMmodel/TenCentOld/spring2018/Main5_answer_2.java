package ACMmodel.TenCentOld.spring2018;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 腾讯校招题：这里唯一的一个点就是时长少，但是难度等级大，而且收益会更高，这样就会破坏贪心的规则，只能借助更棒的算法来思考，
 * 这个题在30min之内就很难写通过，本人当时做通过率20%
 *
 * @author quanhangbo
 * 算法思路：根据题意,要完成一个任务必须满足机器的时间长大于任务任务长并且机器等级大于任务等级
 * 1.在这里我们用2个（机器，任务）二维数组来存储:比如说用mech[i][0]表示机器时间，mech[i][1]表示的是机器的难度系数
 * 2.存储后对对两个二维数组进行降序排序，先按时间长来降序排列，如果时间相同的话，按照等级排序
 * 3.遍历机器数，把满足条件的数存储到一个专门的数组中，由于是按照降序排列的话，数组前面的利益肯定是大于后面的
 * 4.遍历任务数，进行求和
 */
public class Main5_answer_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int mech[][] = new int[n][2];//这是用来表机器参数（mech[i][0]表示时间，mech[i][1]表示的是机器的难度系数）
        int tech[][] = new int[m][2];//这是用来表任务参数（tech[i][0]表示时间，tech[i][1]表示的是任务的难度系数）
        for (int i = 0; i < n; i++) {
            mech[i][0] = in.nextInt();
            mech[i][1] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            tech[i][0] = in.nextInt();
            tech[i][1] = in.nextInt();
        }
        //对于这两个二维数组进行排序，降序排列，先按时间排序，如果时间相同的话就按等级排序
        Arrays.sort(mech, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] - o2[0] == 0) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });
        Arrays.sort(tech, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] - o2[0] == 0) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });

        int j = 0;//该变量用来遍历机器数
        long sum = 0;//尤其要这里样用long型，在自己一直调试调试通过率为90%的情况，只是因为原来用的是int，换成long型就可通过了
        int count = 0;//用来表示满足条件的机器数
        int[] mark = new int[1000];//这个数组是用来存放满足条件的机器参数
        for (int i = 0; i < m; i++) {
            while (j < n && tech[i][0] <= mech[j][0]) {
                mark[mech[j][1]]++;//根据机器的等级，使mark数组自增（主要来解决一个机器只能用1次）
                j++;
            }
            for (int k = tech[i][1]; k < 1000; k++) {
                if (mark[k] > 0) {//从mark数组中每次拿一个数，注意mark数组的参数全部是满足时间大于任务的时间并且机器等级大于任务等级
                    //而且相对而讲是当前利益的最大值
                    mark[k]--;
                    count++;//完成任务数自增
                    sum += 200 * tech[i][0] + 3 * tech[i][1];//将利益求和
                    break;
                }
            }
        }
        System.out.println(count + " " + sum);
    }
}

