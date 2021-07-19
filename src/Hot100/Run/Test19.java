package Hot100.Run;

import Hot100.Medium.So19ZiMuYiWeiCi;

import java.util.Arrays;
import java.util.List;

public class Test19 {
    public static void main(String args[]){
        String[] strs = new String[]{"ddddddddddg","dgggggggggg"};
        So19ZiMuYiWeiCi so = new So19ZiMuYiWeiCi();
        List<List<String>>ans =  so.groupAnagrams(strs);
        System.out.println(Arrays.toString(ans.toArray()) );
    }
}
