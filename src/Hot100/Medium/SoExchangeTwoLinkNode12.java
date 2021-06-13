package Hot100.Medium;

import Hot100.Easy.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class SoExchangeTwoLinkNode12 {
    //非递归解
   /* public ListNode swapPairs(ListNode head){
        ListNode dumpHead = new ListNode();
        dumpHead.next = head;
        ListNode temp = dumpHead;
        while(temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dumpHead.next;

    }*/
    //递归
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next ==null){ // 如果链表为空，或者只有一个结点，那么递归终止
            return head;
        }
        /*否则交换两个结点，交换结束后，第一个结点变为第二个，第二个变为第一个*/
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return  newHead;


    }
}
