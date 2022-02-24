package test.ByteDance;
import java.util.*;

/**
 * input
 * 3
 * lark larkisthebestofficesoftware
 * dancebyte bytedanceisagreatplacetowork
 * lark showmethecode
 * */
public class test01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();//读回车
        String[][] input = new String[n][2];
        boolean[] ans = new boolean[n];

        for(int i=0;i<n;i++){
            //String temp = scan.nextLine();
            String temp = scan.nextLine();
            temp.trim();
            // System.out.println("temp："+temp);
            String[] temArr = temp.split(" ");
            if(temArr.length == 1){
                input[i][0] = temp;
                input[i][1] = "";
                continue;
            }
            input[i][0] = temArr[0];
            input[i][1] = temArr[1];
            /*
            int flag = 0;
            int j = 0;
            for(;j<temp.length();j++){
                if(temp.charAt(j) == ' ') break;
            }
            //特殊情况
            if(j == temp.length()){
                input[i][0] = temp;
                input[i][1] = "";
                continue;
            }
            input[i][0] = temp.substring(0,j);
            input[i][1] = temp.substring(j+1,temp.length());
            */

        }
        for(int i=0;i<n;i++){
            ans[i] = canMatch(input[i][0],input[i][1]);
        }
        for(boolean e : ans){
            if(e)   System.out.println("YES");
            else  System.out.println("NO");
        }

    }
    private static boolean canMatch(String s1, String s2){
        if( s2.length() == 0 || s2.length() < s1.length() )  return false;

        int[] s1map = new int[26];
        int[] s2map = new int[26];
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        for(int i=0;i<s1Arr.length;i++){
            s1map[s1Arr[i]-'a']++;
            s2map[s2Arr[i]-'a']++;
        }
        boolean ans = isArrayEqual(s1map,s2map);
        if(ans == true) return ans;

        int len1 = s1Arr.length;
        for(int i=len1;i<s2Arr.length;i++){
            s2map[s2Arr[i-len1]-'a']--;
            s2map[s2Arr[i]-'a']++;

            //   ans = Arrays.equals(s1map,s2map);
            ans = isArrayEqual(s1map,s2map);
            if(ans == true) return true;
        }
        return false;
    }
    private static boolean isArrayEqual(int[] arr1,int[] arr2){
        if(arr1.length != arr2.length) return false;

        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }

}





