package ACMmodel.NetEase;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt(); //数组长度
        long k = sc.nextLong(); //数组最大值
        long x = sc.nextLong(); //数组元素和
        //要求数组元素各不相同
        //n 和 k 确定，可以求出数组和的范围，可以判断是否可解
        //构造
        long[] arr = new long[n];
        long boundMin = (1+(n-1))*(n-1)/2 + k;
        long boundMax = (k+k-n+1)*(n)/2;
        if(x<boundMin || x>boundMax){
            System.out.println(-1);
            return;
        }
        arr[n-1] = k;
        //初始化，从boudMin开始构造
        for(int i=0;i<n-1;i++){
            arr[i] = i+1;
        }
        long curSum = boundMin;
        for(int index = n-2;index>=0;index--){
            boolean find = false;
            while(arr[index]<arr[index+1]-1){
                if(curSum == x){
                    find = true;
                    break;
                }
                arr[index]++;
                curSum++;
            }
            if(find) break;
        }
        for(int i=0;i<n;i++){
            if(i!=n-1) System.out.print(arr[i]+" ");
            else System.out.println(arr[i]);
        }


    }
}
