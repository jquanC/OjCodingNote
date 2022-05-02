package ACMmodel.TenCentOld.fall2021;

import java.util.Scanner;
/*
6
010101
7

20
11111000111011101100
94

4
1100
6

* */
public class Main1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int [] arr = new int[len];

        for(int i=0;i<len;i++){
            if(str.charAt(i)=='1') arr[i] = 1;
        }
        int sConMark=1;
        for(int i=1;i<len;i++){
            if(arr[i] == arr[i-1]) sConMark++;
            else break;
        }
        int ans = (1+sConMark)*(sConMark)/2;

        ans += process(arr,sConMark,sConMark);
        System.out.println(ans);

    }
    public static int  process(int[] arr, int step,int baseVal){
        if(step == arr.length) return 0;
        //计算一个理论最大值可截枝的
        int resSumMax = (baseVal+1 + baseVal+(arr.length-1 - step))*(arr.length-1-step)/2;

        int ans = 0;
        //不删除
        if(arr[step] == arr[step-1]){
            ans = baseVal+1+ process(arr,step+1,baseVal+1);
        }else{
            ans = 1+process(arr,step+1,1);
        }
        //一个截枝条件
        if(ans == resSumMax) return resSumMax;
        //删除
        int tem = arr[step];
        arr[step] = arr[step-1];//后面比较会用倒
        int ans2 = process(arr,step+1,baseVal);
        arr[step] = tem;

        return ans>ans2 ? ans:ans2;
    }
}
