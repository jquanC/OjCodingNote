package SwordOf.list;

import SwordOf.domain.ListNode;

public class GetKthFromEnd {
    /** 题目说了 k>=1
     * */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) return null;

        ListNode scan1 = head;
        ListNode scan2 = head;
        int cou = 1;
        while(scan1.next!=null ){

            if(cou<k){
                scan1 = scan1.next;
                cou++;
            }else{
                scan1 = scan1.next;
                scan2 = scan2.next;
            }
        }
        //如果 k 大于链表的长度
        return cou<k ? null : scan2;

    }
}
