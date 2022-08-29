package EeacDay;

import java.util.Deque;
import java.util.LinkedList;
/**
 *
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 *
 *  
 * 示例 1 ：
 *
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class M0810 {
    public String removeKdigits(String num, int k) {
        Deque<Character> que = new LinkedList();
        int cou = k;
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            if(que.isEmpty()){
                que.offer(ch);
                continue;
            }
            while(!que.isEmpty() && que.peekLast()>ch && cou>0){ //要用while 而不是 if，保持已入队是单调的
                que.pollLast();
                cou--;
            }
            que.offer(ch);
        }
        while(cou>0 && !que.isEmpty()){
            que.pollLast();
            cou--;
        }
        while(!que.isEmpty() && que.peekFirst()=='0'){
            que.poll();
        }
        if(que.size()==0) return new String("0");
        else{
            StringBuilder sb = new StringBuilder();
            for(Character e:que){
                sb.append(e);
            }
            return sb.toString();
        }



    }
}
