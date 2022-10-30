package Qiu.Tencent;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/***
 选择数p , 肯定用优先队列存
 选择策略：每个数1的个数的计数为优先级
 ap->cnt: 入队出对
 操作k次，并当从队列取出的数=1时，程序可以提前结束
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        PriorityQueue<Integer> que = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1Cou = Integer.bitCount(o1);
                int o2Cou = Integer.bitCount(o2);
                if(o1-o1Cou < o2-o2Cou){
                    return 1;
                }
                return  -1;
            }

        });
        int cou = 0;
        while(cou<n){
            Integer cur = sc.nextInt();
            que.offer(cur);
            cou++;
        }
        cou = 0;
        long ans = 0;
        while(que.size()!=0 && cou<k){
            Integer getCur = que.poll();
            int oneCou = Integer.bitCount(getCur);
            if(oneCou == 1){//先出除队列并加上，且不占用一次变换次数
                ans+=1;
                cou++;
                continue;
            }
            que.offer(new Integer(oneCou));
            cou++;
        }

        for(Integer e : que){
            ans += e;
        }
        System.out.println(ans);


    }
}
