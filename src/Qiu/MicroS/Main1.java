package Qiu.MicroS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main1 {
    public static void main(String[] args) {
        Main1 so = new Main1();
        int[] nums = new int[]{5,19,8,1};
        int ans = so.solution(nums);
        System.out.println(ans);

    }
    public int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        PriorityQueue<Double> que = new PriorityQueue(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1<=o2){
                    return  1;
                }
                return  -1;
            }
        });
        double total = 0;
        for(int i=0;i<A.length;i++){
            total+=A[i];
           que.add(A[i]*1.0);
        }
        double target = total/2;
        double subSum = 0;
        int cou = 0;
        while(subSum<target){
            double t = que.poll()/2;
            subSum += t;
            cou++;
            que.add(t);
        }
        return cou;
    }
}
