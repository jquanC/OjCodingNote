package Hot100.Easy;

import java.util.Stack;

public class Solution1 {
    // 括号匹配函数
    public boolean isValid(String s) {
        Stack<Character> aStack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(aStack.empty()){
                if(s.charAt(i)=='}' || s.charAt(i)==')' ||s.charAt(i)==']'){
                    return false;
                }else{
                    aStack.push(s.charAt(i));
                }
            }else{
                if(aStack.peek() == '('){
                    if(s.charAt(i)==')') aStack.pop();
                    else aStack.push(s.charAt(i));
                }else if(aStack.peek() == '{'){
                    if(s.charAt(i)=='}') aStack.pop();
                    else aStack.push(s.charAt(i));
                }else if(aStack.peek() == '['){
                    if(s.charAt(i)==']') aStack.pop();
                    else aStack.push(s.charAt(i));
                }else{
                    aStack.push(s.charAt(i));
                }
            }
        }
        if(aStack.empty())  return true;
        else return false;
    }
}
