package EeacDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class M0816 {
    public static void main(String[] args) {
        M0816 so = new M0816();
        String[] words = new String[]{"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> ans = so.palindromePairs(words);
        for(List<Integer> e:ans){
            System.out.println(e.toString());
        }


    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        HashMap<String,Integer> revMap = new HashMap();
        for(int i=0;i<words.length;i++){
            revMap.put(new StringBuilder(words[i]).reverse().toString(),i);
        }
        for(int i=0;i<words.length;i++){
            String word = words[i];
            int len = word.length();
            if(len == 0) continue;

            for(int j=0;j<=len;j++){

                if(isHuiStr(word.substring(j,len))){
                    int rightId = revMap.getOrDefault(word.substring(0,j),-1);
                    if(rightId!=-1 && rightId !=i){
                        ans.add(Arrays.asList(i,rightId));// learned
                    }
                }
                if(j!=0 && isHuiStr(word.substring(0,j))){
                    int leftId = revMap.getOrDefault(word.substring(j,len),-1);
                    if(leftId != -1 && leftId!=i){
                        ans.add(Arrays.asList(leftId,i));
                    }

                }
            }
        }
        return ans;

    }
    public boolean isHuiStr(String str){
        int left = 0;
        int right = str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
