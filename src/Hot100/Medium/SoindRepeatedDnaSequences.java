package Hot100.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SoindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s){
        HashSet<String> strSet = new HashSet<>();
        List<String> list = new ArrayList<>();
        int n = s.length();
        for(int i=0;i<n-10+1;i++){
            String subStr = s.substring(i,i+10);
            if(!strSet.contains(subStr)){
                strSet.add(subStr);
            }else{
                if(!list.contains(subStr)) list.add(subStr);
            }
        }
        return list;

    }
}
