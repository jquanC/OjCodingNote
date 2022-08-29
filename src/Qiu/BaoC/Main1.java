package Qiu.BaoC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main1 {
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
        int barCou = 0;
        HashMap<Integer,Integer> barMap = new HashMap();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='|'){
                barCou++;
                barMap.put(i+1,barCou);
            }
        }
        int[] f = new int[barCou+1];
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
            }
            if(s.charAt(i)=='|'){
                int barId = barMap.get(i+1);
                f[barId] = starCou;
            }
        }
        List<Integer> ans = new ArrayList();
        for(int i=0;i<startIndex.size();i++){
            int si = startIndex.get(i);
            int ei = endIndex.get(i);
            int startBar = -1;
            int endBar = -1;
            for(int j=si;si<=ei;j++){
                if(s.charAt(j-1)=='|'){
                    startBar = barMap.get(j);
                    break;
                }

            }
            for(int j=ei;ei>=si;j--){
                if(s.charAt(j-1)=='|'){
                    endBar = barMap.get(j);
                    break;
                }
            }
            if(startBar == endBar){
                ans.add(0);
            }else{
                ans.add(f[endBar]-f[startBar]);
            }
        }
        return ans;

    }
}
