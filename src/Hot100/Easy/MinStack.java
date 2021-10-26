package Hot100.Easy;

import java.util.*;
/**会超时，所有操作不全是O（1）
 * */
public class MinStack {
    private Deque<Integer> stack;
    private List<Integer> sortArr = new LinkedList<>(); //对栈元素从小到大排序

    public MinStack() {
        stack = new LinkedList<Integer>();

    }

    public void push(int val) {
        stack.push(val);
        updateSortArr(0);
    }

    public void pop() {
        updateSortArr(1);
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return sortArr.get(0);
    }

    /*op:0-push 操作，1-pop操作
     * */
    private void updateSortArr(int op) {
        int val = stack.peek();
        /*push*/
        if(op==0){
            if(sortArr.size() == 0){
                sortArr.add(val);
                return ;
            }else{
                int index=sortArr.size();
                for(int i=0;i<sortArr.size();i++ ){
                    if(val<sortArr.get(i)){
                        index = i;
                        break;
                    }
                }
                sortArr.add(index,val);
            }
        }
        /*二分查找*/
        if(op == 1){
            int left =0,right = sortArr.size()-1;
            while(left<=right){
                int mid = (left+right)/2;
                int ele = sortArr.get(mid);
                if(val ==ele ){
                    sortArr.remove(mid);
                    return;
                }else if(val < ele){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }

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
