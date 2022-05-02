package ACMmodel.TenCent;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        char[] crr = line.toCharArray();
        int len = crr.length;
        int[] dj = new int[len];//[0，i]的进攻力
        int[] df = new int[len];//[i,len-1]的防御力

        for(int i=0;i<len;i++){
            if(crr[i]=='0'){
                if(i>=1) dj[i] = dj[i-1] + (i+1);
                else dj[i] = i+1;
                continue;
            }
            if(i>1) dj[i] = dj[i-1];
        }
        for(int i=len-1;i>=0;i--){
            if(crr[i]=='1'){
                if(i<len-1) df[i] = df[i+1] + (i+1);
                else df[i] = (i+1);
                continue;
            }
            if(i<len-1) df[i] = df[i+1];
        }
        int ans = 0x3f3f3f3f;
        for(int i=0;i<len-1;i++){
            int oneAns = Math.abs(dj[i]-df[i+1]);
            if(oneAns<ans) ans = oneAns;
        }
        //还有两个特殊情况
        if(df[0]<ans) ans = df[0];
        if(dj[len-1]<ans) ans = dj[len-1];
        System.out.println(ans);
    }
}
