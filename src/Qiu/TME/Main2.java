package Qiu.TME;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        double a = 1237917520000000.0000;
        double b = Math.pow(10,2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a%b);
        System.out.println(a%b==0);
        return  ;
    }
    /**
     *
     a中元素均是正整数
     * */
    public int getSubarrayNum (ArrayList<Integer> a, int x) {
        // write code here
        long ans = 0;
        long P = 1000000007;
        double checkTail = (int)Math.pow(10,x);
        for(int i=0;i<a.size();i++){
            double mul = 1;
            for(int j=i;j<a.size();j++){
                mul *= a.get(j);
                if(mul%checkTail==0){ //[i,j...a.size()-1]
                    ans+=(a.size()-j);
                    if(ans>P) ans %= P;
                    break;
                }
            }
        }
        return  (int)ans;
    }

}
