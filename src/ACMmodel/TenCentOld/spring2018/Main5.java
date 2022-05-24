package ACMmodel.TenCentOld.spring2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
* 题目要求在第一天：尽可能完成任务数量最大

/**
 * 此题有争议，看收益函数：200 * 任务时间 + 3 * 等级
 * 题解是默认贪心处理最长任务时间的任务来处理的，并贪心的匹配最接近等级的机器；这符合常识和直觉，但不能通过极端的特例；所以先暂时忽略这一点；
 * 题目的代码贪心代码还是有学习的地方的
 */
//有时想简单点反而好
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //机器数
        int n = sc.nextInt();//任务数
        sc.nextLine();
        Node[] tasks = new Node[n];
        Node[] machs = new Node[m];
        for(int i=0;i<m;i++){
            machs[i] = new Node(sc.nextInt(), sc.nextInt());
            sc.nextLine();
        }
        for(int i=0;i<n;i++){
            tasks[i] = new Node(sc.nextInt(), sc.nextInt());
            sc.nextLine();
        }

        Comparator<Node> comp  = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.time == o2.time){
                    return o2.level - o1.level;
                }else{
                    return o2.time - o1.time;
                }
            }
        };
        Arrays.sort(tasks,comp);
        Arrays.sort(machs,comp);

        long sum=0;
        int ansCou = 0;
        int j=0;
        int[] cntFitMacLev = new int[105];
        //贪心：先处理时间长的任务；一个时间长的任务处理时，选择一个和它等级最接近的
        //多个相同等级但最大工作时间不同的的机器，但都能处理一个任务时，任意选一个机器就行了；
        //因为没被选择的机器一定可以满足后续的任务（任务按时间降序的），而收益是按任务时间计算的，对结果没有影响
        for(int i=0;i<tasks.length;i++){
            while(j<m && machs[j].time>=tasks[i].time){
                cntFitMacLev[machs[j].level]++;
                j++;
            }
            for(int level = tasks[i].level;level<=100;level++ ){
                if(cntFitMacLev[level]>0){
                    sum += 200*tasks[i].time + 3*tasks[i].level;//不是level
                    ansCou++;
                    cntFitMacLev[level]--;//不是cntFitMacLev[tasks[i].level]--
                    break;
                }
            }

        }
        System.out.println(ansCou+" "+sum);
    }

}
class Node{
    int time;
    int level;
    public Node(int time,int level){
        this.time = time;
        this.level = level;
    }
}
