package SwordOf.String;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class IsValid {
    public boolean isValid (String s) {
        Deque<Character> stack = new LinkedList<Character>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(i==0){
                stack.push(ch);
            }else{
                if(ch == ')'||ch == ']'||ch == '}'){
                    if(!stack.isEmpty()){

                        char check = stack.pop();
                        switch(ch){
                            case ')': if(check=='(') continue;
                            case ']': if(check=='[') continue;
                            case '}': if(check=='{') continue;
                            default:return false;
                        }

                    }else return false;

                }else{
                    stack.push(ch);
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else return false;

    }

    @Test()
    public void test(){
        String str = "([)]";
        boolean res = isValid(str);
        System.out.println(res);
    }
}
