package ACMmodel.TenCent;

import java.util.Scanner;

public class Main3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        char[] crr = line.toCharArray();
        int len = crr.length;
        long[] dj = new long[len+2];//[0，i]的进攻力
        long[] df = new long[len+2];//[i,len-1]的防御力

        if(n==1){
            System.out.println(Math.abs(crr[0]-'0'));
        }

        for(int i=1;i<=len;i++){
           if(crr[i-1]=='0'){
               dj[i] = dj[i-1]+i;
           }else dj[i] =dj[i-1];
        }
        for(int i=len;i>=1;i--){
            if(crr[i-1]=='1'){
                df[i] = df[i+1]+i;
            }else df[i] =df[i+1];
        }
        long ans = Integer.MAX_VALUE;
        for(int i=0;i<=len;i++){
            long oneAns = Math.abs(dj[i]-df[i+1]);
            if(oneAns<ans) ans = oneAns;
        }

        System.out.println(ans);
    }
}
