package Hot100.Medium;

import Hot100.Easy.ListNode;

public class So39ListNodePartition {
    public ListNode partition(ListNode head, int x) {

     /*   ListNode largeHead = new ListNode(0);
        ListNode smallHead = new ListNode(0);*/
        ListNode largeHead = new ListNode(0);
        ListNode smallHead = new ListNode(0);
        // 虚拟节点不需要一定指向head;
        // 如果两个虚拟节点都指向head,下面代码在最后可能会成环；又要复杂的逻辑控制
        ListNode small = smallHead, large = largeHead;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = head;
            } else if (head.val >= x) {
                large.next = head;
                large = head;
            }
            head = head.next;

        }

        small.next = largeHead.next;
        large.next = null; //否则可能成环
        return smallHead.next;
    }
}
