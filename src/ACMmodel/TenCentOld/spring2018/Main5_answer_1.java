package ACMmodel.TenCentOld.spring2018;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main5_answer_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Node[] machine = new Node[n];
        Node[] task = new Node[m];

        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.setTime(in.nextInt());
            node.setLevel(in.nextInt());
            machine[i] = node;
        }
        for (int i = 0; i < m; i++) {
            Node node = new Node();
            node.setTime(in.nextInt());
            node.setLevel(in.nextInt());
            task[i] = node;
        }
        // 从收益公式来看，任务的执行时间越长、等级越高，则收益更大
        // 将任务、机器按时间从大到小排序，时间相同时，则按照等级从大到小排序
        Arrays.sort(task, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.getTime() == o2.getTime())
                    return o2.getLevel().compareTo(o1.getLevel());
                return o2.getTime().compareTo(o1.getTime());
            }
        });
        Arrays.sort(machine, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.getTime() == o2.getTime())
                    return o2.getLevel().compareTo(o1.getLevel());
                return o2.getTime().compareTo(o1.getTime());
            }
        });
        int[] cont = new int[105]; //下标表示等级，等级范围是0-100
        int j = 0;
        int num = 0;
        long ans = 0;
        for (int i = 0; i < m; i++) {
            //对每个任务进行遍历
            Node taski = task[i];
            //能执行该任务的各个等级的机器的数目
            while (j < n && machine[j].getTime() >= taski.getTime()) {
                cont[machine[j].getLevel()]++; //对任务i，能完成该任务的某等级的机器数+1
                j++;
            }
            for (int level = taski.getLevel(); level <= 100; level++) {
                //尽量用最小的等级机器来执行
                if (cont[level] > 0) {
                    num++;
                    cont[level]--; //一个机器只能执行一个任务
                    ans += (200 * taski.getTime() + 3 * taski.getLevel());
                    break;
                }
            }
        }
        System.out.println(num + " " + ans);
    }

    static class Node {
        Integer time, level;

        public Integer getTime() {
            return time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }
    }
}