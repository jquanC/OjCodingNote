package EeacDay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class M0623 {
    public static void main(String[] args) {
        String test = "lee(t(c)o)de)";
        String ans = minRemoveToMakeValid(test);
        System.out.println(ans);
    }
    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        List<Integer> delete = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch != '('&& ch != ')'){
                continue;
            }
            if(ch == ')'){
                if(stack.size()==0 ){
                    delete.add(i);
                    continue;
                }

                stack.pop();
                numStack.pop();

            }
            if(ch == '('){
                stack.push('(');
                numStack.push(i);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int e:numStack){
            set.add(e);
        }
        for(int e: delete){
            set.add(e);
        }
        String ans = "";
        for(int i=0;i<s.length();i++){
            if(set.contains(i)) continue;
            ans += s.charAt(i);
        }
        return ans;

    }
}
