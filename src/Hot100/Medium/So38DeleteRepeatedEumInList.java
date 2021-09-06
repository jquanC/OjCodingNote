package Hot100.Medium;

import Hot100.Easy.ListNode;

//只保留原始链表中 没有重复出现 的数字
/*
 *
 * */
public class So38DeleteRepeatedEumInList {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dumb = new ListNode(0, head);
        if (head == null) return null;

        ListNode cur = dumb; //实际上，只有2个额外的指针； cur.next cur.next.next 都是一个指针在维护的

        while ( cur.next != null && cur.next.next != null) { //只有头节点的情况也满足

            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) { //值是x的结点均不予保留
                    cur.next = cur.next.next; // 原来的cur.next 被删除；cur.next.next自动更新 ; cur 总是指向一个无重复(被接纳)节点
                }

            } else {
                cur = cur.next;
            }

        }
        return dumb.next;
    }


}
