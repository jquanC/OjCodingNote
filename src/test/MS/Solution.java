package test.MS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String solution(String S, String T) {
        // write your code in Java SE 8- ok,go!
        int slen = S.length();
        int tlen = T.length();

        if(Math.abs(slen-tlen)>=2){
            return "IMPOSSIBLE";
        }
        if(S.equals(T)){
            return "NOTHING";
        }
        //slen-tlen = {0，1}
        if(T.contains(S) && tlen -slen ==1 ){
            if(T.charAt(1) == S.charAt(0)) return "INSERT "+T.charAt(0);
            else return "IMPOSSIBLE";
        }else if(slen == tlen){

            List<Integer> diffPos = new ArrayList<>();
            for(int i=0;i<slen;i++){
                if(S.charAt(i)!=T.charAt(i)) diffPos.add(i);
            }

            if(diffPos.size()>2) return "IMPOSSIBLE";
            else if(diffPos.size()==2){
                if((S.charAt(diffPos.get(0)) == T.charAt(diffPos.get(1)) )&&
                        (S.charAt(diffPos.get(1)) == T.charAt(diffPos.get(0)) )){
                    return "SWAP "+S.charAt(diffPos.get(0))+" "+S.charAt(diffPos.get(1));
                }else return "IMPOSSIBLE";
            }else{
                //diffPos.size()==1
                return "CHANGE "+S.charAt(diffPos.get(0))+" "+T.charAt(diffPos.get(0));
            }

        }else return "IMPOSSIBLE";




    }

    @Test
    public void test(){
        String S="gain";
        String T = "again";
        String res = solution(S,T);
        System.out.println(res);
    }
}
