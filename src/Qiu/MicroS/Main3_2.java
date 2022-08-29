package Qiu.MicroS;


import java.util.Arrays;


public class Main3_2 {
    int minBound = 0;
    int curMin = 0x3f3f3f3f;
    boolean find = false;
    public static void main(String[] args) {
        Main3_2 so = new Main3_2();
        int[] A = new int[]{4,2,5,4,3,5,1,4,2,7};
        int X=3,Y=2;
       /* int[] A = new int[]{4,2,3,7};
        int X=2,Y=2;*/
       /* int[] A = new int[]{10,3,4,7};
        int X=2;int Y=3;*/
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
       //枚举每个起点
        for(int i=0;i<Y;i++){
            int startSum = 0;
            int cou = 0;
            int index = i;

            while(cou<X && index<A.length){
                startSum+=A[index];
                index += Y;
                cou++;
            }
            if(cou<X) break;
            if(startSum == minBound){
                curMin = minBound;
                find = true;
                break;
            }
            cal(A,index,startSum,X,Y);
        }
        return curMin;


    }
    public void cal(int[] A, int curDay,int curSum,int X,int  Y){
        //更新记录解
        if(curSum < curMin && !find){
            curMin = curSum;
            if(curMin == minBound) find = true;
        }
        if(find) return;
        //到头了情况
        if(curDay >= A.length) return;
        //窗口往右移动
        curSum-=A[curDay-X*Y];
        curSum+=A[curDay];
        cal(A,curDay+Y,curSum,X,Y);


    }

}
