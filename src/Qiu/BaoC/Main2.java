package Qiu.BaoC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
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
    public static List<Integer> starsAndBars(String s, List<Integer> startIndex, List<Integer> endIndex) {
        // Write your code here
        List<Integer> ans = new ArrayList();
       for(int i=0;i<startIndex.size();i++){
           int si = startIndex.get(i);
           int ei = endIndex.get(i);
           int starCou = 0;
           boolean meetBar = false;
           for(int j=si-1;j<=ei-1;j++){
              if(s.charAt(j)!='|' && !meetBar)continue;
              if(s.charAt(j)=='|' && !meetBar){
                  meetBar = true;
                  continue;
              }
              if(s.charAt(j)=='*') starCou++;
           }
           for(int j=ei-1;j>=si;j--){
               if(s.charAt(j)=='|') break;
               starCou--;
           }
           ans.add(starCou);
       }
       return ans;

    }
}
