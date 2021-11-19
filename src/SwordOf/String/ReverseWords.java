package SwordOf.String;

import java.util.Stack;


public class ReverseWords {
    //"the sky is blue"
    public String reverseWords(String s) {
        int startPos=-1;
        Stack<String> stack = new Stack<>();//也可以用 linkedList来实现
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ' && startPos==-1) startPos = i; //记录一个 str的开始

            //记录一个str
            if(s.charAt(i)==' '&& startPos!=-1){
                stack.push(s.substring(startPos,i));
                startPos = -1;
                continue;
            }
            //末尾不是空格，需要把这种情况最后一个str加进来
            if(i==s.length()-1 && startPos!=-1){
                stack.push(s.substring(startPos,i+1));
            }
        }
        StringBuilder resSbu = new StringBuilder();
        while(!stack.isEmpty()){
            resSbu.append(stack.pop());
            if(stack.size()!=0)  resSbu.append(" ");
        }
        return resSbu.toString();

    }
}
