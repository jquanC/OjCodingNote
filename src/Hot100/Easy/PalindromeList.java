package Hot100.Easy;
//递归做法
public class PalindromeList {

 /*
 //递归做法
 private ListNode frontPoint = new ListNode();//递归之外的一个指针，作为类的字段来出现（类似-全局变量，对类而言）

    public boolean recursivelyCheck(ListNode currentNode){
        if(currentNode != null){
            if(!recursivelyCheck(currentNode.next)){ //首先要递归到最后，才能开始判断
                return false;
            }
            //不在往下递归，既本层，本结点的判定，与frontPoint所指的Node应该一样
            if(currentNode.val != frontPoint.val){
                return false;
            }
            frontPoint = frontPoint.next;

        }
        return true;
    }

    public boolean isPalindrome(ListNode head){
        frontPoint = head;
        return recursivelyCheck(head);
    }*/

    //非递归。反转后半部分，比较，再回复链表，使得空间复杂度为O(1)
    public boolean isPalindrome(ListNode head){
        ListNode firstHalfNode = endOfFirstHalf(head);
        ListNode reverseSecondHalfHead = reverseList(firstHalfNode.next);


        //开始比较
        ListNode p1 = head;
        ListNode p2 = reverseSecondHalfHead;

        while(p2!=null){ //该算法后面半部分的链表总是比较短的
            if(p2.val != p1.val){
                return false;
            }
            p2 = p2.next;
            p1 = p1.next;
        }
        //恢复原来的链表
        firstHalfNode.next=reverseList(reverseSecondHalfHead);
        return true;

    }

    //通过快慢指针，可以确定后半部分的链表。不管是偶数长度还是奇数长度，我们都可以找到 后半部分的链表的头节点
    public ListNode endOfFirstHalf(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null){ //链表-移动前先判空
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow ;
    }

    public ListNode reverseList(ListNode head){

        ListNode pre = null;
        ListNode currentNode = head;
        while(currentNode!=null){
            ListNode next = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = next;

        }
        return pre;
    }


}
