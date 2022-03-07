package ACMmodel.ByteDance;

import java.util.Arrays;
import java.util.Scanner;

/**n个数，且取自[1，n]不重复。如何排列，使得相邻2个数和为奇的个数是k。输入：n,k*/
public class BD20220228n2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n,k;
        n = scan.nextInt();
        k = scan.nextInt();
        scan.nextLine();

        int [] ans = new int[n];
        int flag =0;
        //i是下标
        for(int i=0;i<k;i++){
            ans[i] = i+1;
        }
        if(ans[k-1]%2==1) flag = 1;

        //j是值
        int index = k;
        for(int j=k+1;j<=n;j++){
            if(flag ==1 && j%2==1){
                ans[index++] = j;
            }
            if(flag ==0 && j%2==0){
                ans[index++] = j;
            }

        }
        if(flag == 1) flag =0;
        else flag = 1;

        for(int j=k+1;j<=n;j++){
            if(flag ==1 && j%2==1){
                ans[index++] = j;
            }
            if(flag ==0 && j%2==0){
                ans[index++] = j;
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
