package Qiu.ZhongX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    static List<String> ans = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();
        if(n>=9){
            System.out.println(ans.toString());
            return;
        }

        sc.nextLine();
        cal(new int[4],new int[6],0,n);
//        System.out.println("cou="+ans.size());
        System.out.println(ans.toString());
    }
    //p: 0....9
    public static void cal(int[]shi,int[]fen,int p,int resLights){

        if(resLights == 0){
            //check and record

            //cal shi
            int shiNum=0;
            int  wright=0;
            for(int i=3;i>=0;i--){
                int t = (int)Math.pow(2,wright++);
                if(shi[i]==1) shiNum+=t;
            }
            if(shiNum>=12) return;

            //cal fen
            int fenNum=0;
            wright=0;
            for(int i=9;i>=4;i--){
                int t = (int)Math.pow(2,wright++);
                if(fen[i-4]==1) fenNum+=t;
            }
            if(fenNum>=60) return;

            String shiStr = String.valueOf(shiNum);
            String fenStr = "";
            if(fenNum<10){
                fenStr += "0"+String.valueOf(fenNum);
            }else fenStr = String.valueOf(fenNum);
            ans.add(shiStr+":"+fenStr);

            return;

        }
        if(9-p+1<resLights) return;//截枝
        if(p>9) return;

        if (p <= 3) {
            cal(shi,fen,p+1,resLights);
            shi[p]=1;
            cal(shi,fen,p+1,resLights-1);
            shi[p] = 0;
        }else{
            cal(shi,fen,p+1,resLights);
            fen[p-4] =1 ;
            cal(shi,fen,p+1,resLights-1);
            fen[p-4] = 0;
        }
    }
}
