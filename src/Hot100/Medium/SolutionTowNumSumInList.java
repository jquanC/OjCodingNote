package Hot100.Medium;

import Hot100.Easy.ListNode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


public class SolutionTowNumSumInList {
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = calValue(l1);
        long num2 = calValue(l2);
        long num = num1 + num2;
        //System.out.println("tow sum="+num);
        return transNumToList(num);

    }

    public long calValue(ListNode listOfNum) {
        int len = 0;
        long num = 0;
        ListNode p = listOfNum;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = listOfNum;
        for (int i = 0; i < len; i++) {
            num += p.val * Math.pow(10, i);
            p = p.next;
        }
        //System.out.println("num="+num);
        return num;
    }

    public ListNode transNumToList(long num) {
        if (num == 0) return new ListNode(0);

        ListNode tail = null;
        ListNode head = null;
        while (num != 0) {
            int remainder = (int)(num % 10);//注意不是(int)num % 10
            ListNode cur = new ListNode(remainder);
            if (head == null) {
                head = cur;

            }else{ //下面这两句代码需要放在 else中； 否则，单个结点链表的情况，就会出现循环链表
                tail.next = cur;

            }
            tail = cur;
            num = num / 10;
        }
        return head;
    }*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remainder = 0;
        int carry =0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null;
        ListNode tail = null;
        while(p1!=null || p2 !=null || carry!=0){ //还要考虑最后carry不为0的情况
            int adder1 = 0;
            int adder2 = 0;
            if(p1!=null && p2!=null){
                adder1 = p1.val;
                adder2 = p2.val;
                p1 = p1.next;
                p2 = p2.next;
            }else if(p1!=null){
                adder1 = p1.val;
                p1 = p1.next;
            }else if(p2!=null){
                adder2 = p2.val;
                p2 = p2.next;
            }else{
                ;
            }

            remainder = (adder1+adder2+carry)%10;
            carry = (adder1+adder2+carry)/10;
            //组织求和链表
            if(head == null){
                head = new ListNode(remainder);
                tail = head;
            }else{
                tail.next = new ListNode(remainder);
                tail = tail.next;
            }

        }

        return head;

    }
}
