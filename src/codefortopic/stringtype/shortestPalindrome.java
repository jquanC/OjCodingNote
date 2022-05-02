package codefortopic.stringtype;


import org.junit.Test;

public class shortestPalindrome {

//    int cou = 1;
    public String shortestPalindrome(String s) {
        int len = s.length();
        boolean find = false;
        int end;
        for(end = s.length()-1;end>0;end--){
            find = checkIsPalindrome(s,0,end);
            if(find) break;
        }
        String add = "";
        for(int i=s.length()-1;i>end;i--){
            add+=s.charAt(i);
        }

        return add+s;


    }
    /*O(n) 内check是不是一个回文串*/
    public boolean checkIsPalindrome(String s, int start,int end){
       while(end>start){
           if(s.charAt(start) != s.charAt(end)) return false;
           end--;
           start++;
       }
//        System.out.println(cou);
       return true;
    }
    @Test
    public void test(){}

}
