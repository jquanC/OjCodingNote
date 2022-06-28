package ACMmodel.Meituan.re;

import java.util.Scanner;

/**test
 * 5
 * 1 2 3 4 5 ans:15
 * 7
 * -1 -2 3 5 -2 -4 4  ans:12
 * 8
 * 2 1 -3 2 -3 1 1 5   ans:10
 *
 * 给出长度为n的数组，可以翻转任意一段，问翻转一段之后的数组最大子段和为多少
 * */

public class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] preSum = new int[n];
        int[] postSum = new int[n];
        preSum[0] = arr[0];
        for(int i=1;i<n;i++){
            if(preSum[i-1]>0){
                preSum[i] = preSum[i-1]+arr[i];
            }else{
                preSum[i] = arr[i];
            }
        }
        postSum[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(postSum[i+1] >0) postSum[i] = postSum[i+1]+arr[i];
            else postSum[i] = arr[i];
        }

        int maxSum = preSum[0];
        int maxPre = preSum[0];
        for(int i=1;i<n-1;i++){
            if(preSum[i]>maxPre) maxPre = preSum[i];
            if(maxPre+postSum[i+1]>maxSum) maxSum = maxPre+postSum[i+1];
        }
        System.out.println(maxSum);
    }
}
