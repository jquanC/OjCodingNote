package Hot100.Medium;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

public class So49CircleLinkedListII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return null;


        ListNode fast, slow;
        //  fast = head.next.next;//这里先走2步，下面基于数学的关系的判断就出错了
        fast = head;
        slow = head;
        while ( fast != null && fast.next != null) { //fast.next!=null 为了避免空指针异常
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;

        }

        if (fast == null || fast.next == null) return null;//fast.next!=null 为了避免空指针异常
        else { //fast == slow
            ListNode countPos = head;
            while (countPos != slow) {
                slow = slow.next;
                countPos = countPos.next;
            }
            return countPos;
        }

    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        So49CircleLinkedListII so49 = new So49CircleLinkedListII();
        ListNode res = so49.detectCycle(head);


    }

}

