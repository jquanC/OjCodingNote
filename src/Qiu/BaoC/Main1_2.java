package Qiu.BaoC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main1_2 {
    public static void main(String[] args) {
        /**

         |||||******|**|****|******|*|*||*|******|*||**|***|***|**||*|**|***|*|*|**||***|******|*|||*****||||
         * */
       /* String s = new String("*|*|*|");
        List<Integer> silist = new ArrayList();
        silist.add(1);
        List<Integer> eilist = new ArrayList();
        eilist.add(6);*/
       /* String s = new String("*|*|");
        List<Integer> silist = new ArrayList();
        silist.add(1);
        List<Integer> eilist = new ArrayList();
        eilist.add(3);*/
        String s = new String("|**|*|*");
        List<Integer> silist = new ArrayList();
        silist.add(1);silist.add(1);
        List<Integer> eilist = new ArrayList();
        eilist.add(5);eilist.add(6);
        List<Integer> ans =  starsAndBars(s,silist,eilist );
        System.out.println(ans.toString());
    }
    //|||||******|**|****|******|*|*||*|******|*||**|***|***|**||*|**|***|*|*|**||***|******|*|||*****||||
    public static List<Integer> starsAndBars(String s, List<Integer> startIndex, List<Integer> endIndex) {
        // Write your code here

        int[] f = new int[s.length()+1];
        int starCou = 0;
        boolean flagStart = false;
        for(int i=0;i<s.length();i++){
            //没遇到一个开始的 '|'
            if(s.charAt(i)!='|' && !flagStart) continue;
            if(s.charAt(i)=='|' && !flagStart){
                flagStart = true;
                continue;
            }
            if(s.charAt(i)=='*'){
                starCou++;
                f[i+1] = f[i];
            }
            if(s.charAt(i)=='|'){
                f[i+1] = starCou;
            }
        }
        List<Integer> ans = new ArrayList();
        for(int i=0;i<startIndex.size();i++){
//            ans.add(f[endIndex.get(i)]-f[startIndex.get(i)]);
            boolean valid = false;
            for(int j = startIndex.get(i)-1;j<= endIndex.get(i)-1;j++){
                if(s.charAt(j)=='|'){
                    valid = true;
                    ans.add(f[endIndex.get(i)]-f[j+1]);
                    break;
                }
            }
            if(!valid) ans.add(0);
        }
        return ans;

    }
}
