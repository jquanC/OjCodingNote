package Hot100;

import Hot100.Medium.ListNode;

public class So50SortListRecurseWay {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);

    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return null; //传入空链时的情况
        if (head.next == tail) {
            head.next = null;
            return head; //递归结束条件 [head，tail）;tail并不是需排序子链表的结点，其作用的tail flag;观察开始的递归调用mergeList(head,null)，null 显然不是要排序结点

        }


        //找到链表的中点
        ListNode fast = head, slow = head;
        while (fast != tail) {   //这里不需要判断fast !=null
            fast = fast.next;
            slow = slow.next;
            if (fast == tail) break;//fast == tail 而不是 fast == null
            else fast = fast.next;

        }
        ListNode mid = slow;
        ListNode sortFirstHalf = sortList(head, slow);
        ListNode sortSecondHalf = sortList(slow, tail);

        //得到2个有序链表，用merge方法合并
        return mergeTwoLists(sortFirstHalf, sortSecondHalf);

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode dumbHead = new ListNode(), cur = dumbHead, scan1 = l1, scan2 = l2;
        while (scan1 != null && scan2 != null) {
            if (scan1.val <= scan2.val) {
                cur.next = scan1;
                cur = cur.next;
                scan1 = scan1.next;
            } else {
                cur.next = scan2;
                cur = cur.next;
                scan2 = scan2.next;
            }
        }
        if (scan1 == null) cur.next = scan2;
        else cur.next = scan1;

        return dumbHead.next;
    }


}
