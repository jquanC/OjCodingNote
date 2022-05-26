package ACMmodel.TenCent.re;

import Hot100.Easy.ListNode;
import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.HashMap;
/*输入: 1>2>3>4
[{1,2,3},{2,3,4},{4,1}]
输出:
{1,2,3,4}
输入:
[{3,7,4},{7,4,5,1,10,3}]
输出:
{1,5,4,7,3,10}*/
public class Main4 {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        ListNode two = new ListNode(2);
        two.next = new ListNode(3);
        two.next.next = new ListNode(4);
        ListNode three = new ListNode(4);
        three.next = new ListNode(1);
        ListNode[] a = new ListNode[]{one,two,three};

        ListNode ans = solve(a);
        printListNode(ans);

    }
    public static ListNode solve(ListNode[] a) {
        HashMap<Integer,Integer> preMap = new HashMap<>();
        HashMap<Integer,Integer> nextMap = new HashMap<>();

        int minNum = Integer.MAX_VALUE;

        for(int i=0;i<a.length;i++){
            ListNode oneNode = a[i];
            while(oneNode!=null){
                if(oneNode.next!=null){
                    nextMap.put(oneNode.val,oneNode.next.val);
                    preMap.put(oneNode.next.val,oneNode.val);
                }
                if(oneNode.val < minNum) minNum = oneNode.val;
                oneNode = oneNode.next;
            }
        }
        //只有一个元素的情况
        if(preMap.size() == 0 ){
            return new ListNode(minNum);
        }
        int flag = 1;
        int preGet = preMap.get(minNum);
        int nextGet = nextMap.get(minNum);
        int coun = preMap.size();
        while(preGet == nextGet && coun>0) {
            preGet = preMap.get(preGet);
            nextGet = nextMap.get(nextGet);
            coun--;
        }
        if(preGet <nextGet){
            flag = 0;
        }
        ListNode head = new ListNode(minNum);
        ListNode scan = head;
        if(flag ==0){
            int num = minNum;
            while(preMap.get(num)!=minNum && preMap.get(num)!=null){
                num = preMap.get(num);
                scan.next = new ListNode(num);
                scan = scan.next;
            }
        }else{
            int num = minNum;
            while(nextMap.get(num)!=minNum && nextMap.get(num)!=null){
                num = nextMap.get(num);
                scan.next = new ListNode(num);
                scan = scan.next;
            }

        }
        return head;

    }
    public static void printListNode(ListNode head){
        ListNode scan = head;
        while(scan!=null){
            System.out.print(scan.val+" ");
            scan = scan.next;
        }
    }
}
