package Hot100.Medium;

import java.lang.reflect.Array;
import java.util.*;
/*
 * 链表排序适合用归并排序；
 * 因为合并两个有序链表的操作是方便的；
 * */

public class So50SortedLinkedList {
    public ListNode sortList(ListNode head) {
        ListNode dumbHead = new ListNode(0, head);
        ListNode scan = dumbHead.next;
        int length = 0;
        while (scan != null) {
            length++;
            scan = scan.next;
        }

        int subLen = 1;
        for (; subLen < length; subLen <<= 1) { //note <<=1 ; 退出循环条件是 subLen < length , subLen = length/2 是还需要做最后一次合并的，subLen每次*2
            ListNode cur = dumbHead.next;//要求：每一趟归并回来，所有结点还是一条完好的链表；cur:纪录每次拆分链表的位置
            ListNode pre = dumbHead;//
            pre.next = null;

            while (cur != null) { //对每一个subLen,需要将链表从头到尾进行拆分；cur == null 说明一趟拆分结束
                ListNode head1 = cur;
                for (int i = 1; i < subLen && cur.next != null; i++) { //纪录(每一对要合并)第一个子链表的头
                    cur = cur.next;
                }
                //拆分得到第一个子链表
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                //寻找第二个子链表需要拆分的位置
                for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null; //next 纪录下一对拆分的起始结点
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }

                ListNode mergeHead = mergeTwoLists(head1, head2);
                while (pre.next != null) { //初始时pre = dumbHead,这样对于第一对合并的子链表，自动就接到了dumbHead后面
                    pre = pre.next;
                }
                pre.next = mergeHead;
                cur = next;

            }
        }
        return dumbHead.next;
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1==null || l2 ==null) return l1 == null? l2 :l1;

        ListNode dumbHead = new ListNode(), cur=dumbHead, scan1 = l1, scan2 = l2;
        while(scan1 != null && scan2 !=null){
            if(scan1.val<=scan2.val){
                cur.next = scan1;
                cur = cur.next;
                scan1 = scan1.next;
            }else{
                cur.next = scan2;
                cur = cur.next;
                scan2 = scan2.next;
            }
        }
        if(scan1 == null) cur.next = scan2;
        else cur.next = scan1;

        return dumbHead.next;
    }


}
