package Qiu.MicroSof;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        Main2 so = new Main2();
//        String s = "83238";
//        String s = "7";
//        String s = "44";
//        String s = "39878";
//        String s = "00900";//
//        String s = "0000";//
//        String s = "54321";
//        String s = "111222";
//        String s = "11112222";
                String s = "05432198730";
        String ans = so.solution(s);
        System.out.println(ans);

    }
    public String solution(String S) {
        // write your code in Java 8 (Java SE 8)
        int[] cnt = new int[10];
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            cnt[ch-'0']++;
        }
        //开始构造，下面循环均是O(1)的时间复杂度
        StringBuilder stb = new StringBuilder();
        //先构造回文对称部分，上部分
        for(int i=9;i>=0;i--){
            if(i==0 && stb.length()<=0) continue;
            if(cnt[i]<=1) continue;
            //可以构回文
            int pNum =0;
            if(cnt[i]%2==0){
                pNum = cnt[i];
                cnt[i] = 0;
            }else{
                pNum = cnt[i]-1;
                cnt[i] = 1;
            }
            char curCh = (char)('0'+ i);
            StringBuilder part = new StringBuilder().append(curCh);
            int j=1;
            for(;(j<<1)<=pNum/2;j<<=1){//log n 加速构造
                part = part.append(part);
            }
            for(int res = 1;res<=pNum/2-j;res++){
                part.append(curCh);
            }
            stb.append(part);
        }
        //构造中间非回文部分 O(1)
        StringBuilder notP = new StringBuilder();
        for(int i=9;i>=0;i--){
            if(cnt[i]==1 || (i==0&&cnt[i]>=1)){
                notP.append((char)('0'+i));
                break;
            }
        }
        String stbStr = stb.toString();
        StringBuilder lastP = stb.reverse();
        String ans = stbStr+notP.toString()+lastP.toString();
        return ans;
    }
}
