package Hot100.Easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**会超时，所有操作不全是O（1）
 * */
public class MinStackSo2 {
    private Deque<Integer> stack;
    private Deque<Integer> supportStack;


    public MinStackSo2() {
        stack = new LinkedList<Integer>();
        supportStack = new LinkedList<>();

    }

    public void push(int val) {
        stack.push(val);
        if(supportStack.size()==0) supportStack.push(val);
        else{
            int curMin =  supportStack.peek();
            if(val < curMin )supportStack.push(val) ;
            else supportStack.push(curMin);
        }

    }

    public void pop() {
        stack.pop();
        supportStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return supportStack.peek();
    }





/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
