package ACMmodel.NIO;

import com.sun.org.glassfish.external.statistics.impl.AverageRangeStatisticImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> ans = new ArrayList();
        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = sc.nextLine();
            if(verify(inputs[i])){
                ans.add("yes");
            }else ans.add("no");

        }
        for(String e: ans) System.out.println(e);
    }

    public static boolean verify(String str) {
        //预处理获得连续的数字片段
        List<String> strs = new ArrayList<>();
        //获取长度大于3的数字子字符串
        for(int i=0;i<str.length();i++){
            int ch = str.charAt(i);
            if(Character.isDigit(ch)){
                String numStr = "";
                while(i<str.length()&& Character.isDigit(str.charAt(i))){
                    numStr += str.charAt(i);
                    i++;
                }
                if(numStr.length()>=3){
                    strs.add(numStr);
                }
            }
        }
        return verifyStrs(strs);
    }
    public static boolean verifyStrs(List<String> strs){
        if(strs==null || strs.size()==0) return  false;

        boolean res = false;
        for(String str : strs){
            int flag = -1;
            if(str.charAt(1)-str.charAt(0) >=0) flag = 1;

            boolean ans = true;
            for(int i=1;i<str.length();i++){
                if(flag == 1){
                    if(str.charAt(i)-str.charAt(i-1) == 1){
                        continue;
                    }else{
                        ans = false;
                        break;
                    }
                }else{
                    if(str.charAt(i)-str.charAt(i-1) == -1){
                        continue;
                    }else{
                        ans = false;
                        break;
                    }

                }
            }
            res = res || ans;
        }
        return res;
    }
}
