package ACMmodel.WeBank;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String str =  sc.nextLine();
        StringBuilder sb = new StringBuilder(str);

        int ans = 0;
       /* int[] bitVal = new int[len];
        for(int i=0;i<len;i++){
            bitVal[i] = (str.charAt(i)-'0')*(int)Math.pow(10,len-i-1);
        }*/
        int statPos = 0;
        for(int i=0;i<len;i++){
            String tStr = str.substring(statPos,len);
            int oriNum = Integer.parseInt(tStr);
            int bw = 0;
            for(int j=len;j>i;j--){
                if(j==len){
                    if(oriNum %k==0) ans++;
                    continue;
                }
                if(oriNum %k ==0) ans++;
                oriNum -= (str.charAt(j-1)-'0')*Math.pow(10,bw++);
            }
        }
        int speVal = Integer.valueOf(str);
        if(speVal%k==0) ans--;

        System.out.println(ans);
    }
}
