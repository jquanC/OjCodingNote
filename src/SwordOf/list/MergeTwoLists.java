package SwordOf.list;

import SwordOf.domain.ListNode;

public class MergeTwoLists {
    /*两条链；当前的比你小，且下一个比你大，才修改*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return  l2;
        if(l2 == null) return  l1;

        ListNode newHead;
        if(l1.val <=  l2.val){
            newHead = l1;
            newHead.next = mergeTwoLists(l1.next,l2);
        }else{
            newHead = l2;
            newHead.next = mergeTwoLists(l1,l2.next);
        }
        return newHead;

    }
    /*非递归代码*/
   /* class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dum = new ListNode(0), cur = dum;
            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                }
                else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 != null ? l1 : l2;
            return dum.next;
        }
    }
*/

}
