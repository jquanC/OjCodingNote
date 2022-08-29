package Qiu.MicroSof;

public class Main2_1 {
    public static void main(String[] args) {
        Main2_1 so = new Main2_1();
        String s = "83238";
//        String s = "7";
//        String s = "44";
//        String s = "39878";
//        String s = "00900";
//        String s = "0000";
//        String s = "54321";
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
        String stb = new String();
        //先构造回文对称部分，上部分
        for(int i=9;i>=0;i--){
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
            String part = String.valueOf(curCh);
            int j=1;
            for(;(j<<1)<=pNum;j<<=1){//log n 加速构造
                part += part;
            }
            for(int res = 1;res<=pNum-j;res++){
                part+=curCh;
            }
            stb+=part;
        }
        //构造中间非回文部分 O(1)
        String notP = "";
        for(int i=9;i>=0;i--){
            if(cnt[i]==1){
                notP+=(char)('0'+i);
                break;
            }
        }
        String lastP = new StringBuilder(stb).reverse().toString();
        String ans = stb+notP+lastP;
        return ans;
    }
}
