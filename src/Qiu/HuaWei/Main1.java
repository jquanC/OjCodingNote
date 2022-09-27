package Qiu.HuaWei;

import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
//    "abcabcbb"
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str == null || str.equals("")) System.out.println(0);
        HashSet<Character> set = new HashSet();
        int ans = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                ans = Math.max(ans,set.size());
                continue;
            }
            int len = set.size();//abca
            for(int j=i-len;j<i;j++){
                if(ch != str.charAt(j)){//前面的要去掉
                    set.remove(str.charAt(j));
                    continue;
                }
                break;
            }
            if(set.size()+str.length()-i+1<ans) break;
        }
        System.out.println(ans);
    }
}
