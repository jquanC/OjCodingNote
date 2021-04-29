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
    /*答案参考
    *
    * class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
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
