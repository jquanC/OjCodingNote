package Hot100.Medium;

import Hot100.Easy.ListNode;

public class So25RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k){
        if(head == null|| k==0) return head;
        int listLen=0;
        ListNode scan = head;
        while(scan != null){
            listLen++;
            scan = scan.next;
        }
        k = k%listLen;
        if(k==0) return head;

        ListNode newHead = head;
        int newHeadLoc = listLen - k;
        for(int i =0;i<newHeadLoc;i++){
            newHead = newHead.next;
        }
        scan = newHead;
        while(scan.next != null){
            scan = scan.next;
        }
        scan.next = head ;
        while(scan.next != newHead){
            scan = scan.next;
        }
        scan.next = null;
        return newHead;
    }

}
