package Qiu.ShengXF;

import Hot100.Easy.ListNode;

public class Main3 {
    public static void main(String[] args) {
        ListNode cur1 = new ListNode(1);
        ListNode cur2 = new ListNode(2);
        ListNode cur3 = new ListNode(3);
        ListNode cur4 = new ListNode(4);
        ListNode cur5 = new ListNode(5);
        ListNode cur6 = new ListNode(6);
        ListNode cur7 = new ListNode(7);
        cur1.next = cur2;
        cur2.next = cur3;
        cur3.next = cur4;
        cur4.next = cur5;
        cur5.next = cur6;
        cur6.next = cur7;
        Main3 so = new Main3();
        ListNode ans = so.reverseBetween(cur1);
        while(ans!=null){
            System.out.println(ans.val+" ");
            ans = ans.next;
        }
    }
    public ListNode reverseBetween (ListNode head) {
        ListNode scan = head;
        while(scan.next.val!=3){
            scan = scan.next;
        }
        scan.next = reverse(scan.next);
        return head;


    }
    public ListNode reverse(ListNode head){
        ListNode virtualHead = new ListNode(-1);
        ListNode scan = head;
        ListNode next =  scan.next;
        while(scan.val!=7){
            scan.next = virtualHead.next;
            virtualHead.next = scan;
            scan = next;
            next = scan.next;
        }
        head.next = scan;
        return virtualHead.next;

    }
}
