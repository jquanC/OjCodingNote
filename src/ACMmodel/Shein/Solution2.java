package ACMmodel.Shein;


import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    public static void main(String[] args) {
        String test =  "wq2[2[aa]2[bb]]cc";
        Solution2 so = new Solution2();
        String ans = so.decodeString(test);
        System.out.println(ans);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return string字符串
     */
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        // write code here
        LinkedList<String> stack = new LinkedList<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(  Character.isDigit(ch)){
                int num  = 0;
                while(Character.isDigit(ch)){
                    num = num*10+(ch-'0');
                    i++;
                    ch = s.charAt(i);
                }
                stack.addLast(String.valueOf(num));

            }
            if( ch=='['||Character.isLetter(ch)){
                stack.addLast(String.valueOf(ch));
                continue;
            }
            if(ch==']'){
                String str = "";
                while(!stack.peekLast().equals("[")){
                     str = stack.pollLast()+str;
                }
                stack.pollLast();//去掉'['
                int repeatedNum = Integer.valueOf( stack.pollLast());
                String temp  = "";
                for(int j=0;j<repeatedNum;j++){
                    temp+=str;
                }
                stack.addLast(temp);
            }
        }
        String ans = "";
        while(!stack.isEmpty()){
            ans+=stack.pollFirst();
        }
        return ans;
    }

}