package Qiu.MicroS;


import java.util.Arrays;


public class Main3 {
    int minBound = 0;
    int curMin = 0x3f3f3f3f;
    boolean find = false;
    public static void main(String[] args) {
        Main3 so = new Main3();
        int[] A = new int[]{4,2,5,4,3,5,1,4,2,7};
        int X=3,Y=2;
        int ans = so.solution(A,X,Y);
        System.out.println(ans);


    }
    public int solution(int[] A, int X, int Y) {
        // write your code in Java 8 (Java SE 8)
        int[] sortArr = new int[A.length];
        for(int i=0;i<A.length;i++){
            sortArr[i] = A[i];
        }
        Arrays.sort(sortArr);
        for(int i=0;i<X;i++){
            minBound += sortArr[i];
        }
        cal(A,0,0,X,Y);
        return  curMin;

    }
    public void cal(int[]A,int curDay,int curSum,int remainTask,int Y){
        //找到解情况
        if(remainTask == 0 && !find ){
            if(curSum<curMin) curMin = curSum;
            if(curSum == minBound){ //且找到理想最小值标记
                find = true;
            }
            return;
        }

        //截枝情况
        if(find) return;//已经找到理想最小值

        if(curSum>curMin) return;//没有好于当前解，截枝
        if(remainTask > A.length-curDay) return;//剩下做seesion的天数不够，截枝
        if(curDay>=A.length) return;



        //两种情况继续搜索
        curSum += A[curDay];
        cal(A,curDay+Y,curSum,remainTask-1,Y);
        curSum-=A[curDay];
        cal(A,curDay+1,curSum,remainTask,Y);

    }
}
