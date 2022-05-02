package Blank;

import java.util.Stack;
/**
 * [1,2,3,4,5]
 * [4,3,5,1,2]
 * */
public class LC89 {
    public static void main(String[] args) {
        int[] pusharr = new int[]{1,2,3,4,5};
        int[] poparr = new int[]{4,5,3,2,1};
        boolean ans = validateStackSequences(pusharr,poparr);
        System.out.println(ans);

    }
    public  static boolean validateStackSequences(int[] pushed, int[] popped) {
        int pIn = 0;
        int pOut = 0;
        int len = pushed.length;
        Stack<Integer> stack = new Stack<Integer>();

        while(pOut< len){
            //入栈
            int oNum = popped[pOut++];

            //先看栈顶，从已入栈的数找
            if(!stack.isEmpty()&&stack.peek()==oNum){
                stack.pop();
                continue;
            }
            //从未入栈的数找
            boolean find = false;
            while(pIn<len){
                if(pushed[pIn] == oNum){
                    pIn++;//出入抵消，就不用入栈了
                    find = true;
                    break;
                }
                stack.push(pushed[pIn++]);
            }
            //找到该数抵消,找不到说明不合法
            if(find == false) return false;
        }
        return true;

    }
}
