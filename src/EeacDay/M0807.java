package EeacDay;

import java.util.ArrayList;
import java.util.Arrays;

public class M0807 {
    public static void main(String[] args) {
        M0807 so = new M0807();
        String S = "qqe";
        String[] ans = so.permutation(S);
        System.out.println(Arrays.toString(ans));

    }
    ArrayList<String> ans;
    public String[] permutation(String S) {
        char[] crr = S.toCharArray();
        ans = new ArrayList<String>();
        Arrays.sort(crr);
        ans.add(new String(crr));//初始解
        next(crr);
        String[] ansArray = new String[ans.size()];
        ans.toArray(ansArray);
//        ansArray =  ans.toArray(ansArray);

        return ansArray;
    }
    public void next(char[] crr){

        boolean find = true;
        while (find){
            find = false;
            for(int i=crr.length-2;i>=0 ;i--){
                if(crr[i]<crr[i+1]){
                    find = true;
                    for(int j= crr.length-1;j>=i;j--){
                        if(crr[j]>crr[i]){
                        char t = crr[i];
                        crr[i] = crr[j];
                        crr[j] = t;
                        //调整 交换后的 后段升序
                        int start = i+1;
                        int end = crr.length-1;
                        while(start<end){
                            char tt = crr[end];
                            crr[end] = crr[start];
                            crr[start] = tt;
                            start++;
                            end--;
                        }
                        String oneStr = new String(crr);
                        ans.add(oneStr);
                        break;
                        }
                    }
                    break;
                }

            }

        }


    }
}
