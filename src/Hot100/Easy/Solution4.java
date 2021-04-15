package Hot100.Easy;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//这是不带头节点的单链表
class Solution4 {
    public ListNode reverseList(ListNode head) {
        ListNode workNode = head;
        ListNode nextNode = head.next;
        ListNode preNode = null;
        //head 的情况要单独处理

        workNode.next = null;
        preNode = workNode;
        workNode = nextNode;
        nextNode = nextNode.next;
        while (workNode != null) {

            workNode.next = preNode;
            preNode = workNode;
            workNode = nextNode;
            nextNode = (nextNode==null) ? null : nextNode.next;
        }

        return preNode; //这是不带头节点的单链表
    }
}
